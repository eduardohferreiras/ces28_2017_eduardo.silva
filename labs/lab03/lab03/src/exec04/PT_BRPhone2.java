package exec04;

public class PT_BRPhone2 extends GenericPhone {

	public PT_BRPhone2(int areaCode, int number) {
		super(areaCode, number);
	}
	
	public String toPrint() {
		return "(" + this.areaCode_ + ")" + this.number_;
	}

}
