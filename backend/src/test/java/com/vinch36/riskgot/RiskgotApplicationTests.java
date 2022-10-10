package com.vinch36.riskgot;

import com.vinch36.riskgot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RiskgotApplicationTests {

	@Autowired
	private UserService us;

	@Test
	void contextLoads() {
	}


}
