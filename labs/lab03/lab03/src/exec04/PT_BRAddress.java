package exec04;

public class PT_BRAddress extends GenericAddress {

	PT_BRAddress(String street, int number, String city, String country, String postalCode) {
		super(street, number, city, country, postalCode);
	}
	
	public String toPrint() {
		
		return this.street_ + ", N�mero " + this.number_ + ", " + this.city_ + ", " + this.country_ + "\n" + this. postalCode_;
	}

}
