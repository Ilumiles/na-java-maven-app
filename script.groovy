def buildJar() {
    echo "building the application..."
    sh 'mvn clean package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ilumiles/my-repo-app:a-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin "
        sh 'docker push ilumiles/my-repo-app:a-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
