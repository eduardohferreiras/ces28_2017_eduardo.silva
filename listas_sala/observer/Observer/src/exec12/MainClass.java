package exec12;

public class MainClass {
	
	public static void main	(String [] args)
	{
		Usuario user_ = new Usuario();
		UserInterface UI1 = new UserInterface(user_);
		user_.addObserver(UI1);
		UserInterface UI2 = new UserInterface(user_);
		user_.addObserver(UI2);
		SistemaCliente SC1 = new SistemaCliente(user_);
		user_.addObserver(SC1);
		
		user_.setState("Olá, como vai?");
		user_.notifyObservers();
		
		user_.deleteObserver(UI1);
		
		user_.setState("Por aqui vai tudo bem!");
		user_.notifyObservers();
		
	}

}
