package Q4.orig;

public class Impressora {
	public void Imprimir(String conteudo) {
		if (conteudo==null) {
			throw new IllegalArgumentException("Impressora a jato de tinta diz: conteudo nulo");
		}
		else 
			System.out.println(conteudo);
	}
}
