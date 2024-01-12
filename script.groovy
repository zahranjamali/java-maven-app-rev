def build() {
    sh 'mvn package'
}
def test() {
    echo "testing the image"
}
def buildImage() {
    echo "building the image"
    sh 'docker build -t zahranjamali/myrepo:java-maven-app-rev-1.1 .'
}
def pushImage() {
    echo "pushing to docker hub"
    withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push zahranjamali/myrepo:java-maven-app-rev-1.1'
    }
}
return this