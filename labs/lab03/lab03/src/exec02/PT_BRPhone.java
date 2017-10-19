package exec02;

public class PT_BRPhone extends Phone {

	public PT_BRPhone(int areaCode, int number) {
		super(areaCode, number);
	}
	
	public String toPrint() {
		return "(" + this.areaCode_ + ") " + this.number_;
	}

}
