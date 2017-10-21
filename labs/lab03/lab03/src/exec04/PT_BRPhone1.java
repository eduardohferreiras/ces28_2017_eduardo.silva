package exec04;

public class PT_BRPhone1 extends GenericPhone {

	public PT_BRPhone1(int areaCode, int number) {
		super(areaCode, number);
	}
	
	public String toPrint() {
		return "(" + this.areaCode_ + ") " + this.number_;
	}

}
