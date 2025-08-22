package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(TestController.class)
public class TestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSayHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
