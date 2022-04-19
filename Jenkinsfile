#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    def dockercmd ='docker run -d -p8080:8080 ilumiles/my-repo-app:a-1.0'
                    echo "deploying"
                    sshagent(['ec2-server']) {
                        sh " ssh -o StrictHostKeyChecking=no ec2-user@107.23.166.103 ${dockercmd}"
                        }
                    gv.deployApp()
                }
            }
        }
    }   
}
