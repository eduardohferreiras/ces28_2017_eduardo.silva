package exec04;

public class PT_BRPerson extends GenericPerson {

	PT_BRPerson(String name, GenericPhone phone, String email, String gender) {
		super(name, phone, email, gender);
		// TODO Auto-generated constructor stub
	}
	
	public String name()
	{
		if(this.gender_.equals("F")) 
		{
			return "Sra " + this.name_;
		}
		else if(this.gender_.equals("M"))
		{
			return "Sr " + this.name_;
		}
		else return null;
	}
}
