pipeline {
    agent any

    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '5', daysToKeepStr: '', numToKeepStr: '5')
        timestamps()
    }   

    environment {     
        DOCKERHUB_CREDENTIALS= credentials('Docker-Hub-Credentials')     
    }

    stages {
        stage('GitCheckOut') {
            steps {
                git branch: 'main', credentialsId: 'GitHub_Credentials', url: 'https://github.com/gmk1995/Java-Web-Calculator.git'
            }
        }

        stage('DockerBuild') {
            steps {
                sh 'docker build -t gmk1995/java-web-calculator:v1 .'
            }
        }

        stage('DockerPush') {
            steps {
                sh "echo DOCKERHUB_CREDENTIALS | docker login -u gmk1995 --password-stdin"
                sh "docker push gmk1995/java-web-calculator:v1"
            }
        }

        stage('KubernetesDeployment') {
            steps {
                sh " kubectl apply -f java-web-calculator-deployment.yaml"
            }
        }
    }

    post {
        always {
            sh "docker logout"
        }
    }

}