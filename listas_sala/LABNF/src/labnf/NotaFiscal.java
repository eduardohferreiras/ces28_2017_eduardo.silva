package labnf;
import java.util.ArrayList;

public class NotaFiscal {
	
	ValidaCPF validador;
	DBCliente dbcliente;
	BDProd _bdprod;
	ArrayList<ItemVenda> listaItens;
	
	NotaFiscal(int cpf,int id, int quant, ValidaCPF validador, DBCliente dbcliente, BDProd bdprod){
		

		if(dbcliente.getCliente(cpf) == null) {
			//dá merda

		}
		if(!validador.valida(cpf)) {	
			//dá merda

		}
		listaItens = new ArrayList<ItemVenda>();
		_bdprod = bdprod;
		addItem(id, quant);

		
	}
	
	public int numItens() {
		return listaItens.size();
	}

	public void addItem(int itemId, int qnt) {
		listaItens.add(new ItemVenda(itemId,qnt,_bdprod));
	}

	public ItemVenda get(int i) {
		return listaItens.get(i);
	}
	
	public int ValorTotal() {
		int resp = 0;
		
		for(int i = 0; i < listaItens.size();i++) {
			resp += listaItens.get(i).valorTotal();
		}
		return resp;
	}
	
	public void rmvItem(int itemId, int qnt) {
		int ind;
		for(ind = 0; ind < listaItens.size(); ind++) {
			if(listaItens.get(ind).getId() == itemId) {
				if(qnt < listaItens.get(ind).getQnt()) {
					listaItens.get(ind).incrementaQnt(-qnt);
				} 
				else {
					if(numItens() > 1)
						listaItens.remove(ind);
					else {
						throw new ListaVaziaException();
					}
				}
			}
			
		}
		
	}
	
	public ItemVenda achaItemPeloId(int id) {
		for(int i = 0; i < numItens(); i++) {
			if(id == listaItens.get(i).getId())
				return listaItens.get(i);
		}
		return null; 
	}
	
	public void trocaItem(int id1,int id2, int quant2) {
		addItem(id2,quant2);
		rmvItem(id1, achaItemPeloId(id1).getQnt());
	}
}
