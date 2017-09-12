package lab02;

import java.util.regex.Pattern;
import java.util.*;
public class CalculadoraString {

	static public int add(String numbers) throws IllegalArgumentException {
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
			try {
				index = 1;
				String delimiter = array[0].charAt(3) + "";
				String delimiterEscaped = Pattern.quote(delimiter);
				regex = " *,+ *| *\n+ *| *" + delimiterEscaped + "+ *";
			}
			catch(IndexOutOfBoundsException exception)
			{
				throw new IllegalArgumentException();
			}
		}
		else
			throw new IllegalArgumentException();
		
		

		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		
		array = array[index].split(regex);
		for(int i = 0; i< array.length; i++)
		{

			if(!array[i].isEmpty() && array[i]!= " " && Integer.parseInt(array[i]) >= 0 ) {
				sum += Integer.parseInt(array[i]);
			}
			else if(!array[i].isEmpty() && array[i]!= " " && Integer.parseInt(array[i]) < 0 )
			{
				negativeNumbers.add(Integer.parseInt(array[i]));
			}
		}
		
		if(negativeNumbers.isEmpty())
			return sum;
		else {

			throw new IllegalArgumentException(generateMsg(negativeNumbers));
		}

	}

	static public String generateMsg(ArrayList<Integer> negativeNumbers)
	{
		String msg = "negativos proibidos [";
		for(int i = 0; i< negativeNumbers.size(); i++)
		{
			if(i != negativeNumbers.size() - 1)
				msg += negativeNumbers.get(i).toString() + " ";
			else
				msg += negativeNumbers.get(i).toString();
		}
		msg += "]";
		return msg;
	}
}
