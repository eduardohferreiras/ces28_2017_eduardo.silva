package exec11;

public class MainClass {
	
	public static void main	(String [] args)
	{
		Usuario user_ = new Usuario();
		UserInterface UI1 = new UserInterface(user_);
		user_.attach(UI1);
		UserInterface UI2 = new UserInterface(user_);
		user_.attach(UI2);
		SistemaCliente SC1 = new SistemaCliente(user_);
		user_.attach(SC1);
		
		user_.setState("Ol�, como vai?");
		user_.notifyObs();
		
		user_.dettach(UI1);
		
		user_.setState("Por aqui vai tudo bem!");
		user_.notifyObs();
		
	}

}
