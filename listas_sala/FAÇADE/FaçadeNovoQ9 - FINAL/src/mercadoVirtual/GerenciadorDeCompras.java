package mercadoVirtual;

public class GerenciadorDeCompras {
	
	private BancoDeDados banco;
	
	GerenciadorDeCompras()
	{
		banco = BancoDeDados.getBancoDedados();
	}
	
	
	public void registrarComprador(String nomeCliente, int id)
	{
		Cliente cliente = Cliente.create(nomeCliente, id);
		Carrinho car = Carrinho.getCarrinho();
		cliente.adicionarCarrinho(car);
		banco.registrarCliente(cliente);
	}
	
	public void realizarCompra(int idCliente, int idProduto) {
		Carrinho carrinho = banco.selectCliente(idCliente).getCarrinho();
		carrinho.adicionar(banco.selectProduto(idProduto));
	}
	
	public double getTotalCliente(int idCliente) {
		return banco.selectCliente(idCliente).getCarrinho().getTotal();
	}
	
	public void gerarPagamento(int clientId, double valor) {
		banco.processarPagamento(banco.selectCliente(clientId), valor);
	}
}
