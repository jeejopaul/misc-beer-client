package guru.springframework.miscbeerclient.web.client;

import java.net.URI;
import java.util.UUID;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import guru.springframework.miscbeerclient.web.model.BeerDto;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {
	
	public final String BEER_PATH_V1 = "/api/v1/beer/";
	private String apihost;
	private final RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}
	
	public URI saveBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
	}
	
	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apihost + BEER_PATH_V1 + uuid.toString(), beerDto);
	}
	
	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apihost + BEER_PATH_V1 + uuid.toString());
	}


	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
}