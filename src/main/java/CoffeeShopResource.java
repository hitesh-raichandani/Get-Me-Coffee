


import java.net.URI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import dao.*;

@Path("/coffeeshop")
@Produces(MediaType.APPLICATION_JSON)
public class CoffeeShopResource {
	private Datastore dataStore;
//	static final MongoClient mongoClient = new MongoClient(); 
	
	public CoffeeShopResource(final MongoClient mongoClient) {
		dataStore = new Morphia().createDatastore(mongoClient, "CoffeePiyo"); 
	}
	
	@Path("nearest/{latitude}/{longitude}")
	@GET
	public Object getNearest(@PathParam("latitude") double latitude, @PathParam("longitude") double longitude) {
		
		return dataStore.find(CoffeeShop.class)
				.field("location")
				.near(longitude, latitude, true)
				.get();
	}
	
	@Path("order")
	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveOrder(Order order) {
		System.out.println(order.toString());
		dataStore.save(order);
//		return Response.created(URI.create(order.getId())).entity(order).build();
	}
}
