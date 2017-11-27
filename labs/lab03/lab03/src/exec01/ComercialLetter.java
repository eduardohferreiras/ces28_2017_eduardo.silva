package exec01;

public class ComercialLetter extends Letter { 

	ComercialLetter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date)
	{
		super(sender,destinatary, addressSender,addressDestiny, date);
	}
	
	protected String header() {
		return date_.toPrint() + "\n\n" + sender_.name() + "\n" +
				addressSender_.toPrint() + "\n" + destinatary_.name() +"\n"+
				addressDestiny_.toPrint() + "\n\n";
	}
	
	protected String body() {
			return "Dear " + destinatary_.name() + "\n" ;
	}
	
	protected String conclusion() {
			return "\nSincerely,\n";
	}
	
	protected String signature() {
			return "\n\n__________________\n" + sender_.name() + "\n" + sender_.phone().toPrint() +
					"\nemail:" + sender_.email();
	}
	
}