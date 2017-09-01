package labnf;

public class ListaVaziaException extends RuntimeException {
	ListaVaziaException(){
		super("Não é possível retirar o ultimo elemento!");
	}
}
