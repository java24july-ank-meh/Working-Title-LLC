package com.tcgtp.TCGTradingPost;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TCGTradingPostApplicationTests {
	
	@Autowired
	public WebApplicationContext wac;
	
	public MockMvc mockMvc;
	
	@Before
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testCardSearch() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/cardSearcher")
				.param("cardName", "Sylveon")
				.param("game", "Pokemon")
				.param("setName", "")
				.param("PriceMin", "0.00")
				.param("PriceMax", "5000.00");
		this.mockMvc.perform(createMessage).andDo(print())
		.andExpect(status().is2xxSuccessful());
	}
	
	

}
