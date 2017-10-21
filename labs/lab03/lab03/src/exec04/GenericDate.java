package exec04;

public class GenericDate {

	GenericDate(int day, int month, int year)
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
	
	public GenericDate getSpecificDate(String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USDate(day_, month_, year_);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRDate(day_, month_, year_);
		}
		else return null;
	}

}
