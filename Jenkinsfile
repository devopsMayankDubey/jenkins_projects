pipeline{
  options{
    buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
  }

  agent any

  tools {
      maven 'maven3.8.8'
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
  }
}