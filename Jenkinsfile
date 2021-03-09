pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'eshwar'
      }
    }
    stage('Build') {
      steps {
        echo 'build'
	      mvn clean install
      }
    }
    stage('CodeQuality') {
      steps {
        echo 'codquality'
      }
    }
    stage('UAT') {
      steps {
	      echo'UAT'
      }
    }
    stage('Prod') {
	    environment {
    		 SCANNER_HOME = tool 'sonarScanner'
   		 //ORGANIZATION = "igorstojanovski-github"
    		 //PROJECT_NAME = "igorstojanovski_jenkins-pipeline-as-code"
  		}
      steps {
        echo 'prod'
	      //sh 'def scannerHome = tool 'SonarScanner 4.0';'
	       withSonarQubeEnv('SonarQube_Cloud') {
		     // sh 'sonarScanner -Dproject.settings=sonar-scanner.properties'
		      // sh './gradlew sonarqube'
		      // println ${env.SONAR_HOST_URL}
		       sh '${SCANNER_HOME}/bin/sonar-scanner -Dproject.settings=${SCANNER_HOME}/conf/sonar-scanner.properties'
		       
        }
      }
    }
    stage('TestChange') {
      steps {
        echo 'TestChange'
        //sleep(60)
        //snDevOpsChange()

      }
    }
    stage('UAT test') {
      parallel {
        stage('UAT test test1') {
          steps {
            echo 'test'
          }
          post {
            success {
              echo 'test'
            }
          }
        }
        stage('UAT static code test') {
          steps {
            //snDevOpsChange()
           
            echo 'test'
            
          }
        }
      }
    }

  }
}
