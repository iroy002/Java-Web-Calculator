pipeline {
    agent any
    tools {
        maven "maven3.8.5"
    }

    stages {
        stage(GitCheckOut){
            steps{
                gitbranch: '', gitcredentials: '', giturl: ''
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
                sshagent(['']){
                    sh "scp -o StrictHostKeyChecking=no target/.war username@PublicIpAddress:/opt/apache-tomcat/webapps"
                }
            }
        }
    }
}