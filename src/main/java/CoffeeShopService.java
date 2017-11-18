

import org.apache.http.client.HttpClient;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.client.HttpClientBuilder;
import io.dropwizard.setup.Environment;
import com.mongodb.MongoClient;

public class CoffeeShopService extends Application<CoffeeShopConfiguration>{

	public static void main(String[] args) throws Exception {
		new CoffeeShopService().run(args);
	}
	
	@Override
	public void initialize(final io.dropwizard.setup.Bootstrap<CoffeeShopConfiguration> bootstrap) {
		AssetsBundle bundle = new AssetsBundle("/html", "/");
		bootstrap.addBundle(bundle);
	}
	
	@Override
	public void run(CoffeeShopConfiguration configuration, Environment environment) throws Exception {
		// TODO Auto-generated method stub
//		environment.jersey().setUrlPattern("/service/*");
//		environment.jersey().getResourceConfig().getSingletons().add(new CoffeeShopResource());
		MongoClient mongoClient = new MongoClient();
		environment.lifecycle().manage(new MongoClientManager(mongoClient));
		environment.jersey().register(new CoffeeShopResource(mongoClient));
		
		
		final HttpClient client = new HttpClientBuilder(environment).using(configuration.getHttpClientConfiguration()).build("");
//		environment.jersey().getResourceConfig().getSingletons().add(client);
//		environment.jersey().register(client);
	}

}
