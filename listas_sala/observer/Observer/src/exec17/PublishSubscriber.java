package exec17;

import java.util.ArrayList;

import exec17.Observer;

public class PublishSubscriber {
	
	ArrayList<Observer> observers;
	
	PublishSubscriber()
	{
		observers = new ArrayList<Observer>();
	}

	public void addObserver(Observer obs) {
		observers.add(obs);
	}
	
	public void updateMsg(String msg){
		topic = msg;
		for(Observer obs: observers)
		{
			obs.update();
		}
	}

	public String getTopic(){
		return topic;
	}
	
	private String topic;
	
}