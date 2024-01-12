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
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                 script {
                    gv.buildImage()
                }
            }
        }
        stage('pushImage'){
             when {
                expression 
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                 script {
                    gv.pushImage()
                }
            }
        }
    }
}



