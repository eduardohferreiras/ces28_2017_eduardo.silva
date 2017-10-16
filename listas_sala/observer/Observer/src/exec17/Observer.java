package exec17;


public class Observer {
	
	static int idglobal = 1;
	private int id;
	
	PublishSubscriber pubSub_;
	Observer(PublishSubscriber PB){
		id = idglobal++;
		pubSub_ = PB;
	}
	
	public void update() {
		System.out.println("obs" + id + ": recebi " + "\"" + pubSub_.getTopic() + "\"");

	}

}
