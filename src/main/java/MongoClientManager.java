import com.mongodb.MongoClient;

import io.dropwizard.lifecycle.Managed;

public class MongoClientManager implements Managed {
	private final MongoClient mongoClient;

	public MongoClientManager(final MongoClient mongoClient) {
		this.mongoClient = mongoClient; 
	}
	
	@Override
	public void start() throws Exception {
		// used for checking connection to database, loading configuration from the database...

	}

	@Override
	public void stop() throws Exception {
		mongoClient.close();
	}

}
