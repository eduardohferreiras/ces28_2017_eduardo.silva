package labnf;
public class ItemVenda {
	ItemVenda(int ID,int quant, BDProd bdprod){
		itemVendido = bdprod.getProd(ID);
		quantItem = quant;
		id = ID;
	}
	
	private ItemInterface itemVendido;
	
	private int quantItem, id;
	
	public int valorTotal() {
		return itemVendido.getValor()*quantItem;
	}
	
	public int getId() {
		return id;
	}
	
	public int getQnt() {
		return quantItem;
	}
	
	public void incrementaQnt(int qnt) {
		quantItem += qnt;
	}
	
}
