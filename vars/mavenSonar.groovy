#!/usr/bin/env groovy

def call(String mavenToUse = 'M3', String sonarCredential = 'sonar'){
  withMaven(
    maven: "${mavenToUse}"
  ){
    script{
      try{
        sh 'mvn sonar:sonar -Dsonar.login=$SONAR_PSW'
      } catch(err){
        echo err
      }
    }
  }
}