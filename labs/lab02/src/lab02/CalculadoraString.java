package lab02;

public class CalculadoraString {

	static public int add(String numbers) {
		if(numbers.length() == 0)
			return 0;
		
		int sum =0;
		String array[] = numbers.split(",");
		
		for(int i = 0; i< array.length; i++)
		{
			sum += Integer.parseInt(array[i]);
		}
		return sum;
	}
}
