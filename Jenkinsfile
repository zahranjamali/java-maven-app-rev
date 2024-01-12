pipeline {
    agent any
    tools {
        maven 'mymaven'
    }
    parameters {
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
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
                    sh 'echo "testing the image"'
                }
            }
        }
        stage('buildImage'){
            steps {
                 script {
                    sh 'echo "building the image"'
                    'docker build -t java-maven-app-rev:1.1 .'
                }
            }
        }
        stage('pushImage'){
            steps {
                 script {
                    echo "pushing to docker hub"
                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable 'USER')]){
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push zahranjamali/java-maven-app-rev:1.1'
                    }
                }
            }
        }
        post {
            success {
                sh 'echo successful'
            }
            failure {
                sh 'echo failed'
            }
        }
    }
}



