import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Presenter.Cloud;
import View.Drone;
import View.GCS;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class viewTests {


	////Os testes abaixo verificam as funcionalidades das classes do pacote View (Drone e GCS)

	private List<Double> position;
	private Cloud cloud;
	private Drone drone1;
	private GCS gcs1;
	
	@Before
	public void setup()
	{
		cloud = mock(Cloud.class);
	}


	@Test
	public void testeDeInicializacaoDeDrone() {
		drone1 = new Drone ("4H_d4",0.0,1548.0,1.6);
		assertNotNull(drone1);
	}

	@Test
	public void testeDosMetodosDeRetornoDeDrone() {
		drone1 = new Drone ("4H_d4",0.0,1548.0,1.6);
		String id = drone1.getDroneID();
		position = drone1.getDronePosition();
		
		assertEquals(id,"4H_d4");
		assertEquals(position,Arrays.asList(0.0,1548.0, 1.6));
	
	}
	
	@Test
	public void testeDaImpressaoDaInformacaoRecevidaPeloGCS()
	{

		when(cloud.getActualSAInfo()).thenReturn("infoTeste");
		gcs1 = new GCS("4H_d4");
		gcs1.setCloud(cloud);
		
		String printedInfo = gcs1.printSAInfo();
		String expectedInfo = "O CGS responsavel pelo drone de id (4H_d4) recebeu a seguinte SA Info:\ninfoTeste";
				
		assertEquals(printedInfo,expectedInfo);
		
	}
}
