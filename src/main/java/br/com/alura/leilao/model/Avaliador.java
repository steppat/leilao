package br.com.alura.leilao.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Avaliador {

	private BigDecimal maiorDeTodos = BigDecimal.valueOf(Double.MIN_VALUE);
	private BigDecimal menorDeTodos = BigDecimal.valueOf(Double.MAX_VALUE);;
	private BigDecimal media;
	
	public void avalia(Leilao leilao) {
		
		if(!leilao.temLances()) {
			throw new RuntimeException("Nao pode avaliar Leilao sem lances");
		}
		
		BigDecimal total = BigDecimal.ZERO;
		
        for(Lance lance : leilao.getLances()) {
            if(lance.getValor().compareTo(maiorDeTodos) > 0) maiorDeTodos = lance.getValor();
            if(lance.getValor().compareTo(menorDeTodos) < 0 ) menorDeTodos = lance.getValor();
            total = total.add(lance.getValor());
        }
        if(total.compareTo(BigDecimal.ZERO) == 0) {
            media = BigDecimal.ZERO;
            return;
        }
        int size = leilao.getLances().size();
		media = total.divide(new BigDecimal(size), RoundingMode.HALF_UP);
    }

    public BigDecimal getMaiorLance() { return maiorDeTodos; }
    public BigDecimal getMenorLance() { return menorDeTodos; }
    public BigDecimal getMedia() { return media; }

}
