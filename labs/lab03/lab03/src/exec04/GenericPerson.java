package exec04;

public class GenericPerson {

	GenericPerson(String name, GenericPhone phone, String email, String gender)
	{
		name_ = name;
		phone_ = phone;
		email_ = email;
		gender_ = gender;
	}
	
	protected String name_;
	protected GenericPhone phone_;
	protected String email_;
	protected String gender_;
	
	public String name() {
		return null;
	}

	public GenericPhone phone() {
		return phone_;
	}

	public void changePhone(GenericPhone phone) {
		phone_ = phone;
	}
	
	public String email() {
		return email_;
	}

	public GenericPerson getSpecificPerson(String idiom)
	{
		if(idiom.equals("EN_US"))
		{
			return new EN_USPerson(name_,phone_,email_,gender_);
		}
		else if(idiom.equals("PT_BR"))
		{
			return new PT_BRPerson(name_,phone_,email_,gender_);
		}
		else return null;
	}
}
