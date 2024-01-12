def gv
pipeline {
    agent any
    tools {
        maven 'mymaven'
    }
    stages {
        stage('init'){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build'){
            steps {
                script {
                    gv.build()
                }
            }
        }
        stage('test'){
            steps {
                 script {
                    gv.test()
                }
            }
        }
        stage('buildImage'){
            steps {
                 script {
                    gv.buildImage()
                }
            }
        }
        stage('pushImage'){
            steps {
                 script {
                    gv.pushImage()
                }
            }
        }
    }
}



