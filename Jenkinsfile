pipeline {
    agent any
    tools {
        maven 'mymaven'
    }
    stages {
        stage('Build'){
            steps {
                script {
                    sh 'mvn package'
                }
            }
        }
        stage('Test'){
            steps {
                 script {
                    echo "testing the image"
                }
            }
        }
        stage('buildImage'){
            steps {
                 script {
                    echo "building the image"
                    sh 'docker build -t java-maven-app-rev:1.1 .'
                }
            }
        }
        stage('pushImage'){
            steps {
                 script {
                    echo "pushing to docker hub"
                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push zahranjamali/myrepo:java-maven-app-rev:1.1'
                    }
                }
            }
        }
    }
}



