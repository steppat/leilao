package br.com.alura.leilao.e2e.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LeilaoSteps {

	private Usuario usuario;
	private Leilao leilao;

	@Dado("o usuario {string}")
	public void o_usuario_e_um_do_usuario(String nomeUsuario) throws Exception {
		this.usuario = new Usuario(nomeUsuario);
	}
	
	@Dado("um leilao do usuario {string}")
	public void um_leilao_do_usuario(String nomeUsuario) {
		this.leilao = new Leilao(nomeUsuario);
	}

	@Quando("{string} dá um lance no leilao do {string}")
	public void quando_dar_um_lance_valido(String nomeUsuario, String donoDoLeilao) throws Exception {
		Lance lance = new Lance(this.usuario, BigDecimal.TEN);
		leilao.propoe(lance);
	}

	@Entao("o lance é adicionado no leilao")
	public void o_lance_é_aceito_pelo_leilao() {
		Lance lance = leilao.getLances().get(0);
		Assert.assertEquals(BigDecimal.TEN, lance.getValor());
		Assert.assertEquals(usuario.getNome(), lance.getUsuario().getNome());
	}
	

}
