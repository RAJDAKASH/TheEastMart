package com.eastmart.aipackage;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import opennlp.tools.doccat.DoccatFactory;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizer;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.ml.AbstractTrainer;
import opennlp.tools.ml.naivebayes.NaiveBayesTrainer;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.TrainingParameters;

public class TrainData {
	public static  DoccatModel model;
	
	
	
	/**
	 * Main method in java defined to call the function from this class only
	 */
	/*
	 * public static void main(String[] args) { trainDataCreateModel();
	 * predictDefect("unknown element exception");
	 * 
	 * }
	 */
	
	public static void trainDataCreateModel() {
	
	try {
	 InputStreamFactory dataIn = new MarkableFileInputStreamFactory(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\eastmart\\aipackage\\en-defect-category.train"));
     ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
     ObjectStream sampleStream = new DocumentSampleStream(lineStream);

     // define the training parameters
     TrainingParameters params = new TrainingParameters();
     params.put(TrainingParameters.ITERATIONS_PARAM, 10+"");
     params.put(TrainingParameters.CUTOFF_PARAM, 0+"");
     params.put(AbstractTrainer.ALGORITHM_PARAM, NaiveBayesTrainer.NAIVE_BAYES_VALUE);

     // create a model from traning data
     model = DocumentCategorizerME.train("en", sampleStream, params, new DoccatFactory());
     System.out.println("\nModel is successfully trained.");
     
     // save the model to local
     BufferedOutputStream modelOut = new BufferedOutputStream(new FileOutputStream(System.getProperty("user.dir")+"\\src\\main\\java\\\\com\\eastmart\\aipackage\\en-defect-classifier-naive-bayes.bin"));
     model.serialize(modelOut);
     System.out.println("\nTrained Model is saved locally at : "+"model"+File.separator+"en-defect-classifier-naive-bayes.bin");

	}
	catch(Exception e) {
		 System.out.println("An exception in reading the training file. Please check.");
         e.printStackTrace();
	}
	}
	
	public static void predictDefect(String errorDescription) {
		try {
		 DocumentCategorizer doccat = new DocumentCategorizerME(model);
         String[] docWords = errorDescription.replaceAll("[^A-Za-z]", " ").split(" ");
         double[] aProbs = doccat.categorize(docWords);

         // print the probabilities of the categories
         System.out.println("\n---------------------------------\nCategory : Probability\n---------------------------------");
         for(int i=0;i<doccat.getNumberOfCategories();i++){
             System.out.println(doccat.getCategory(i)+" : "+aProbs[i]);
         }
         System.out.println("---------------------------------");
		}
		catch(Exception e) {
			 System.out.println("An exception in predicting category. Please check.");
	            e.printStackTrace();
		}

    
	}

}
