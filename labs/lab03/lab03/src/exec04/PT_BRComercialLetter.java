package exec04;

public class PT_BRComercialLetter extends ComercialLetter {

	PT_BRComercialLetter(GenericPerson sender, GenericPerson destinatary, GenericAddress addressSender,
			GenericAddress addressDestiny, GenericDate date, String idiom) {
		super(sender, destinatary, addressSender, addressDestiny, date, idiom);
	}
	
	protected String header() {
		return date_.toPrint() + "\n\n" + sender_.name() + "\n" +
				addressSender_.toPrint() + "\n" + destinatary_.name() +"\n"+
				addressDestiny_.toPrint() + "\n\n";
	}
	
	protected String body() {
			return "Prezado(a) " + destinatary_.name() + "\n" ;
	}
	
	protected String conclusion() {
			return "\nAtenciosamente,\n";
	}
	
	protected String signature() {
			return "\n\n__________________\n" + sender_.name() + "\n" + sender_.phone().getSpecificPhone("PT_BR").toPrint() +
					"\nemail:" + sender_.email();
	}

}
