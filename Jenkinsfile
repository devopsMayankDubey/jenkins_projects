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
        sh 'docker build -t mayank0501/jenkinspro .'
        sh 'docker build -t jenkinspro .'
        echo 'Completed  Building Docker Image'
      }
    }
	stage(' Docker push to Docker Hub') {
      steps {
        script {
          withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
          sh 'docker login docker.io -u mayank0501 -p ${dockerhubCred}'
          echo "Push Docker Image to DockerHub : In Progress"
          sh 'docker push mayank0501/jenkinspro:latest'
          echo "Push Docker Image to DockerHub : In Progress"
          sh 'whoami'
          }
        }
      }
    }
	stage('Upload the docker Image to Nexus') {
       steps {
          script {
             withCredentials([usernamePassword(credentialsId: 'nexuscred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
             sh 'docker login http://3.110.62.181:8085/repository/jenkins_projects/ -u admin -p ${PASSWORD}'
             echo "Push Docker Image to Nexus : In Progress"
             sh 'docker tag jenkins_projects 3.110.62.181:8085/jenkins_projects:latest'
             sh 'docker push 43.204.229.125:8085/jenkins_projects'
             echo "Push Docker Image to Nexus : Completed"
             }
          }
       }
    }

  }
}