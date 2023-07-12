pipeline{
  options{
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '5'))
    }
	agent any
	tools{
        maven 'maven3.8.8'
    }
  stages{
    stage('code compilation'){
	  steps{
	    echo "code compilation is started"
		sh 'mvn clean compile'
		echo "code compilation is completed"
	  }
	}
	stage('code test'){
	  steps{
	    echo "Code testing is started"
		sh 'mvn clean test'
		echo "Code test is completed"
	  }
	}
	stage('code package'){
	  steps{
	    echo "code packaging is started"
		sh 'mvn clean package'
		echo "code pacaging is completed"
	  }
	}
  }
}