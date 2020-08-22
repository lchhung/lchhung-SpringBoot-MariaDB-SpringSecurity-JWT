package com.lchhung.vehicles;

import static org.assertj.core.api.Assertions.assertThat;
import com.lchhung.vehicles.web.CarController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class VihecleDatabaseApplicationTests {

	@Autowired
	private CarController carController;

	@Test
	public void contextLoads() {
		assertThat(carController).isNotNull();
	}

}
