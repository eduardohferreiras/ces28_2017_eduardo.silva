package labnf;

public class ListaVaziaException extends RuntimeException {
	ListaVaziaException(){
		super("N�o � poss�vel retirar o ultimo elemento!");
	}
}
