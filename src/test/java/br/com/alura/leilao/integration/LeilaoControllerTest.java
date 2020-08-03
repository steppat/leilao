package br.com.alura.leilao.integration;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.alura.leilao.repositories.LeilaoRepository;
import br.com.alura.leilao.repositories.UsuarioRepository;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class LeilaoControllerTest extends BaseTest{

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private LeilaoRepository leiloes;
	
	@MockBean
	private UsuarioRepository usuarios;

	@MockBean
	private Principal principal;

	
	@Test
	public void deveCarregarLeiloes() throws Exception {
		
        when(leiloes.findAll()).thenReturn(super.getLeiloesComputadorETablet());

		mockMvc.perform(MockMvcRequestBuilders.get("/leiloes"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(containsString("Computador")))
				.andExpect(content().string(containsString("Tablet")));
	}

	@Test
	public void deveChamarFormularioLeilaoParaEditar() throws Exception {
		
		Long id = 1l;
		
        LocalDate now = LocalDate.now();
		when(leiloes.getOne(id)).thenReturn(super.geraLeilao("Tablet", new BigDecimal("11.99"), now, getUsuarioCigano()));
        when(usuarios.findAll()).thenReturn(super.getUsuariosFulanoEBeltrano());
        
        when(principal.getName()).thenReturn("fulano");

		mockMvc.perform(MockMvcRequestBuilders.get("/leiloes/" + id + "/form"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(containsString("Tablet")))
				.andExpect(content().string(containsString("11.99")))
				.andExpect(content().string(containsString("Cigano")));
	}

	@Test
	public void deveChamarLeilaoParaExibicao() throws Exception {
		
		Long id = 1l;
		
        LocalDate now = LocalDate.now();
		when(leiloes.getOne(id)).thenReturn(super.geraLeilao("Tablet", new BigDecimal("11.99"), now, getUsuarioCigano()));
        when(usuarios.findAll()).thenReturn(super.getUsuariosFulanoEBeltrano());

        when(principal.getName()).thenReturn("fulano");
        
		mockMvc.perform(MockMvcRequestBuilders.get("/leiloes/" + id))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().string(containsString("Tablet")))
				.andExpect(content().string(containsString("11.99")))
				.andExpect(content().string(containsString("Cigano")));
	}
}
