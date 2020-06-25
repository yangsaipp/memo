pipeline {
    agent any

    stages {
        
		stage('Build') {
            steps {
				// steps里只能是方法，不能有if和def
				bat(/gradle build/)
            }
        }
		stage('Build2') {
            steps {
				// 若有if和def，则写在script中
				script {
					def mvnHome = tool 'gradle-3.3'
					// Run the maven build
					if (isUnix()) {
						sh "'${mvnHome}/bin/gradle' build"
					} else {
						bat(/"${mvnHome}\bin\gradle" build/)
					}
				
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