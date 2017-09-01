package labnf;

public class ProdutoNaoCatalogadoException extends RuntimeException {
	ProdutoNaoCatalogadoException(){
		super("Produto não existe!!!!!!");
	}
	
}
