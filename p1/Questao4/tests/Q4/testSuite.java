package Q4;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

public class testSuite {

	Sensor sensorDummy;
	Datacenter DCDummy;
	PainelCondutor PCDummy;
	
	@Before
	public void setup()
	{
		sensorDummy = mock(Sensor.class);
		DCDummy= mock(Datacenter.class);
		PCDummy= mock(PainelCondutor.class);
	}
	
	
	//Esse teste equivale ao item 4a)
	@Test
	public void testeDeInicializa��oDoControladorPTC() {
		ControladorPTC cPTC = new ControladorPTC(sensorDummy,DCDummy,PCDummy);
		assertNotNull(cPTC);
	}

	//Esse teste equivale ao item 4b)
	@Test
	public void testeParaQuandoOTremN�oSeEncontraEmCruzamento()
	{
		//Estamos utilizando um stub (resposta enlatada), para conseguir testar o caso atual.
		when(sensorDummy.isCruzamento()).thenReturn(false);
		
		ControladorPTC cPTC = new ControladorPTC(sensorDummy,DCDummy,PCDummy); 
		ControladorPTC cPTCSpy = Mockito.spy(cPTC);
		
		cPTCSpy.run();
		//Como os m�todos enviaMsgDatacenter e enviaMsgNormalPainel s�o chamados uma vez cada podemos concluir que run executou corretamente.
		Mockito.verify(cPTCSpy,Mockito.times(1)).enviaMsgDatacenter(Mockito.any(), Mockito.any());
		Mockito.verify(cPTCSpy,Mockito.times(1)).enviaMsgNormalPainel(Mockito.any(), Mockito.any());
		
	}
	
	//Esse teste equivale ao item 4c)
	@Test
	public void testeParaQuandoOTremEst�NoCruzamentoAMaisDe100kmhEOUsuarioL�AMensagem()
	{
		
		when(sensorDummy.isCruzamento()).thenReturn(true);
		when(sensorDummy.getVelocidade()).thenReturn((double) 200);
		when(PCDummy.imprimirAviso("Velocidade alta", 1)).thenReturn(true);
		
		ControladorPTC cPTC = new ControladorPTC(sensorDummy,DCDummy,PCDummy);
		ControladorPTC cPTCSpy = Mockito.spy(cPTC);
		
		//Observemos que o usu�rio consegue ler a mensagem e o trem n�o tenta diminuir a velocidade, como era de se esperar.
		cPTCSpy.run();
		assertTrue(cPTCSpy.enviaMsgPrioritariaPainel("Velocidade alta",PCDummy));
		Mockito.verify(cPTCSpy,Mockito.times(0)).diminuiVelocidade(20);

	}
	
	//Esse teste equivale ao item 4d)
	@Test
	public void testeParaQuandoOTremEst�NoCruzamentoAMenosDe20kmhEOUsuarioN�oL�AMensagem()
	{
		
		when(sensorDummy.isCruzamento()).thenReturn(true);
		when(sensorDummy.getVelocidade()).thenReturn((double) 10);
		when(PCDummy.imprimirAviso("Velocidade Baixa", 1)).thenReturn(false);
		
		ControladorPTC cPTC = new ControladorPTC(sensorDummy,DCDummy,PCDummy);
		ControladorPTC cPTCSpy = Mockito.spy(cPTC);
		
		//Observemos que o usu�rio N�O consegue ler a mensagem e o trem ent�o tenta aumentar a velocidade, como era de se esperar.
		cPTCSpy.run();
		assertFalse(cPTCSpy.enviaMsgPrioritariaPainel("Velocidade Baixa",PCDummy));
		Mockito.verify(cPTCSpy,Mockito.times(1)).aumentaVelocidade(20);

	}

}
