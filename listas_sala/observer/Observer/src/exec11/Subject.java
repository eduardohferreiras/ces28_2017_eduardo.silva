package exec11;

import java.util.ArrayList;

public class Subject {
	
	protected ArrayList<Observers> observers;
	
	
	protected void notifyObs() {
		for(Observers observer : observers) {
			observer.update();
		}
	}
	
	public void attach(Observers obj) {
		observers.add(obj);
	}
	
	public void dettach(Observers obj) {
		observers.remove(obj);
	}
	
}
