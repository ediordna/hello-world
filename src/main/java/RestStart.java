import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
public class RestStart {
	
	private static int PORT = 8081;
	
	public static void main(String[] args) {
		
		ResourceConfig rc = new PackagesResourceConfig("");
		rc.getProperties().put(
				"com.sun.jersey.spi.container.ContainerResponseFilters",
				"CORSFilter");
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
