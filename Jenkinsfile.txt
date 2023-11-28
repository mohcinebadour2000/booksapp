pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    echo 'Building the Android app...'
                    sh './gradlew assembleDebug'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    echo 'Running tests...'
                    sh './gradlew test'
                }
            }
        }
    }
}
