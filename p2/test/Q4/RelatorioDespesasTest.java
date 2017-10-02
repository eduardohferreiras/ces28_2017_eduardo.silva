package Q4.orig;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.mockito.Mockito;

public class RelatorioDespesasTest {

	SistemaOperacional soDummy;
	Calculadora calculadoraDummy;
	GeradorConteudo gcDummy;
	Despesa despesaDummy;
	Impressora impDummy;
	
	@Before
	public void setup()
	{
		soDummy = mock(SistemaOperacional.class);
		calculadoraDummy= mock(Calculadora.class);
		gcDummy = mock(GeradorConteudo.class);
		despesaDummy = mock(Despesa.class);
		impDummy = mock(Impressora.class);
	}
	
	@Test
	public void RelatorioDespesasChamaTodasOsMetodosNecessáriosComArgumentosCoerentes() {
		
		//Como não queremos que as demais classes afetem o teste, mockamos todas as outras classes e verificamos se
		//a classe testada chama todos os metodos que ela deve chamar com argumentos coerentes e um número correto de vezes.
		
		ArrayList<Despesa> despList = new ArrayList<Despesa>();
		
		when(calculadoraDummy.calcularValorTotalDespesas(despList.iterator())).thenReturn(0.0f);
		when(gcDummy.gerarConteudoRelatorio(0.0f)).thenReturn(" ");
		when(soDummy.getDriverImpressao()).thenReturn(impDummy);

		
		RelatorioDespesas relaDesp = new RelatorioDespesas();
		relaDesp.ImprimirRelatorio(despList.iterator(), calculadoraDummy, soDummy, gcDummy);
		
		
		Mockito.verify(calculadoraDummy,Mockito.times(1)).calcularValorTotalDespesas(Mockito.any());
		Mockito.verify(gcDummy,Mockito.times(1)).gerarConteudoRelatorio(0.0f);
		Mockito.verify(soDummy,Mockito.times(1)).getDriverImpressao();
		Mockito.verify(impDummy,Mockito.times(1)).Imprimir(" ");
	}

}
