package exec02;

public class AddressFactory {
	public Address makeAddress(String street, int number, String city, String country, String postalCode, String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USPAddress(street, number, city, country, postalCode);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRAddress(street, number, city, country, postalCode);
		}
		else return null;
	}
}
