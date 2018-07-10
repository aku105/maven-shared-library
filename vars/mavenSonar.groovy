#!/usr/bin/env groovy

def call(String mavenToUse = 'M3', String sonarCredential = 'sonar'){
  withMaven(
    maven: "${mavenToUse}"
  ){
    sh 'mvn sonar:sonar -Dsonar.login=$SONAR_PSW'
  }
}