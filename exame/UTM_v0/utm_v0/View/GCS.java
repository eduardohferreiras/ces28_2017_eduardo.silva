package View;

import java.util.Observable;
import java.util.Observer;
import Presenter.Cloud;

public class GCS implements Observer{

	private Cloud cloud;
	private String controlledDroneId;
	public GCS(String droneID)
	
	{
		this.controlledDroneId = droneID;
	}
	
	public void setCloud(Cloud cloud)
	{

		this.cloud = cloud;
		
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		this.printSAInfo();	
	}

	
	private void printSAInfo() {
		System.out.println("O CGS responsavel pelo drone de id (" + controlledDroneId + ") recebeu a seguinte SA Info:");
		System.out.println(cloud.getActualSAInfo());
	}

}
