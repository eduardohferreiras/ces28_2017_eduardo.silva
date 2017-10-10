package Application;

import mercadoVirtual.Façade;

public class Aplicacao {
	public static void main(String[] args) {

		Façade fachada = new Façade();
		fachada.registrarComprador("ZÈ",123);
		fachada.realizarCompra(123, 213);
		fachada.realizarCompra(123, 342);
		double valor = fachada.getTotalCompraCliente(123);
		fachada.processarPagamento(123, valor);
	}
}
