
pipeline {
    agent any
    
    environment {
        PATH = "/opt/gradle/gradle-4.7/bin:/opt/vagrant:$PATH"
        RESOURCE_SERVER = '192.168.50.100'
        RESOURCE_SERVER_ROOT = '/home/user/resources'
        PHANTOMJS_PATH = '/usr/local/bin/phantomjs'
    }
    
    stages {
	stage('Preparation') {
		steps {
   		 git(url: 'https://github.com/ediordna/parcelSizeComponent', branch: 'master')
		}
	}
	stage('Build') {
		steps {
			//sh 'gradle clean unitTest shadowJar'
  			 withCredentials(bindings: [sshUserPrivateKey(credentialsId: 'resource_server', \
                                             keyFileVariable: 'RESOURCE_SERVER_KEY', \
                                             usernameVariable: 'RESOURCE_SERVER_USER')]) {
                     		sh './scripts/build_docker.sh'  
                	}
          	  }
	}
    }
}

