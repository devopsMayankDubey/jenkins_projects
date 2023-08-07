pipeline{
  options{
    buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
  }

  agent any

  tools {
      maven 'maven_3.8.8'
    }
  stages{
    stage('Code Compile'){
	  steps{
	  echo 'Code compile starting'
	  sh 'mvn clean compile'
	  echo 'Done compiling code'
	  }
	}
    stage('Sonarqube Code Quality') {
       environment {
          scannerHome = tool 'SonarQubeScanner'
       }
       steps {
         withSonarQubeEnv('sonar-server') {
            sh "${scannerHome}/bin/sonar-scanner"
            sh 'mvn sonar:sonar'
         }
         timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
         }
       }
    }
	stage('Code Test'){
	  steps{
	  echo 'Code Test starting'
	  sh 'mvn clean test'
	  echo 'Code Testing completed'
	  }
	}
	stage('Code Package'){
	  steps{
	  echo 'Code package starting'
	  sh 'mvn clean package'
	  echo 'Code Package Done'
	  }
	}
	stage('Building & Tag Docker Image') {
      steps {
        echo 'Starting Building Docker Image'
        sh 'docker build -t jenkins_projects .'
        echo 'Completed  Building Docker Image'
      }
    }
	stage('Upload the docker Image to Nexus') {
       steps {
          script {
             withCredentials([usernamePassword(credentialsId: 'nexuscred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
             sh 'docker login http://13.212.80.112:8085/repository/radical/ -u admin -p ${PASSWORD}'
             echo "Push Docker Image to Nexus : In Progress"
             sh 'docker tag jenkins_projects 13.212.80.112:8085/jenkins_projects:latest'
             sh 'docker push 13.212.80.112:8085/jenkins_projects:latest'
             echo "Push Docker Image to Nexus : Completed"
             }
          }
       }
    }

  }
}