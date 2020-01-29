package guru.springframework.miscbeerclient.web.client;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import guru.springframework.miscbeerclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.util.UUID;

@SpringBootTest
class BreweryClientTests {
	
	@Autowired
	BreweryClient client;

	@Test
	void testGetBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
	}
	
	@Test
	void testSaveBeer() {
		BeerDto beerDto = BeerDto.builder().build();
		URI uri = client.saveBeer(beerDto);
		System.out.println("URI " + uri.toString());
		assertNotNull(uri);
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		client.updateBeer(UUID.randomUUID(),beerDto);
	}
	
	@Test
	void testDeleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}

}
