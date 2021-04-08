pipeline {
agent any
//tools {
  //  maven "Maven_Local"
 // }
  stages {
    stage('Initialize') {
      steps {
        echo 'eshwar'
	      //sh 'mvn clean install'
	snDevOpsChange()
      }
    }
    stage('Build') {
      steps {
        echo 'build'
	    // sh  'mvn clean install'
      }
    }
    stage('CodeQuality') {
	     when {
                branch 'dev' 
            }
     environment {
    			 SCANNER_HOME = tool 'sonarScanner'
   				 //ORGANIZATION = "igorstojanovski-github"
    		 		//PROJECT_NAME = "igorstojanovski_jenkins-pipeline-as-code"
  				}
      			steps {
       				 echo 'CodeQuality'
	     			 //sh 'def scannerHome = tool 'SonarScanner 4.0';'
	     			  withSonarQubeEnv('SonarQube_Cloud') {
		   		  //  sh “/usr/local/apache-maven/apache-maven-3.3.9/bin/mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=admin -Dsonar.password=admin -Dsonar.github.repository=bvelivala/SampleInsurance -Dsonar.projectName=Autoclaim_${BUILD_NUMBER} -Dsonar.projectVersion=${BUILD_NUMBER} -Dsonar.sources=src/main”
		    		 // sh 'sonarScanner -Dproject.settings=sonar-scanner.properties'
		    		  // sh './gradlew sonarqube'
		      		// println ${env.SONAR_HOST_URL}
		      		 sh '${SCANNER_HOME}/bin/sonar-scanner -Dproject.settings=${SCANNER_HOME}/conf/sonar-scanner.properties'
		       
       				}
			}
    }
    stage('UAT') {
      steps {
	      echo'UAT'
      }
    }
    stage('Prod') {
	     when {
                branch 'master' 
            }
	    environment {
    		 SCANNER_HOME = tool 'sonarScanner'
   		 //ORGANIZATION = "igorstojanovski-github"
    		 //PROJECT_NAME = "igorstojanovski_jenkins-pipeline-as-code"
  		}
      steps {
        echo 'prod'
	      //sh 'def scannerHome = tool 'SonarScanner 4.0';'
	       withSonarQubeEnv('Sonar_Cloud') {
		     //  sh “/usr/local/apache-maven/apache-maven-3.3.9/bin/mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=admin -Dsonar.password=admin -Dsonar.github.repository=bvelivala/SampleInsurance -Dsonar.projectName=Autoclaim_${BUILD_NUMBER} -Dsonar.projectVersion=${BUILD_NUMBER} -Dsonar.sources=src/main”
		     // sh 'sonarScanner -Dproject.settings=sonar-scanner.properties'
		      // sh './gradlew sonarqube'
		      // println ${env.SONAR_HOST_URL}
		       sh '${SCANNER_HOME}/bin/sonar-scanner -Dproject.settings=${SCANNER_HOME}/conf/sonar-scanner-cloud.properties'
		       
        }
      }
    }
    stage('TestChange') {
	    when {
                branch 'dev' 
            }
	    stages{
		    stage('TestChangeNestedStage'){
			    steps {
       				 echo 'TestChange'
       				 //sleep(60)
      				  //snDevOpsChange()
				sh 'mvn clean test'
     				 }
			    post{
				    always{
				junit '**/target/surefire-reports/*.xml'
				    }
			    }
		    }
	    }
      
    }
    stage('UAT test') {
	    when {
                branch 'dev' 
            }
	stages{
        	stage('MultiStage') {
          		 environment {
    			 SCANNER_HOME = tool 'sonarScanner'
   				 //ORGANIZATION = "igorstojanovski-github"
    		 		//PROJECT_NAME = "igorstojanovski_jenkins-pipeline-as-code"
  				}
      			steps {
       				 echo 'prod'
	     			 //sh 'def scannerHome = tool 'SonarScanner 4.0';'
	     			  withSonarQubeEnv('SonarQube_Cloud') {
		   		  //  sh “/usr/local/apache-maven/apache-maven-3.3.9/bin/mvn sonar:sonar -Dsonar.host.url=$SONAR_HOST_URL -Dsonar.login=admin -Dsonar.password=admin -Dsonar.github.repository=bvelivala/SampleInsurance -Dsonar.projectName=Autoclaim_${BUILD_NUMBER} -Dsonar.projectVersion=${BUILD_NUMBER} -Dsonar.sources=src/main”
		    		 // sh 'sonarScanner -Dproject.settings=sonar-scanner.properties'
		    		  // sh './gradlew sonarqube'
		      		// println ${env.SONAR_HOST_URL}
		      		 sh '${SCANNER_HOME}/bin/sonar-scanner -Dproject.settings=${SCANNER_HOME}/conf/sonar-scanner.properties'
		       
       				}
     			 }
        }
	    }
    }

  }
}
