package com.github.jcooky.troll.test;

import com.github.jcooky.troll.tomcat.MinaProtocolHandler;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: dennis
 * Date: 13. 12. 6
 * Time: 오후 2:13
 * To change this template use File | Settings | File Templates.
 */
public class Server {
	public static void main(String []args) throws Exception {
		String webappDirLocation = "src/main/webapp/";
		Tomcat tomcat = new Tomcat();

		//The port that we should run on can be set into an environment variable
		//Look for that variable and default to 8080 if it isn't there.
		String webPort = System.getenv("PORT");
		if(webPort == null || webPort.isEmpty()) {
			webPort = "8080";
		}

		tomcat.setPort(Integer.valueOf(webPort));
		tomcat.enableNaming();

		Connector connector = new Connector(MinaProtocolHandler.class.getName());
		connector.setPort(8090);
		tomcat.getService().addConnector(connector);

		Context ctx = tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
		((StandardJarScanner) ctx.getJarScanner()).setScanAllDirectories(true);

		tomcat.start();
		tomcat.getServer().await();
	}
}
