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

                bat 'mvn clean verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {

                withSonarQubeEnv('SonarQubeServer') {

                    bat 'mvn sonar:sonar -Dsonar.login=%SONAR_TOKEN_PSW%'
                }
            }
        }
    }

    post {
        always {

            cleanWs()
        }
    }
}
