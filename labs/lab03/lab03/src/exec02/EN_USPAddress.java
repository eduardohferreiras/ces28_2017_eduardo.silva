package exec02;

public class EN_USPAddress extends Address {

	EN_USPAddress(String street, int number, String city, String country, String postalCode) {
		super(street, number, city, country, postalCode);
	}
	
	public String toPrint() {
		
		return this.street_ + " Street, Number " + this.number_ + ", " + this.city_ + ", " + this.country_ + "\n" + this. postalCode_;
	}
}