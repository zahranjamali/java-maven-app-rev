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
                    buildImage 'zahranjamali/myrepo:java-maven-app-rev-2.0'
                }
            }
        }
        stage('pushImage'){
            steps {
                 script {
                    pushImage 'zahranjamali/myrepo:java-maven-app-rev-2.0'
                }
            }
        }
    }
}



