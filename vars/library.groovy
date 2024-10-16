// vars/library.groovy

def call() {
    // Execute the shell script from the resources directory
    sh 'bash resources/library.sh'
    
    // Optionally, set environment variables directly in Groovy
    env.GITHUB_URL = "https://github.com/Greeshma594/c-project.git"
    
    echo "GITHUB_URL has been set to ${env.GITHUB_URL}"
}

