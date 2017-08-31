package labnf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class test01 {
	
	
	@Test (expected = NullPointerException.class)
	public void QuandoTentaCriarUm9aNotaParaUmCPFInvalidoGeraExcessao(){
		ValidaCPF validador = mock(ValidaCPF.class);
		
		when(validador.valida(1234)).thenThrow(new NullPointerException());
		NotaFiscal nota1 = new NotaFiscal(1234);

		
	}
}
