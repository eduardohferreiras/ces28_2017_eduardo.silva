package exec02;

public class PhoneFactory {
	public Phone makePhone(int areaCode, int number, String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USPPhone(areaCode, number);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRPhone(areaCode, number);
		}
		else return null;
	}

}
