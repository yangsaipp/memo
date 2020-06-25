pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                def mvnHome = tool 'gradle-3.3'
				// Run the maven build
				if (isUnix()) {
					sh "'${mvnHome}/bin/gradle' build"
				} else {
					bat(/"${mvnHome}\bin\gradle" build/)
				}
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}