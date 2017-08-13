package moneyPackage;

public class Currency {
	
	public	Currency(String currency)	{
		this.setCurrencyStr(currency);
	}
	
	public String getCurrencyStr() { 
		return _currency;
	}

	public void setCurrencyStr(String currency) {
		this._currency = currency;
	}
	
	private String _currency;
}
