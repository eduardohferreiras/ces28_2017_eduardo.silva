package moneyPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*Teste referente ao passo 6 do processo*/
public class MoneyTest_4 {

	private Money _36USDm;
	private Money _52USDm ;
	private Money addResult;
	
	
	@Before
	public void setup () {
		this._36USDm = new Money(36, "USD");
		this._52USDm = new Money(52, "USD");
	}
	
	@Test
	public void WhenAddingSameCurrencyMoneysRetunsAMoneyWithSummedAmoutsAndCurrency() {
		
		this.addResult = this._36USDm.add(_52USDm);
		assertEquals(addResult.getAmount(),88);
		assertEquals(addResult.getCurrency().getCurrencyStr(),"USD");	
	}
}