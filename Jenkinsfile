pipeline {
	agent any
	parameters {
		choice(name: 'BROWSER', choices: 'chrome\nfirefox\nPhantomJS', description: 'Select Browser')
		choice(name: 'MODE', choices: 'grid', description: 'Select browser mode')
		string(name: 'DRIVER', defaultValue: 'drivers/linux/chromedriver_2_33', description: 'Enter Driver Path')
        choice(name: 'TARGET', choices: 'stg-www.\nstg2-www.\nwww.', description: 'Select Staging Environment')
        choice(name: 'SELENIUM_GRID_NODE', choices: '3\n1\n2\n4\n5\n6\n7\n8\n9\n10', description: 'Select number of Nodes want to register')
        string(name: 'TAGS', defaultValue: '--tags @anonymous', description: 'Enter tags here')
    }
    options {
		buildDiscarder(logRotator(numToKeepStr: '10'))
        timeout(time: 1, unit: 'HOURS') 
    }
	stages {
			stage('Grid up') {
            		steps {
                		sh "docker-compose down"
						sh "docker-compose up -d"
						sh "docker-compose scale chrome=${params.SELENIUM_GRID_NODE}"
        	    	}
        	}
			stage('Test setup') {
            		steps {
                		sh "./gradlew clean test -Denv.mode=${params.MODE} -Denv.urlPrefix=${params.TARGET} -Denv.browser=${params.BROWSER} -Denv.driverPath=${params.DRIVER} -Dcucumber.options=\"--tags @setup\""
        	    	}
        	}
    		stage('Test') {
            		steps {
                		sh "./gradlew clean test -Denv.mode=${params.MODE} -Denv.urlPrefix=${params.TARGET} -Denv.browser=${params.BROWSER} -Denv.driverPath=${params.DRIVER} -Dcucumber.options=\"${params.TAGS}\""
        	    	}
        	}
	}
	post { 
        	always {
        			cucumber fileIncludePattern: '**/*.json', sortingMethod: 'ALPHABETICAL' 
            		sh "docker-compose down"
        	}
	}
}
