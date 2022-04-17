def buildJar() {
    echo "building the application..."
    sh 'mvn clean package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-docker-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t 104.248.112.133:8083/my-app:a-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin  104.248.112.133:8083 "
        sh 'docker push 104.248.112.133:8083/my-app:a-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
