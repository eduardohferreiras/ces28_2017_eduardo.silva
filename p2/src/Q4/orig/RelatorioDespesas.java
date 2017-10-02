package Q4.orig;

import java.util.Iterator;

public class RelatorioDespesas {
	
	public void ImprimirRelatorio(Iterator<Despesa> iteradorDespesas, Calculadora calculadora, SistemaOperacional so, GeradorConteudo gc) {
		
		float valorTotal = calculadora.calcularValorTotalDespesas(iteradorDespesas);
		
		String conteudoRelatorio = gc.gerarConteudoRelatorio(valorTotal);
		
		Impressora driverImpressao = so.getDriverImpressao();
		
		driverImpressao.Imprimir(conteudoRelatorio);
	}

}