import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.client.*;

public class CoffeeShopConfiguration extends Configuration {
	
	@Valid
	@NotNull
    @JsonProperty
    private HttpClientConfiguration http = new HttpClientConfiguration();
    
    public HttpClientConfiguration getHttpClientConfiguration() {
        return http;
    }
}
