package edu.farmingdale.csc311.lostfound;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:lostfound-test")
class LostfoundApplicationTests {

	@Test
	void contextLoads() {
	}

}
