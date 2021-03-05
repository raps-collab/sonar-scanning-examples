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
          sh '/Users/eshwar.molugu/git/app-devops-jenkins/work/tools/hudson.plugins.sonar.SonarRunnerInstallation/sonarScanner/bin/sonar-scanner -Dproject.settings=/Users/eshwar.molugu/git/app-devops-jenkins/work/tools/hudson.plugins.sonar.SonarRunnerInstallation/sonarScanner/conf/sonar-scanner2.properties'
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
            withSonarQubeEnv('SonarQube_Cloud') {
          sh '/Users/eshwar.molugu/git/app-devops-jenkins/work/tools/hudson.plugins.sonar.SonarRunnerInstallation/sonarScanner/bin/sonar-scanner -Dproject.settings=/Users/eshwar.molugu/git/app-devops-jenkins/work/tools/hudson.plugins.sonar.SonarRunnerInstallation/sonarScanner/conf/sonar-scanner2.properties'
        }
            echo 'test'
            
          }
        }
      }
    }

  }
}
