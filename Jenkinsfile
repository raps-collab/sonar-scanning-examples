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
			sh '/home/jenkins/sonar-scanner-4.5.0.2216-linux/bin/sonar-scanner -Dproject.settings=maths/sonar-scanner.properties'
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
