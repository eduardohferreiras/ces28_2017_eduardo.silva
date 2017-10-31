package exec04;

public class PT_BRPhone1 extends GenericPhone {

	public PT_BRPhone1(int areaCode, int number) {
		super(areaCode, number);
	}
	
	public String toPrint() {
		return "DDD: " + this.areaCode_ + " Number: " + this.number_;
	}

}
