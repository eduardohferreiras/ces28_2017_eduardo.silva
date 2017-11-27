import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.UTM_CTR;
import View.Drone;

public class modelTests {
	
	//Os testes abaixo verificam as funcionalidades da classe do pacote Model (UTM_CTR)

	private UTM_CTR model;
	private UTM_CTR model1;
	private HashMap<String, List<Double>> allInfo;
	
	@Before
	public void setup()
	{
		Drone drone1 = new Drone ("4H_d1",1.0,1.0,1.0);
		Drone drone2 = new Drone ("8H_d2",80.5, 35.7, 6.8);
		Drone drone3 = new Drone ("8H_d3",100.0,87.6,0.0);
		
		allInfo = new HashMap<String, List<Double>>();
		
		allInfo.put(drone1.getDroneID(), drone1.getDronePosition());
		allInfo.put(drone2.getDroneID(), drone2.getDronePosition());
		allInfo.put(drone3.getDroneID(), drone3.getDronePosition());
	}
	
	@Test
	public void quandoRecebeTodasAsInformaçõesOUTM_CTRGeraOSAInfoCorretamente() {
		
		model = UTM_CTR.getInstance();
		
		String calculatedSAInfo = model.calculateSAInfo(allInfo);
		String expectedSAInfo = "Drone ID: 4H_d1 Drone Position: [1.0, 1.0, 1.0] ;\n" + 
				"Drone ID: 8H_d3 Drone Position: [100.0, 87.6, 0.0] ;\n" + 
				"Drone ID: 8H_d2 Drone Position: [80.5, 35.7, 6.8] ;\n" + 
				"Clean sky, no wind, 25 degrees celsius.\n";
		
		assertEquals(calculatedSAInfo,expectedSAInfo);

	}
	
	@Test
	public void sempreExistiraSomenteUmaInstanciaDeUTM_CTR() {
		model = UTM_CTR.getInstance();
		model1 = UTM_CTR.getInstance();
		
		assertSame(model1,model); // ambas as instancias são a mesma.
		
		//Observemos que a linha abaixo não compilaria, pois o construtor de UTM_CTR é private;
		//model = new UTM_CTR();

	}
	
}

