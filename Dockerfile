#Contruir imagem
#    docker build --no-cache -t conectcar -f ./Dockerfile .
#Rodar os testes
#    docker run conectcar clean test -Denv=qa -Dbrowser=chrome
FROM maven:3.5.3-jdk-8-alpine
COPY ./. /
RUN mvn dependency:go-offline -B


