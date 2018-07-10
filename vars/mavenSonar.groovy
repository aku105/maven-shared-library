#!/usr/bin/env groovy

def call(String mavenVersion = 'maven:3.5.0-jdk-8', String sonarCredential = 'sonar'){
    stage('Sonar Scan') {
          agent {
            docker {
              // we can use the same image and workspace as we did previously
              reuseNode true
              image '${mavenVersion}'
            }
          }
          environment {
            //use 'sonar' credentials scoped only to this stage
            SONAR = credentials('${sonarCredential}')
          }
          steps {
            sh 'mvn sonar:sonar -Dsonar.login=$SONAR_PSW'
          }
    }
}