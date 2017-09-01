package labnf;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class test01 {
	ValidaCPF validador;
	DBCliente dbcliente;
	Cliente cliente;
	BDProd dbprod;
	ItemInterface itemmock;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void QuandoTentaCriarUmaaNotaParaUmCPFValidoGeraNota(){
		validador = mock(ValidaCPF.class);
		dbcliente = mock(DBCliente.class);
		cliente = mock(Cliente.class);
		dbprod = mock(BDProd.class);
		itemmock = mock(ItemInterface.class);
		when(dbprod.getProd(0)).thenReturn(itemmock);
		when(validador.valida(1234)).thenReturn(true);
		when(dbcliente.getCliente(1234)).thenReturn(cliente);
		NotaFiscal nota1 = new NotaFiscal(1234,0,0, validador, dbcliente, dbprod);	
		
		Mockito.verify(validador,Mockito.times(1)).valida(1234);
	}
	
	@Test (expected = NullPointerException.class)
	public void QuandoTentaCriarUmaaNotaParaUmCPFInvalidoGeraExcessao(){
		validador = mock(ValidaCPF.class);
		dbcliente = mock(DBCliente.class);
		cliente = mock(Cliente.class);
		dbprod = mock(BDProd.class);
		itemmock = mock(ItemInterface.class);
		when(dbprod.getProd(0)).thenReturn(itemmock);
		when(validador.valida(1234)).thenThrow(new NullPointerException());
		NotaFiscal nota1 = new NotaFiscal(1234,0,0, validador, dbcliente, dbprod);	
		Mockito.verify(validador,Mockito.times(1)).valida(1234);
	}
	
	@Test
	public void QuandoTentaAdicionarERemoverItensTudoOcorreCorretamente() {
		validador = mock(ValidaCPF.class);
		dbcliente = mock(DBCliente.class);
		cliente = mock(Cliente.class);
		dbprod = mock(BDProd.class);
		itemmock = mock(ItemInterface.class);
		when(dbprod.getProd(3)).thenReturn(itemmock);
		when(itemmock.getValor()).thenReturn(2);
		when(validador.valida(1234)).thenReturn(true);
		when(dbcliente.getCliente(1234)).thenReturn(cliente);
		NotaFiscal nota = new NotaFiscal(1234, 2, 19, validador, dbcliente, dbprod);
		assertEquals(1, nota.numItens());
		assertEquals(2, nota.get(0).getId());
		assertEquals(19, nota.get(0).getQnt());
		nota.addItem(3, 79);
		assertEquals(3, nota.get(1).getId());
		assertEquals(79, nota.get(1).getQnt());
		nota.rmvItem(3, 9);
		assertEquals(3, nota.get(1).getId());
		assertEquals(70, nota.get(1).getQnt());
		nota.rmvItem(2, 20);
		assertEquals(3, nota.get(0).getId());
		assertEquals(70, nota.get(0).getQnt());
		assertEquals(140, nota.ValorTotal());
	}
	
	@Test
	public void QuandoTrocaItemPorOutroVerificaSeOValorEstaCorretoDepoisDaTroca() {
		validador = mock(ValidaCPF.class);
		dbcliente = mock(DBCliente.class);
		cliente = mock(Cliente.class);
		dbprod = mock(BDProd.class);
		itemmock = mock(ItemInterface.class);
		when(dbprod.getProd(0)).thenReturn(itemmock);
		when(validador.valida(1234)).thenReturn(true);
		when(dbcliente.getCliente(1234)).thenReturn(cliente);
		NotaFiscal nota = new NotaFiscal(1234, 2, 19, validador, dbcliente, dbprod);
		nota.trocaItem(2, 3, 70);
		assertEquals(1, nota.numItens());
		assertEquals(3, nota.get(0).getId());
		assertEquals(70, nota.get(0).getQnt());
	}
	
	@Test (expected = ProdutoNaoCatalogadoException.class)
	public void QuandoAdicionaUmItemQueNaoTemNoBDRetornaExcecao() {
		validador = mock(ValidaCPF.class);
		dbcliente = mock(DBCliente.class);
		cliente = mock(Cliente.class);
		dbprod = mock(BDProd.class);
		itemmock = mock(ItemInterface.class);
		when(dbprod.getProd(2)).thenThrow(new ProdutoNaoCatalogadoException());
		when(validador.valida(1234)).thenReturn(true);
		when(dbcliente.getCliente(1234)).thenReturn(cliente);
		NotaFiscal nota = new NotaFiscal(1234, 2, 19, validador, dbcliente, dbprod);
	}
	
	@Test (expected = ListaVaziaException.class)
	public void QuantoTentaEsvaziarAListaNaoEhPossivel() {
		validador = mock(ValidaCPF.class);
		dbcliente = mock(DBCliente.class);
		cliente = mock(Cliente.class);
		dbprod = mock(BDProd.class);
		itemmock = mock(ItemInterface.class);
		when(dbprod.getProd(2)).thenReturn(itemmock);
		when(validador.valida(1234)).thenReturn(true);
		when(dbcliente.getCliente(1234)).thenReturn(cliente);
		NotaFiscal nota = new NotaFiscal(1234, 2, 19, validador, dbcliente, dbprod);	
		nota.rmvItem(2, 19);
	
	}
}
