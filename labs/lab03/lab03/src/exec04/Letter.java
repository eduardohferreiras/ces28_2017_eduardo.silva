package exec04;

abstract class Letter {
	
	Letter(GenericPerson sender, GenericPerson destinatary, GenericAddress addressSender, GenericAddress addressDestiny, GenericDate date, String idiom)
	{
		sender_ = sender.getSpecificPerson(idiom);
		destinatary_ = destinatary.getSpecificPerson(idiom);
		addressSender_ = addressSender.getSpecificAddress(idiom); 
		addressDestiny_ = addressDestiny.getSpecificAddress(idiom);
		date_ = date.getSpecificDate(idiom);
		idiom_ = idiom;
	}
	
	protected GenericDate date_;
	protected GenericPerson sender_;
	protected GenericPerson destinatary_;
	protected GenericAddress addressSender_;
	protected GenericAddress addressDestiny_;
	protected String idiom_;

	public String model() {
		return header() + body() + conclusion() + signature();
	}
	
	protected String header() {
		return null;	
	}
	
	protected String body() {
			return null;
	}
	
	protected String conclusion() {
			return null;
	}
	
	protected String signature() {
		return null;
	}

	public Letter getSpecificLetter(String idiom) {
		return null;
	}
}
