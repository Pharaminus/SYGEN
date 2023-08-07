package com.APP.SYGEN;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootTest
@RestController
@RequestMapping(path = "Test")
class SygenApplicationTests {

	@Test
	void contextLoads() {
	}
	// @Autowired
	// private ParticipeService participeService;

}
