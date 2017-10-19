package exec02;

public class EN_USPPhone extends Phone {

	EN_USPPhone(int areaCode, int number) {
		super(areaCode, number);
	}
	public String toPrint() {
		return this.areaCode_ +""+ this.number_;
	}

}
