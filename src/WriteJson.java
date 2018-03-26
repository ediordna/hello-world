import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class WriteJson {
	public static void main(String[] args) {
		HttpServer server;
		try {
			server = HttpServerFactory.create("http://localhost:8081/rest");
			server.start();

			// server.stop( 0 );
		} catch (IllegalArgumentException | IOException e1) {
			// TODO Automatisch generierter Erfassungsblock
			e1.printStackTrace();
		}


	}
}
