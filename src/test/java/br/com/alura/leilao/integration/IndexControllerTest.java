package br.com.alura.leilao.integration;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class IndexControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void verificaSePaginaIndexCarrega() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/leiloes"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(containsString("Todos leilões")));
	}
}
