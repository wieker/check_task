mvn clean install
docker image build -t abramovich_test .
docker container run --publish 8080:8080 abramovich_test
