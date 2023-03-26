pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t=vivekkaushik82/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'DockerhubCreds', passwordVariable: 'Password', usernameVariable: 'Username')]) {
                    //sh
			        bat "docker login --username=${Username} --password=${Password}"
			        bat "docker push vivekkaushik82/selenium-docker:latest"
			    }                           
            }
        }
    }
}