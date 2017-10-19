package exec03;

public class EN_USDate extends GenericDate {
	
	EN_USDate(int day, int month, int year) {
		super(day, month, year);
	}

	public String toPrint()
	{
		return this.month_ + "/" + this.day_ + "/" + this.year_;
	}
}
