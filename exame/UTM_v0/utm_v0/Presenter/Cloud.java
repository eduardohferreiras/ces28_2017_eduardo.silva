package Presenter;

import java.util.ArrayList;
import java.util.Observable;

import Model.UTM_CTR;

import java.util.HashMap;
import java.util.List;

import View.Drone;

public class Cloud extends Observable{
	
	
	private ArrayList<Drone> drones;
	private HashMap<String, List<Double>> allInfo; // posição de todos os drones
	private String SAInfo; // representa o mapa síntese gerado pelo UTM_CTR
	private UTM_CTR control;
	
	public Cloud()
	{
		this.control = UTM_CTR.getInstance();
		drones = new ArrayList<Drone>();
		allInfo = new HashMap<String, List<Double>>();
	}
	
	public void addDrone(Drone e)
	{
		
		drones.add(e);
		allInfo.put(e.getDroneID(), e.getDronePosition());
	}

	public void getAllInfo()
	{
		for(Drone drone : drones)
		{
			allInfo.remove(drone.getDroneID());
			allInfo.put(drone.getDroneID(), drone.getDronePosition());
		}
				
			
	}
	
	public String getActualSAInfo()
	{
		return SAInfo;
	}
		
	
	public void refreshSAInfo() {
		SAInfo = control.calculateSAInfo(allInfo);
		setChanged();
        notifyObservers();
	}
}
