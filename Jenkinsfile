pipeline {
    agent any // Utilisation de n'importe quel agent disponible
    stages {
        stage('Récupération du code source') {
            steps {
                // Récupérer le code source depuis le référentiel Git
                checkout scm
            }
        }
        stage('Affichage de la date système') {
            steps {
                // Afficher la date système
                script {
                    def date = sh(script: 'date', returnStatus: true).trim()
                    echo "La date système est : ${date}"
                }
            }
        }
    }
}
