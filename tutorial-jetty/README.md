<html>

<h3>Description:</h3>
<p>
It a simple demo to show how to embed Jetty into Spring application based on XML configuration. It demostrates:
<ul>
<li>Spring could be launched as a stand-alone JVM process, besides of living in web container(tomcat/Jetyy/...);
<li>With Spring IOC, a Jetty can be simply setup without any Java code;
<li>Spring DispatcherServlet has been embeded into Jetty server, in order to take the full control of Spring MVC functionalities;
</ul>

</p>

<hr>
<h3>Usage:</h3>
<p>
	mvn exec:java -Dexec.mainClass="com.yquants.tutorial.jetty.main.Application"
	or:
	mvn clean install
</p>

<hr/>
<h3>TODOs:</h3>
<ul>
<li>Add JSP Compiler into Spring IOC configuration</li>
</ul>

<hr/>
<h3>Environment:</h3>
<ul>
<li>OS: Windows XP</li>
<li>Java: JDK_1.8.0_72</li>
<li>IDE: eclipse</li>
<li>Maven: 3.3.9</li>
</ul>

</html>