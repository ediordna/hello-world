import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("message")
public class MessageRessource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String message() {
		
		
		 JsonObjectBuilder builder = Json.createObjectBuilder();
		 builder.add("length", 0);
		 builder.add("width", 0);
		 builder.add("height", 0);
		 builder.add("size", "");
//		try {
//			FileWriter fw = new FileWriter("test.txt");
//			JsonWriter jsonWriter = Json.createWriter(fw);
//			JsonObject jo = null;
//			jsonWriter.writeObject(jo);
//			jsonWriter.close();
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return "Yea! ";
	}
}
