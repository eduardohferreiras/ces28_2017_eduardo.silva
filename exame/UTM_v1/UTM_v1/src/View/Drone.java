package View;
import java.util.Arrays;
import java.util.List;

public class Drone {

	private String id;
	private double x;
	private double y;
	private double z;

	private List<Double> position;
	
	public Drone(String id,double x, double y, double z)
	{
		this.id = id;
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public List<Double> getDronePosition()
	{
		position = Arrays.asList(x, y, z);
		return position;
	}
	
	public String getDroneID()
	{
		return this.id;
	}
	
	
}
