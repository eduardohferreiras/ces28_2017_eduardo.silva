package exec11;

public class SistemaCliente implements Observers{
	
	static int idglobal = 1;
	private int id;
	private Usuario _subject;
	SistemaCliente(Usuario user){
		id = idglobal++;
		_subject = user;
	}
	
	public void update() {
		System.out.println("Obs SO" + id + " notificado");
		System.out.println(">>>" + _subject.getState());
		System.out.println("\n");
		
	}
}