package com.nzy.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityExampleApplicationTests {

	@Test
	public void contextLoads() {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		System.out.println(p.encode("abel"));
	}

}
