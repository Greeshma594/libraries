// vars/setupLibrary.groovy

def call() {
    try {
        // Retrieve the content of library.sh from the resources directory
        def scriptContent = libraryResource 'library.sh'
        
        // Write the content to a file in the workspace
        writeFile file: 'library.sh', text: scriptContent
        
        // Make the script executable
        sh 'chmod +x library.sh'
        
        // Source the script and capture the GITHUB_URL
        def githubUrl = sh(script: 'source ./library.sh && echo $GITHUB_URL', returnStdout: true).trim()
        
        // Set the environment variable in Jenkins
        env.GITHUB_URL = githubUrl
        
        echo "GITHUB_URL has been set to ${env.GITHUB_URL}"
    } catch (Exception e) {
        echo "Failed to load library.sh: ${e.getMessage()}"
        error "Aborting pipeline due to shared library load failure."
    }
}

