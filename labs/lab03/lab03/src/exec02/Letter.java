package exec02;

abstract class Letter {
	
	Letter(Person sender, Person destinatary, Address addressSender, Address addressDestiny, Date date)
	{
		sender_ = sender;
		destinatary_ = destinatary;
		addressSender_ = addressSender; 
		addressDestiny_ = addressDestiny;
		date_ = date;
	}
	
	protected Date date_;
	protected Person sender_;
	protected Person destinatary_;
	protected Address addressSender_;
	protected Address addressDestiny_;

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
}