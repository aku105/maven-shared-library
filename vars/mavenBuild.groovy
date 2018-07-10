#!/usr/bin/env groovy

def call(String mavenVersion = 'maven:3.5.0-jdk-8', String mavenJavaOpts){
  // using the Pipeline Maven plugin we can set maven configuration settings, publish test results, and annotate the Jenkins console
  withMaven(
    maven: "M3"
  ) {
    sh 'mvn ${mavenArgs} clean package'
  }
}