package lab02;

import java.util.Arrays;

public class CalculadoraString {

	static public int add(String numbers) {
		int index = 0;
		int sum = 0;
		String regex = null;
		
		if(numbers.length() == 0)
			return 0;
		
		String array[] = numbers.split("]\n");
		
		if(array.length == 1)
		{
			index = 0;
			regex = " *,+ *| *\\n+ *";
		}
		else if (array.length == 2)
		{
			index = 1;
			char delimiter = array[0].charAt(3);
			regex = " *,+ *| *\n+ *| *" + delimiter + "+ *";
		}
		
	
		array = array[index].split(regex);
		for(int i = 0; i< array.length; i++)
		{
			if(!array[i].isEmpty() && array[i]!= " ") {
				sum += Integer.parseInt(array[i]);
			}
		}
		return sum;

	}

}
