pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
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
