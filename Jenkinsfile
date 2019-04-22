pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'set'
            }
        }
        stage('Deploy') {
            steps {
                timeout(time: 3, unit: 'MINUTES') {
                    retry(3) {
                        echo "No deployment model currently"
                    }
                }
            }
        }
    }
    post {
        always {
            echo 'Project build completed'
        }
        success {
            echo 'Build was successful'
        }
        failure {
            echo 'Build failed'
        }
        unstable {
            echo 'Build was unstable'
        }
        changed {
            echo 'Build state changed'
        }
    }
}