package Application;

import mercadoVirtual.Fa�ade;

public class Aplicacao {
	public static void main(String[] args) {

		Fa�ade fachada = new Fa�ade();
		fachada.registrarComprador("Z�",123);
		fachada.realizarCompra(123, 213);
		fachada.realizarCompra(123, 342);
		double valor = fachada.getTotalCompraCliente(123);
		fachada.processarPagamento(123, valor);
	}
}
