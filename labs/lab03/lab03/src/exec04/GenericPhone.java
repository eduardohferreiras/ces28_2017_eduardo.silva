package exec04;

import java.util.HashMap;

public class GenericPhone {

	GenericPhone(int areaCode, int number)
	{
		areaCode_ = areaCode;
		number_ = number;
	}
	
	protected int areaCode_;
	protected int number_;
	
	public String toPrint() {
		return null;
	}

	public GenericPhone getSpecificPhone(String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USPPhone(areaCode_, number_);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRPhone1(areaCode_, number_);
		}
		else return null;
	}
	
}
