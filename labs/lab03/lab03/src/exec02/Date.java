package exec02;

public abstract class Date {

	Date(int day, int month, int year)
	{
		day_ = day;
		month_ = month;
		year_ = year;	
	}
	
	protected int day_;
	protected int month_;
	protected int year_;
	
	public String toPrint() {
		return null;
	}

}