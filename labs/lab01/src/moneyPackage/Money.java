package moneyPackage;

public class Money {
	public	Money(int amount, String currency)	{
		this._currency = new Currency(currency);
		this.setAmount(amount);
	}

	public Money add(Money m) { 
	
	Money money = new Money(0,"");

	money.setAmount(this.getAmount() + m.getAmount()); 	
	money.getCurrency().setCurrencyStr(this._currency.getCurrencyStr());
	
	return	money;
	}

	public int getAmount() {
		return _amount;
	}
	 
	public void setAmount(int amount) {
		this._amount = amount;
	}
	
	public Currency getCurrency() {
		return _currency;
	}
		
	private int _amount;
	private Currency _currency;

}