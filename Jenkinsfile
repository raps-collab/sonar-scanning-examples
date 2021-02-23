pipeline {
   agent any
   stages {
       stage('Eshwar') {
        steps {
            snDevOpsStep()
        }
       }
      stage('Hello') {
         steps {
            snDevOpsStep()
            //snDevOpsChange()
            echo 'Hello World'
         }
      }
     stage('SCM') {
         steps{
            git 'https://github.com/eshwarmolugu/sonar-scanning-examples.git'
		sh 'mvn clean install'
         }
     }
    stage('SonarQube analysis') {
        steps{
            echo 'Hello Sonar Cube  World'
            withSonarQubeEnv('SonarQube_Local') {
            echo 'running in sonar env'
			sh 'sonarScanner -Dproject.settings=/Users/eshwar.molugu/git/app-devops-jenkins/work/tools/hudson.plugins.sonar.SonarRunnerInstallation/sonarScanner/conf/sonar-scanner.properties'
			post {
				always {
					sh 'curl --location --request GET "http://localhost:9000/api/issues/search?project=1234abcd&resolved=false" > sonar.json'
					sh 'cat sonar.json'
				}
			}
            } 
        }
    }
    }
   
}
