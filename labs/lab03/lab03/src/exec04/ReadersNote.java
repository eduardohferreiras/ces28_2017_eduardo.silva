package exec04;

public class ReadersNote extends Letter { 

	ReadersNote(GenericPerson sender, GenericPerson destinatary, GenericAddress addressSender, GenericAddress addressDestiny, GenericDate date, String idiom)
	{
		super(sender,destinatary, addressSender,addressDestiny, date, idiom);
	}
	
	public Letter getSpecificLetter(String idiom) {
		if(idiom.equals("EN_US"))
			return new EN_USReadersNote(this.sender_, this.destinatary_, this.addressSender_,this.addressDestiny_, this.date_, idiom);
		else if(idiom.equals("PT_BR"))
			return new PT_BRReadersNote(this.sender_, this.destinatary_, this.addressSender_,this.addressDestiny_, this.date_, idiom);
		else return null;
	}
}