package Q4.orig;

public class GeradorConteudo {
	//Anteriormente o c�digo abaixo estava alocado na classe Calculadora. Como tal funcionalidade
	//n�o est� relacionada com nenhum c�lculo, optou-se por criar uma nova classe responsavel somente
	//por gerar o conteudo do relat�rio. Dessa forma, as responsabildades de cada classe ficam mais coerentes.
	public String gerarConteudoRelatorio(float totalDespesa)
	{
		String conteudo = "Relat�rio de Despesas";
		conteudo+=("\n Total das despesas:" + totalDespesa);
		return conteudo;
	}

}
