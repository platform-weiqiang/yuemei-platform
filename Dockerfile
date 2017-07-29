# from base image centos
FROM centos
MAINTAINER yuemei
#install java
RUN yum -y install java
#inatall app 
#ADD <src> <dest> from appUrl to container destUrl
ADD tar /usr/project/
#start app
ENTRYPOINT ["java" ,"-jar","/usr/project/docker-spring-boot-0.0.1-SNAPSHOT.jar"]
