package exec04;

public class PT_BRLoveLetter extends LoveLetter {

	public PT_BRLoveLetter(GenericPerson sender, GenericPerson destinatary, GenericAddress addressSender,
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
			return "Querido(a) " + destinatary_.name() + ",\n" ;
	}
	
	protected String conclusion() {
			return "\nTe amo!\n";
	}
	
	protected String signature() {
			return "\n\n___________________\n\n" + "Seu amado(a), " + sender_.name() + ".";
	}

}