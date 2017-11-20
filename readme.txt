------------------------Cucumber Installation--------------------------------------------------

1. Open terminal and run the following command to pull down a copy of the 'cucumber' repo :

	git clone https://{username}@git.sparkred.com/scm/rhw/cucumber.git

2. Navigate to 'cucumber' directory and run following command to generate project structure based on your IDE:

	./gradlew eclipse OR ./gradlew idea

3. Open 'cucumber' in Eclipse by doing : File > Import > Existing Projects into Workspace and browse to the ‘cucumber’ folder and open it.

4. To download gradle on system and to build project execute the following command : 
 
	./gradlew build

-------------------------Execution---------------------------------------------------------------

1. To execute all test scenarios execute the following command :

	./gradlew clean test -Denv.browser=chrome -Denv.driverPath=drivers/mac/chromedriver_x64_2_33

	---Note--- 
   -Here we are selecting chrome browser for our test execution.
   -Here we are giving chrome driver path according to Mac OS (If new drivers are needed then add them to the drivers directory)

2. To execute only one scenario using tag, add "-Dcucumber.options=<value>" to gradle command.
   For e.g. Following command will execute all the scenarios with '@cart' tag :
	
	./gradlew clean test -Denv.browser=chrome -Denv.driverPath=drivers/mac/chromedriver_x64_2_33 -Dcucumber.options=" --tags @cart"

3. To change chrome execution mode, add "-Denv.mode=<value>" to gradle command.
   For e.g. Following command will execute tests in grid mode on chrome :
	
	./gradlew clean test -Denv.browser=chrome -Denv.driverPath=drivers/mac/chromedriver_x64_2_33 -Denv.mode=grid

	---Note---
   -Chrome has following modes:-
	-normal(Default)
	-headless
	-grid
	-incognito

4. To select environment to run test cases, add "-Denv.urlPrefix=<value>" in gradle command.
   For e.g. Following command will execute tests on 'stg-www.' environment :

	./gradlew clean test -Denv.browser=chrome -Denv.driverPath=drivers/mac/chromedriver_x64_2_33 -Denv.urlPrefix=stg-www.

	---Note---
   -By deafult urlPrefix is "www."

-----------------------END OF README--------------------------------------------------