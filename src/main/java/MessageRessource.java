import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.google.gson.Gson;

@Path("message")
public class MessageRessource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response message(String ePakString) {
		Paket ePak = new Gson().fromJson(ePakString, Paket.class);
		DbConnection db = new DbConnection();
		ePak = db.calculateSize(ePak);
		String packJson = new Gson().toJson(ePak); 
		
		//Objekt vom Typ Response + String daran bauen
		ResponseBuilder builder = Response.ok(packJson);
//		builder.header("Access-Control-Allow-Origin", "*");
//		builder.header("Access-Control-Allow-Headers", "origin, content-type, accept");
//		builder.header("Access-Control-Allow-Methods", "POST");
		return builder.build();
	}

	
}
