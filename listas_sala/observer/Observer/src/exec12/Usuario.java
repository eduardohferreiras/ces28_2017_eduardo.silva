package exec12;

import java.util.Observable;

public class Usuario extends Observable{
	
	private String estado;
	
	public Usuario() {
		super();
	}
	
	public void setState(String message ) {
		System.out.println("Gerar evento \n---------------------- \n");
		estado = message;
		setChanged();
	}
	
	public String getState() {
		return estado;
	}
	
}