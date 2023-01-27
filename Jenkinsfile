pipeline {
    agent any
    tools {
  maven 'maven3.8.7'
 }


    stages {
        stage(GitCheckOut){
            steps{
                git branch: 'main', credentialsId: '026f781b-368d-4626-ab66-08d71d1d7d82', url: 'https://github.com/gmk1995/Java-Web-Calculator.git'
            }
        }

        stage('Build'){
            steps{
                sh "mvn clean package"
            }
        }
        stage('SonarQubeReport'){
            steps{
                sh "mvn sonar:sonar"
            }
        }

        stage('UploadToNexusArtifact'){
            steps{
                sh "mvn deploy"
            }
        }

        stage('DeployToTomcatServer') {
            steps{
                sshagent(['Tomcat-ssh-connection-key', ignoreMissing: true]) {
                    sh "scp -o StrictHostKeyChecking=no target/calculator.war ec2-user@13.233.121.198:/opt/apache-tomcat-9.0.71/webapps/calculator.war"
                }
            }
        }
    }
} 
