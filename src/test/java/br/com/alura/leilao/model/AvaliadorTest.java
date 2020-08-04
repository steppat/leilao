package br.com.alura.leilao.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AvaliadorTest {

	private Avaliador leiloeiro;

	private Usuario maria;
	private Usuario jose;
	private Usuario joao;

	private BigDecimal valor120;
	private BigDecimal valor200;
	private BigDecimal valor250;
	private BigDecimal valor300;
	private BigDecimal valor400;
	private BigDecimal valor500;
	private BigDecimal valor700;
	private BigDecimal valor1000;

	@BeforeEach
	public void setUp() {
		this.leiloeiro = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");

		this.valor120 = new BigDecimal("120.0");
		this.valor200 = new BigDecimal("200.0");
		this.valor250 = new BigDecimal("250.0");
		this.valor300 = new BigDecimal("300.0");
		this.valor400 = new BigDecimal("400.0");
		this.valor500 = new BigDecimal("500.0");
		this.valor700 = new BigDecimal("700.0");
		this.valor1000 = new BigDecimal("1000.0");

	}

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		System.out.println(new BCryptPasswordEncoder().encode("pass"));

		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, valor250).lance(jose, valor300)
				.lance(maria, valor400).constroi();

		leiloeiro.avalia(leilao);

		assertEquals(valor250, leiloeiro.getMenorLance());
		assertEquals(valor400, leiloeiro.getMaiorLance());
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {
		Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").lance(joao, valor1000).constroi();

		leiloeiro.avalia(leilao);

		assertEquals(leiloeiro.getMenorLance(), leiloeiro.getMaiorLance());
	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance2() {
		Usuario joao = new Usuario("Joao");
		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, valor1000));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		assertEquals(valor1000, leiloeiro.getMaiorLance());
		assertEquals(valor1000, leiloeiro.getMenorLance());
	}

//	@Test
//	public void deveEntenderLeilaoComLancesEmOrdemRandomica() {
//		Usuario joao = new Usuario("Joao");
//		Usuario maria = new Usuario("Maria");
//		Leilao leilao = new Leilao("Playstation 3 Novo");
//
//		leilao.propoe(new Lance(joao, valor200));
//		leilao.propoe(new Lance(maria, new BigDecimal("450.0")));
//		leilao.propoe(new Lance(joao, valor120));
//		leilao.propoe(new Lance(maria, valor700));
//		leilao.propoe(new Lance(joao, new BigDecimal("630.0")));
//		leilao.propoe(new Lance(maria, new BigDecimal("230.0")));
//
//		Avaliador leiloeiro = new Avaliador();
//		leiloeiro.avalia(leilao);
//
//		assertEquals(valor700, leiloeiro.getMaiorLance());
//		assertEquals(valor120, leiloeiro.getMenorLance());
//	}

	@Test
	public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {

		assertThrows(RuntimeException.class, () -> {
			Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo").constroi();
			leiloeiro.avalia(leilao);

		});
	}

	@Test
	public void deveCalcularAMedia() {
		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria, valor300));
		leilao.propoe(new Lance(joao, valor400));
		leilao.propoe(new Lance(jose, valor500));

		// executando a acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		assertEquals(valor400, leiloeiro.getMedia());
	}

}
