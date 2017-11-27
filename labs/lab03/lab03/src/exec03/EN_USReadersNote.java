package exec03;

public class EN_USReadersNote extends ReadersNote {

	public EN_USReadersNote(GenericPerson sender, GenericPerson destinatary, GenericAddress addressSender,
			GenericAddress addressDestiny, GenericDate date, String idiom) {
		super(sender, destinatary, addressSender, addressDestiny, date, idiom);
		// TODO Auto-generated constructor stub
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