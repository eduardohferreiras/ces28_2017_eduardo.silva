package exec02;

public class DateFactory {
	public Date makeDate(int day, int month, int year, String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USDate(day, month, year);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRDate(day, month, year);
		}
		else return null;
	}
}
