pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }
    environment {
         PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
               JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17'  // Adjust to your actual JDK pat
            SONARQUBE_SERVER = 'SonarQubeServer'  // The name of the SonarQube server configured in Jenkins
            SONAR_TOKEN = 'sqa_01cd847d3e1b2a091ff5a52eb8af9ac99e974b83' // Store the token securely
            DOCKERHUB_CREDENTIALS_ID = 'Docker_Hub'
            DOCKERHUB_REPO = 'saeid1993/sep2_week5_f2025'
            DOCKER_IMAGE_TAG = 'latest'


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
     stage('Build Docker Image') {
                        steps {
                            script {
                                docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                                // Or specify Dockerfile path explicitly if needed
                                // docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}", "-f ./Dockerfile .")
                            }
                        }
                    }

                    stage('Push Docker Image to Docker Hub') {
                        steps {
                            script {
                                docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                                    docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                                }
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
