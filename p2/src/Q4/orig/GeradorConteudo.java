package Q4.orig;

public class GeradorConteudo {
	//Anteriormente o código abaixo estava alocado na classe Calculadora. Como tal funcionalidade
	//não está relacionada com nenhum cálculo, optou-se por criar uma nova classe responsavel somente
	//por gerar o conteudo do relatório. Dessa forma, as responsabildades de cada classe ficam mais coerentes.
	public String gerarConteudoRelatorio(float totalDespesa)
	{
		String conteudo = "Relatório de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
		return conteudo;
	}

}
