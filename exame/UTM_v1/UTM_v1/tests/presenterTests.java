import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import Presenter.Cloud;
import View.Drone;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class presenterTests {

	//Os testes abaixo verificam as funcionalidades da classe do pacote Presenter (Cloud)
	
	private Cloud cloud;
	private Drone drone1;
	
	@Before
	public void setup()
	{
		drone1 = mock(Drone.class);
	}
	
	@Test
	public void testeDeInicializacaoDaClasseCloud()
	{
		cloud = new Cloud();
		assertNotNull(cloud);
	}
	
	@Test
	public void testeDaFuncionalidadeGetAllInfoDoCloud() // esse teste evidencia também a funcionalidade da função addDrone;
	{
		when(drone1.getDroneID()).thenReturn("id");
		when(drone1.getDronePosition()).thenReturn(Arrays.asList(0.0,0.0,0.0));
		
		cloud = new Cloud();
		cloud.addDrone(drone1);
		
		HashMap<String, List<Double>> mapaEsperado = new HashMap<String, List<Double>>();
		mapaEsperado.put("id", Arrays.asList(0.0,0.0,0.0));
		
		assertEquals(mapaEsperado,cloud.getAllInfo());
		
	}
	

}
