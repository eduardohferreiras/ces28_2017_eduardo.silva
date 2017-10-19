package exec01;

public class Phone {

	Phone(int DDD, int number)
	{
		DDD_ = DDD;
		number_ = number;
	}
	
	private int DDD_;
	private int number_;
	
	public String toPrint() {
		return "(" + DDD_ + ") " + number_;
	}


}
