package mercadoVirtual;

public class Façade {
	private GerenciadorDeCompras gCompras;
	
	public Façade()
	{
		gCompras = new GerenciadorDeCompras();
	}
	
	public void registrarComprador(String nomeCliente, int id)
	{
		gCompras.registrarComprador(nomeCliente, id);
	}
	
	public void realizarCompra(int idCliente, int idProduto) {
		gCompras.realizarCompra(idCliente, idProduto);
	}

	public double getTotalCompraCliente(int i) {
		return gCompras.getTotalCliente(i);
		
	}

	public void processarPagamento(int i, double valor) {
		gCompras.gerarPagamento(i, valor);
	}
	
}
