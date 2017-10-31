package exec04;

public class GenericAddress {
	GenericAddress(String street, int number, String city, String country, String postalCode)
	{
		street_ = street;
		number_ = number;
		city_ = city;
		country_ = country;
		postalCode_ = postalCode;
	}

	protected String street_;
	protected int number_;
	protected String city_;
	protected String country_;
	protected String postalCode_;
	
	public String toPrint() {
		
		return street_ + ", " + number_ + ", " + city_ + ", " + country_ + "\n" + postalCode_;
	}
	
	public GenericAddress getSpecificAddress(String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USPAddress(street_, number_, city_, country_, postalCode_);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRAddress(street_, number_, city_, country_, postalCode_);
		}
		else return null;
	}

	
}
