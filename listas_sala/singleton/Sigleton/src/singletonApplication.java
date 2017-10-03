
public class singletonApplication {

	public static singletonApplication instance = null;
	private static boolean instanceFlag = false;
	
	private singletonApplication() {
		
	}
	
	public static synchronized singletonApplication getInstance() throws InterruptedException {
		if(!instanceFlag)
			return create();
		else
			return instance;
	}
	
	private static singletonApplication create() throws InterruptedException {
		Thread.sleep(3000);
		instance = new singletonApplication();
		instanceFlag = true;
		return instance;
		
	}
	
	protected void finalize() throws Throwable{
		try {
			instanceFlag = false;
		} finally {
			super.finalize();
		}
	}
	
}
