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
      steps {
        echo 'prod'
	       withSonarQubeEnv('SonarQube_Cloud') {
		      sh 'sonarScanner -Dproject.settings=sonar-scanner.properties'
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
