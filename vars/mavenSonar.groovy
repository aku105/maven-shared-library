#!/usr/bin/env groovy

def call(String mavenVersion = 'maven:3.5.0-jdk-8', String sonarCredential = 'sonar'){
  sh 'mvn sonar:sonar -Dsonar.login=$SONAR_PSW'
}