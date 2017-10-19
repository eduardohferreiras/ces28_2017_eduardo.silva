package exec02;

public class EN_USPerson extends Person {

	EN_USPerson(String name, Phone phone, String email, String gender) {
		super(name, phone, email, gender);
		// TODO Auto-generated constructor stub
	}

	public String name()
	{
		if(this.gender_.equals("F")) 
		{
			return "Ms " + this.name_;
		}
		else if(this.gender_.equals("M"))
		{
			return "Mr " + this.name_;
		}
		else return null;
	}
}
