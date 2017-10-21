package exec04;

import java.util.HashMap;

public class GenericPhone {

	GenericPhone(int areaCode, int number)
	{
		areaCode_ = areaCode;
		number_ = number;
		//((Object) PT_BRPhone).add(0, new PT_BRPhone1(areaCode, number));
		PT_BRPhone.put(ind++, new PT_BRPhone1(areaCode, number));
	}
	
	protected int areaCode_;
	protected int number_;
	int ind = 0;
	public static HashMap<Integer, GenericPhone> PT_BRPhone = new HashMap<Integer,GenericPhone>();
	
	public String toPrint() {
		return null;
	}

	public GenericPhone getSpecificPhone(String idiom, int type)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USPPhone(areaCode_, number_);
		}
		else if(idiom.equals("PT_BR"))
		{
			return PT_BRPhone.get(type);
		}
		else return null;
	}
	
	public void AddPhoneBR(GenericPhone phone) {
		PT_BRPhone.put(ind++, phone);
	}
	
}
