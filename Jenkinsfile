pipeline {
    agent any

    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }

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
