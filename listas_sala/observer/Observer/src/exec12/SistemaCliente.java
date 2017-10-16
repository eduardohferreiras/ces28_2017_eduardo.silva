package exec12;

import java.util.Observable;
import java.util.Observer;

public class SistemaCliente implements Observer{
	
	static int idglobal = 1;
	private int id;
	private Usuario _subject;
	SistemaCliente(Usuario user){
		id = idglobal++;
		_subject = user;
	}

	public void update(Observable o, Object arg) {
		System.out.println("Obs SO" + id + " notificado");
		System.out.println(">>>" + _subject.getState());
		System.out.println("\n");
	}
}