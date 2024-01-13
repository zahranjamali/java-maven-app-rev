#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'mymaven'
    }
    stages {
        stage('incrementVersion') {
            steps {
                script {
                    echo 'incrementing the version'
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                        def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                        def version = matcher[0][1]
                        env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }
        stage('buildJar'){
            steps {
                script {
                    echo 'building the jar file with version bumping'
                    sh 'mvn clean package'
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
                    echo "building the image"
                    sh "docker build -t zahranjamali/myrepo:${IMAGE_NAME} ."
                    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                                sh "echo $PASS | docker login -u $USER --password-stdin"
                                sh "docker push zahranjamali/myrepo:${IMAGE_NAME}"
                    }
                }
            }
        }
        stage('commit version bumping') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'GITHUB_CREDS', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'git config --global user.email "jenkins@example.com"'
                        sh 'git config --global user.name "Jenkins"'

                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'

                        sh "git remote set-url origin https://${USER}:${PASS}@github.com/zahranjamali/java-maven-app-rev.git"
                        sh 'git add .'
                        sh 'git commit -m 'commit version bumping''
                        sh 'git push origin HEAD:feature/version-bump'
'
                    }
                }
            }
        }
    }
}



