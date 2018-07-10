#!/usr/bin/env groovy

def call(String mavenVersion = 'maven:3.5.0-jdk-8', String sonarCredential = 'sonar'){
  withMaven(
    maven: "M3"
  ){
    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_PSW'
  }
}