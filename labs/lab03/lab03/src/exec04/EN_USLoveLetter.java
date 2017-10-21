package exec04;

public class EN_USLoveLetter extends LoveLetter {

	public EN_USLoveLetter(GenericPerson sender, GenericPerson destinatary, GenericAddress addressSender,
			GenericAddress addressDestiny, GenericDate date, String idiom) {
		super(sender, destinatary, addressSender, addressDestiny, date, idiom);
		// TODO Auto-generated constructor stub
	}
	
	protected String header() {
		return date_.toPrint() + "\n\n" + sender_.name() + "\n" + addressSender_.toPrint() + "\n\n" + destinatary_.name() + "\n"
		+ addressDestiny_.toPrint()
		+ "\n\n";
	}
	
	protected String body() {
			return "My lovely " + destinatary_.name() + ",\n" ;
	}
	
	protected String conclusion() {
			return "\nLove you!\n";
	}
	
	protected String signature() {
			return "\n\n___________________\n\n" + "Your lover, " + sender_.name() + ".";
	}

}
