
public class MyThread extends Thread{
	singletonApplication myApp;
	
	public void run(){
		try {
			myApp = singletonApplication.getInstance();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public singletonApplication getApp() {
		return myApp;
	}
}
