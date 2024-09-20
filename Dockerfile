FROM maven as build
WORKDIR /opt/apps
COPY . /opt/apps
RUN mvn clean package

FROM tomcat
COPY --from=build /opt/apps/calculator.war /usr/local/tomcat/webapps