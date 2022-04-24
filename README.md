#TheEastMart

SELENIUM Framework with AI/ML capabilities ( Artificial Intelligence/ Machine Learning)
'
GitHub :- https://github.com/RAJDAKASH/TheEastMart.git

/**********************************************************************************************
/**********************************************************************************************



								AI/ML capabilities ( Artificial Intelligence/ Machine Learning)

Idea :- To predict if a failure occurring in selenium test is VALID or INVALID

Natural Language Processing Library of java is used :- Open NLP

AI Part :- 

Past Data of valid and Invalid Defects is collected.
Data is used to train and create a model.

Model is then used to run the failure message and get the probability of the failure being a valid or an Invalid defect.
Naive Bayes algorithm is used to train the data on given data set.

ML part:- 

The data upon categorization as VALID or INVALID can be fed to data set upon which the model is trained.
Newly trained model can be used to predict failures as VALID or INVALID 


/**********************************************************************************************
/**********************************************************************************************
How to Run?

Runs on 2 modes :- 
	1.Local machine 
	2.Docker Selenium Grid 

Framework accepts 1 parameter "hubUrl"

If hubUrl is given ( say :- selenium grid url :- http://localhost:4444/wd/hub)
then parameter is :  -DhubUrl="http://localhost:4444/wd/hub"

If there is no Hub and Tests are needed to be run on local 
then parameter is :  -DhubUrl="NA"

/**********************************************************************************************
/**********************************************************************************************

The Running command

pre-requisites for running on local machine : JAVA, Maven should be installed on system for running on local

	: 1. Running on local machine
	
		. Open Command prompt or terminal
		. Navigate to root project directory ( where project is located )
		
		. Run command :- 
						mvn clean test -DhubUrl="NA"

/**********************************************************************************************
/**********************************************************************************************

The Running command

pre-requisites for running on Docker Selenium Grid : JAVA, Maven,Docker should be installed on system for running on local		
	
	: 2. Running on selenium grid with Docker
	
		. Open Command prompt or terminal
		. Navigate to root project directory ( where project is located )
		. run command : 
						docker-compose up   
						 
		( it runs the docker-compose.yml file present in project. It brings the selenium Grid up both Hub and node)
		. Then open another command prompt and run command 
						
						mvn clean test -DhubUrl="http://localhost:4444/wd/hub"	
						

/**********************************************************************************************
/**********************************************************************************************

The docker nodes can be scaled up using command : docker-compose up --scale chrome=3   
any no of chrome nodes can be given according to need.

/**********************************************************************************************
/**********************************************************************************************

Features of framework  :-
	1. Data Driven
	2. Log4j logging capabilities
	3. Configured with extent reports
	4. Configured with WebDriverManager
	5. Configured with Selenium Grid
	5. Docker Run enabled
	6. Unit Tests included 
	7. Project is upload to GitHub   :- https://github.com/RAJDAKASH/TheEastMart.git
	8. AI/ML capabilities ( Artificial Intelligence/ Machine Learning)
	
/**********************************************************************************************
/**********************************************************************************************


