# Web Project Setup

This page details how to create a Simple Web Project using Spring Tool Suite, Maven, Java 8 and Java Servlets.

### Prerequisites
Please make sure you have the following installed:
* Java 8
* Maven
* Tomcat Server 8.5
* Spring Tool Suite 4

## Instructions
1. Create a Maven Project
   1. Right-Click on the Package Explorer
   1. Select `New` >> `Other...` >> `Maven` >> `Maven Project`
   1. Check the `Create a simple project (skip archetype selection)` checkbox
   1. Select `Next >`
   1. Provide a Group Id, Artifact Id, Name and optional Description.
   1. Select `War` from the Packaging dropdown menu.
   1. Right-click on your project and select `Java EE Tools` >> `Generate Deployment Descriptor Stub`
      * _if you do not see this option, may need to install additional web tools to Spring Tool Suite. See the instructions below for more details._
   1. Update the POM file:
      * Include the `<maven.compiler.source>` and `<maven.compiler.target>` elements within the `<properties>` element.
      * Add PostgreSQL driver to the dependencies
      * Add the javax servlet api to the dependencies
      * Add the jstl libraries to the dependencies
      Your pom file should resemble something similar to the following:

```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.revature</groupId>
  <artifactId>servlet-example</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  <name>servlet-example</name>
  <description>JDBC and Servlet Example</description>
  
  <properties>
  	<maven.compiler.source>1.8</maven.compiler.source>
  	<maven.compiler.target>1.8</maven.compiler.target>
  </properties>
  
	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.2.18</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.1.0</version>
			<scope>provided</scope>
		</dependency>
		
		<!--  https://mvnrepository.com/artifact/jstl/jstl -->
		<dependency>
			<groupId>jstl</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
	</dependencies>
</project>
```
2. Create A Server
   * _if you cannot create a server, make sure that you have successfully installed Tomcat. Additionally, you may need to install additional web tools to Spring Tool Suite. See the instructions below for more details_
   1. Right-Click on the Package Explorer
   1. Select `New` >> `Other...` >> `Server` >> `Server`
   1. Select `Apache` >> `Tomcat v8.5 Server`
   1. Select `Next >`
   1. Use the `Browse` button to search for the installation folder of your Tomcat server

#### If you require additional Web tools for Spring Tool Suite:
* Using the top menu bar, select `Help` >> `Install New Software...`
* In the 'Work with' drop-down menu, search for `Latest Eclipse Release - http://download.eclipse.org/releases/latest`
* In the Search Filter below select the following from `Web, XML, Java EE and OSGi Enterprise Development`
   * Eclipse Java EE Developer Tools
   * Eclipse Java Web Developer Tools
   * Eclipse Web Developer Tools