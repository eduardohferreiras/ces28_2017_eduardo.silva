package labnf;
import java.util.ArrayList;

public  class Cadastro {

	Cadastro(ValidaCPF vali){
		BDClientes = new ArrayList<Cliente>();
		validador = vali;
	}
	
	ArrayList<Cliente> BDClientes;
	ValidaCPF validador;

	public Cliente findValidClient(int cpf) throws NullPointerException {
		if(validador.valida(cpf))
			return null;
		else
			throw new NullPointerException();
	}
}
