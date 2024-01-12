#!/usr/bin/env groovy

@Library('jenkins-shared-lib-rev')_

pipeline {
    agent any
    tools {
        maven 'mymaven'
    }
    stages {
        stage('buildJar'){
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage('test'){
            steps {
                 script {
                    echo 'testing the app'
                }
            }
        }
        stage('buildImage'){
            steps {
                 script {
                    buildImage 'zahranjamali/myrepo:java-maven-app-rev-3.0'
                    dockerLogin()
                    dockerPush 'zahranjamali/myrepo:java-maven-app-rev-3.0'
                }
            }
        }
    }
}



