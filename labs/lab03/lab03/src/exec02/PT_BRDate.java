package exec02;

public class PT_BRDate extends Date {
	
	PT_BRDate(int day, int month, int year) {
		super(day, month, year);
	}

	public String toPrint()
	{
		return this.day_ + "/" + this.month_ + "/" + this.year_;
	}
}