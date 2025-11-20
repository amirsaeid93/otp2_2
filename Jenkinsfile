pipeline {
    agent any

    tools {
        // Make sure 'JDK-17' is the name of a JDK installation in your Jenkins Global Tool Configuration
        jdk 'JDK-17' 
        // Make sure 'M3' is the name of a Maven installation in your Jenkins Global Tool Configuration
        maven 'MAVEN_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                // Fetches the code from the Git repository configured in the Jenkins job
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Runs Maven to compile, run tests, and generate JaCoCo coverage report
                sh 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // 'MySonarQube' must match the name you gave your SonarQube server in Jenkins settings
                withSonarQubeEnv('MySonarQube') { 
                    // The 'mvn sonar:sonar' command sends the analysis to SonarQube
                    // The -Dsonar.login uses the token we configured in Jenkins
                    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN_PSW'
                }
            }
        }
    }

    post {
        always {
            // Clean up the workspace after the build
            cleanWs()
        }
    }
}
