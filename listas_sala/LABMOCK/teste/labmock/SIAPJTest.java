package labmock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class SIAPJTest {
	IServicoEmail emailDummy;
	IServicoDB dbDummy;
	IValidatorProcesso procValDummy;
	IProcesso procDummy;
	
	@Before
	public void setup() {
		emailDummy = mock(IServicoEmail.class);
		dbDummy = mock(IServicoDB.class);
		procValDummy = mock(IValidatorProcesso.class);
		procDummy = mock(IProcesso.class);
	}
	
	@Test
	public void testConstructor() {
		
		SIAPJ siapj =  new SIAPJ(emailDummy, dbDummy, procValDummy);
		assertNotNull(siapj);
		
	}
	
	@Test
	public void testCriarReclamacaoFalse() throws SQLException {
		when(procValDummy.validaProcesso(procDummy)).thenReturn(false);
		when(emailDummy.sendEmail(procDummy.getEmail(), "Existem erros em seu processo")).thenReturn(false);
		when(procDummy.getEmail()).thenReturn(" ");
		SIAPJ siapj = new SIAPJ(emailDummy, dbDummy, procValDummy);
		
		siapj.criaReclamacao(procDummy);
		
		Mockito.verifyZeroInteractions(dbDummy);
		
		Mockito.verify(emailDummy,Mockito.times(1)).sendEmail(Mockito.any(), Mockito.any());
	}

	@Test
	public void testCriarReclamacaoTrue() throws SQLException {
		when(procValDummy.validaProcesso(procDummy)).thenReturn(true);
		when(emailDummy.sendEmail(procDummy.getEmail(), "Processo aceito")).thenReturn(false);
		when(procDummy.getEmail()).thenReturn(" ");
		when(dbDummy.persisteProcesso(procDummy)).thenReturn(1);
		SIAPJ siapj = new SIAPJ(emailDummy, dbDummy, procValDummy);
		
		siapj.criaReclamacao(procDummy);
		
		Mockito.verify(dbDummy,Mockito.times(1)).persisteProcesso(Mockito.any());
		Mockito.verify(emailDummy,Mockito.times(1)).sendEmail(Mockito.any(), Mockito.any());
	}

}
