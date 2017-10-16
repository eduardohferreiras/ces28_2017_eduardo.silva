package exec12;

import java.util.Observable;
import java.util.Observer;

public class UserInterface implements Observer{
	
	static int idglobal = 1;
	private int id;
	private Usuario _subject;
	UserInterface(Usuario user){
		id = idglobal++;
		_subject = user;
	}
	
	public void update(Observable o, Object arg) {
		System.out.println("Obs UI" + id + " notificado");
		System.out.println(">>>" + _subject.getState());
		System.out.println("\n");
	}
}
