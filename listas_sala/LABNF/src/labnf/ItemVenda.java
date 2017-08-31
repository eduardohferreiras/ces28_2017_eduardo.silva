package labnf;
public class ItemVenda {
	ItemVenda(int ID,int quant){
		itemVendido = BDProd.getProd(ID);
		quantItem = quant;
	}
	
	private ItemInterface itemVendido;
	
	private int quantItem;
	
	public float valorTotal() {
		return itemVendido.getValor()*quantItem;
	}
}
