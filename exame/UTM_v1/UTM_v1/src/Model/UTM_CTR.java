package Model;

import java.util.HashMap;
import java.util.List;


public class UTM_CTR{
	
	//Sinlgeton, logo só existirá uma instancia de UTM_CTR, como foi pedido no enunciado.
	private UTM_CTR() {};
	static private UTM_CTR instance = null;
	static public UTM_CTR getInstance()
	{
		if(UTM_CTR.instance == null)
		{
			instance = new UTM_CTR();
			return UTM_CTR.instance;
		}
		else
		{
			return UTM_CTR.instance;
		}
	}
	
	
	private String getMetheorolicalInfo()
		{
			return "Clean sky, no wind, 25 degrees celsius."; // exemplo de situaçao meteorológica
		}
	
	private String SAInfo;
	
	public String calculateSAInfo(HashMap<String, List<Double>> allInfo) {
		SAInfo = "";
		
		for (String name: allInfo.keySet()){

            String key =name.toString();
            String value = allInfo.get(name).toString();  
            SAInfo += "Drone ID: " + key + " Drone Position: " + value + " ;\n";
		}
		SAInfo += getMetheorolicalInfo() + "\n";
		return SAInfo;
	}

}


