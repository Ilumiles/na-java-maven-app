def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-art', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ilumiles/my-repo-app:a-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin 104.248.112.133:8081 "
        sh 'docker push ilumiles/my-repo-app:a-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
