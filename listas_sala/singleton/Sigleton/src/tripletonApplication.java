import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class tripletonApplication {

	
	private static Stack<tripletonApplication> availableStack = new Stack<tripletonApplication>();
	
	private static HashSet<tripletonApplication> usedInstances = new HashSet<tripletonApplication>();
	
	private static int maxcounter = 3;
	
	public static void initializePool()
	{
		tripletonApplication instance1 = new tripletonApplication();
		usedInstances.add(instance1);
		tripletonApplication instance2 = new tripletonApplication();
		usedInstances.add(instance2);
	}
	
	private tripletonApplication() {
		
	}
	
	public static synchronized tripletonApplication getInstance() throws InterruptedException {
		if(availableStack.size() + usedInstances.size() < maxcounter && !availableStack.isEmpty())
		{
			tripletonApplication instance = availableStack.pop();
			usedInstances.add(instance);
			return instance;
		}
		else if(availableStack.size() + usedInstances.size() < maxcounter && availableStack.isEmpty())
		{
			tripletonApplication instance = create();
			usedInstances.add(instance);
			return instance;		
		}
		else
			throw new RuntimeException("Não é possivel criar mais instancias");
	}
	
	private static tripletonApplication create() throws InterruptedException {
		Thread.sleep(3000);
		tripletonApplication instance = new tripletonApplication();
		availableStack.add(instance);
		return instance;
	}
	
	protected void finalizeInstance(tripletonApplication instance) throws Throwable{
		try {
			usedInstances.remove(instance);
			availableStack.push(instance);
		} finally {
			super.finalize();
		}
	}
	
}