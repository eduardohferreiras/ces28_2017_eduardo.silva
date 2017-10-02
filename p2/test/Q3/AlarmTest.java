package Q3.TireMonitor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;


public class AlarmTest {

	Sensor sensorDummy;

	@Before
	public void setup()
	{
		sensorDummy = mock(Sensor.class);
		
	}
	
	@Test
	public void incialmenteOAlarmeEstaDesligado() {
		
		Alarm alarm = new Alarm();
		assertFalse(alarm.isAlarmOn());
		
	}
	
	@Test
	public void quandoAPress„oMedida…MaiorQueOTressholdSuperiorOAlarmFicaOn() {
		
		Alarm alarm = new Alarm();
		PressureAnalyzer prAnaly = new PressureAnalyzer(sensorDummy, alarm, 17.0, 30.0);
		when(sensorDummy.popNextPressurePsiValue()).thenReturn(542.00);
		prAnaly.check();
		assertTrue(alarm.isAlarmOn());
		
	}
	
	@Test
	public void quandoAPress„oMedida…MenorQueOTressholdInferiorOAlarmFicaOn() {
		
		Alarm alarm = new Alarm();
		PressureAnalyzer prAnaly = new PressureAnalyzer(sensorDummy, alarm, 17.0, 30.0);
		when(sensorDummy.popNextPressurePsiValue()).thenReturn(2.00785);
		prAnaly.check();
		assertTrue(alarm.isAlarmOn());
		
	}

	@Test
	public void quandoAPress„oMedidaFicaDentroDosLimitesOAlarmN„oFicaOn() {
		
		Alarm alarm = new Alarm();
		PressureAnalyzer prAnaly = new PressureAnalyzer(sensorDummy, alarm, 17.0, 30.0);
		when(sensorDummy.popNextPressurePsiValue()).thenReturn(26.00785);
		prAnaly.check();
		assertFalse(alarm.isAlarmOn());
		
	}
	
}
