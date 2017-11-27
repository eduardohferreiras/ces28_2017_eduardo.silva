package exec01;

public class Address {
	Address(String street, int number, String city, String country, String postalCode)
	{
		street_ = street;
		number_ = number;
		city_ = city;
		country_ = country;
		postalCode_ = postalCode;
	}

	private String street_;
	private int number_;
	private String city_;
	private String country_;
	private String postalCode_;
	
	public String toPrint() {
		
		return street_ + ", " + number_ + ", " + city_ + ", " + country_ + "\n" + postalCode_;
	}

	
}