

To Run as spring boot app: (Java 1.8 is required)
mvn spring-boot:run


Docker image build
mvn install dockerfile:build

Push Docker image:
mvn dockerfile:push

To run as docker 
docker run -p 8080:8080 -t wallet-monitor/wallet-monitor
