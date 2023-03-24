# FROM image 
# ADD /my/Test.java /a/b/c/Test.java 
# RUN apt-get install java 
# ENV JAVA_HOME=/some/path
# WORKDIR /a/b/c
# EXPOSE 8050 
# ENTRYPOINT sleep 5 

#----------------------------------------------------------
# FROM alpine
# RUN apk add openjdk8     
# ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin/
# WORKDIR /usr/shre/udemy
# ADD Test.java Test.java
# ENTRYPOINT javac Test.java && java Test $NUMBER
#-----------------------------------------------------------

# FROM alpine 
# RUN apk add openjdk17
# ENV PATH $PATH:/usr/lib/jvm/java-1.17-openjdk/bin/
# ENV HUB_HOST $HUB_HOST
# WORKDIR /usr/shre/udemy
# COPY selenium-docker.jar /usr/shre/udemy/
# COPY selenium-docker-tests.jar  /usr/shre/udemy/
# COPY /libs /usr/shre/udemy/libs
# COPY testng.xml /usr/shre/udemy/
# ENTRYPOINT /bin/sh

#----------------------------------------------------------------

FROM alpine 
RUN apk add openjdk17
ENV PATH $PATH:/usr/lib/jvm/java-1.17-openjdk/bin/
# ENV HUB_HOST=192.168.29.177
WORKDIR /usr/shre/udemy
COPY selenium-docker.jar /usr/shre/udemy/
COPY selenium-docker-tests.jar  /usr/shre/udemy/
COPY /libs /usr/shre/udemy/libs
COPY testng.xml /usr/shre/udemy/
ENTRYPOINT java -cp selenium-docker-tests.jar:selenium-docker.jar:libs/* org.testng.TestNG testng.xml

#----------------------------------------------------------
# FROM selenium/hub:3.14
#RUN apk add openjdk8     
# ENV PATH $PATH:/usr/lib/jvm/java-1.8-openjdk/bin/
# WORKDIR /usr/shre/udemy
# ADD Test.java Test.java
# ENTRYPOINT javac Test.java && java Test $NUMBER