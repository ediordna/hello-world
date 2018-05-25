package parcelp;
import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
public class RestStart {
	//working directory für tomcat im dockerbuild file noch ändern!!!
	private static int PORT = 8081;
	
	public static void main(String[] args) {
		
		ResourceConfig rc = new PackagesResourceConfig("parcelp");
		rc.getProperties().put(
				"com.sun.jersey.spi.container.ContainerResponseFilters",
				"parcelp.CORSFilter");
		rc.getRootResourceClasses().add(MessageRessource.class); //brauche ich diese Zeile? - Hinweis von Herr Greising 
		try {
			HttpServer server;
			server = HttpServerFactory.create("http://localhost:" + PORT + "/rest", rc);
			server.start();
				System.out.println("Server successfully started on port " + PORT);
		} catch (IllegalArgumentException | IOException e1) {
			System.out.println("Failed to start server on port " + PORT);
			e1.printStackTrace();
		}
	}
}


// Port 8080 = Tomcat Server
// Port 8081 = REST Server
// Port 3306 = mySQL Database
// Port 8083 = Docker Container parcelsizecomponent (-p 8081:8083) da Rest Server auf 8081 hört
// Port 8084 = Docker Container parcelwebserver
// Port 3307 = Docker Container parceldatabase & mySQL database
