package exec17;

public class MainClass {
	
	public static void main	(String [] args)
	{
		PublishSubscriber PB = new PublishSubscriber();
		Subject sub1 = new Subject();
		Subject sub2 = new Subject();
		Observer obs1 = new Observer(PB);
		Observer obs2 = new Observer(PB); 
		
		// fa�a o registro para PB ser notificado se sub1 ou sub2 mudarem
		sub1.setPubSub(PB);
		sub2.setPubSub(PB);
		// fa�a o registro para obs1 e obs2 serem notificarem se PB mudar.
		PB.addObserver(obs1);
		PB.addObserver(obs2);
		// agora fa�a um demo de comunica��o:
		
		sub1.setValue("msg do sub1");
		sub2.setValue("msg do sub2");


		
	}

}
