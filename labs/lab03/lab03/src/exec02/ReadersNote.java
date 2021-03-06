package exec02;

public class ReadersNote extends Letter { 

	ReadersNote(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date)
	{
		super(sender,destinatary, addressSender,addressDestiny, date);
	}
	
	protected String header() {
		return date_.toPrint() + "\n\n" + sender_.name() + "\n" +
				addressSender_.toPrint() + "\n" + destinatary_.name() +"\n" +
				addressDestiny_.toPrint() + "\n\n";
	}
	
	protected String body() {
			return "Reader's Note" + "\n\n" + "Dear Mr. Editorial Director, "+ "\n\n" ;
	}
	
	protected String conclusion() {
			return "Best regards,\n";
	}
	
	protected String signature() {
			return "\n__________________\n" + sender_.name();
	}
	
}