#!/usr/bin/env groovy

def call(String mavenVersion = 'maven:3.5.0-jdk-8', String mavenJavaOpts){
    stage('Build') {
      agent {
        docker {
          /*
           * Reuse the workspace on the agent defined at top-level of Pipeline but run inside a container.
           * In this case we are running a container with maven so we don't have to install specific versions
           * of maven directly on the agent
           */
          reuseNode true
          image '${mavenVersion}'
        }
      }
      steps {
        // using the Pipeline Maven plugin we can set maven configuration settings, publish test results, and annotate the Jenkins console
        withMaven(
          maven: "Maven3"
          mavenOpts: '${mavenJavaOpts}'
        ) {
          sh 'mvn ${mavenArgs} clean package'
        }
      }
      post {
        success {
          send_to_nexus()
        }
      }
    }
}