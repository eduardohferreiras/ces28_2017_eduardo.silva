
import java.util.LinkedHashMap;
import java.util.Map;



public class Dec2Roman {

	private static LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
    static void setup() {
		Results.put(1,"I");
	    Results.put(4,"IV");
	    Results.put(5,"V");
	    Results.put(9,"IX");
	    Results.put(10,"X");
	    Results.put(40, "XL");
	    Results.put(50, "L");
	    Results.put(90, "XC");
	    Results.put(100, "C");
	    Results.put(400, "CD");
	    Results.put(500, "D");
	    Results.put(900, "CM");
	    Results.put(1000, "M");
    }
    
	// esta indirecao extra so para poder trocar as versoes facil!
	// troque conv0 por conv1, conv2, conv10, etc. 
	// assim voce pode manter as versoes como metodos da mesma classe.
	public static String conv(int num) {
		setup();
		return conv2008(num);
	}
	
	// 1 {} -> null
	public static String conv0(int num) {
		return null; 	// version 0: no test passes.
	}
	
	// next iteration: one test passes
	// 2 nil -> constant
	public static String conv1(int num) {
		return "I";
	}
	
	/*********************************************************/
	// 3rd iteration: 2 tests pass
	// 4 Constant -> variable
	// 5 statement -> statements
	// 6 unconditional -> conditional
	public static String conv2(int num) {
		
		 String res = "I";

	     if (num > 1)
	        {
	            res += "I";
	        }
	     
	     return res;
	}

	// **************** WHAT YOU HAVE TO DO ****************
	// now write a convX method for each test. 
	// each new convX version must make a new test pass
	// BUT PERFORM ONLY THE MINIMUM CHANGES AT EACH STEP
	// *****************************************************
	
	public static String conv3(int num) {
		String res = "";
		int i = 0;
		while ( i < num)
		{
			res = res + "I";
			i++;
		}
		return res;
	}
	
	public static String conv4(int num) {
		if(num == 4)
			return "IV";
		else {
			String res = "";
			int i = 0;
			while ( i < num)
			{
				res = res + "I";
				i++;
			}
			return res;
		}
	}
	
	public static String conv5(int num) {
		
		String res = "";
		
		if(num == 4)
			return "IV";
		else if(num < 4){
			
			int i = 0;
			while ( i < num)
			{
				res = res + "I";
				i++;
			}
		}
		
		if(num == 5)
			return conv5(num-1).substring(1);
		else
			return res;
	}
	
	public static String conv8(int num) {
		String res = "";
		
		if(num == 4)
			return "IV";
		
		else if(num < 4){
			int i = 0;
			while ( i < num)
			{
				res = res + "I";
				i++;
			}
			return res;
		}
		
		if(num == 5)
			return conv8(num-1).substring(1);
		else 
			return conv8(5) + conv8(num-5);
	}

	public static String conv10(int num) {
		if(num == 9)
			return "IX";
		else if(num == 10)
			return conv10(num-1).substring(1);
		String res = "";
		
		if(num == 4)
			return "IV";
		
		else if(num < 4){
			int i = 0;
			while ( i < num)
			{
				res = res + "I";
				i++;
			}
			return res;
		}
		
		if(num == 5)
			return conv10(num-1).substring(1);
		else 
			return conv10(5) + conv10(num-5);
	}
	
	public static String conv14(int num) {
	    boolean achou = false;
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    Results.put(1,"I");
	    Results.put(4,"IV");
	    Results.put(5,"V");
	    Results.put(9,"IX");
	    Results.put(10,"X");
	    
        if (Results.containsKey(num) )
	       {
	           return Results.get(num);
	       }
        else 
        {
        	int i = num;
        	while(!Results.containsKey(i)) {
        		i--;
        	}
        	return Results.get(i) + conv14(num - i);
        }
	}
	
	public static String conv44(int num) {
	    boolean achou = false;
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    Results.put(1,"I");
	    Results.put(4,"IV");
	    Results.put(5,"V");
	    Results.put(9,"IX");
	    Results.put(10,"X");
	    Results.put(40, "XL");
	    Results.put(50, "L");
        if (Results.containsKey(num) )
	       {
	           return Results.get(num);
	       }
        else 
        {
        	int i = num;
        	while(!Results.containsKey(i)) {
        		i--;
        	}
        	return Results.get(i) + conv14(num - i);
        }
	}
	
	public static String conv100(int num) {
	    
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    Results.put(1,"I");
	    Results.put(4,"IV");
	    Results.put(5,"V");
	    Results.put(9,"IX");
	    Results.put(10,"X");
	    Results.put(40, "XL");
	    Results.put(50, "L");
	    Results.put(90, "XC");
	    Results.put(100, "C");
        if (Results.containsKey(num) ) {
	           return Results.get(num);
	       }
        else {
        	int i = 0;
        	for(Map.Entry<Integer, String> value : Results.entrySet()) {
        		if(value.getKey() < num) {
        			i = value.getKey();
        		} else 
        			break;
        	}
        	return Results.get(i) + conv100(num - i);
        }
	}
	
	public static String conv100s(int num) {
	    
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    Results.put(1,"I");
	    Results.put(4,"IV");
	    Results.put(5,"V");
	    Results.put(9,"IX");
	    Results.put(10,"X");
	    Results.put(40, "XL");
	    Results.put(50, "L");
	    Results.put(90, "XC");
	    Results.put(100, "C");
	    Results.put(400, "CD");
	    Results.put(500, "D");
        if (Results.containsKey(num) ) {
	           return Results.get(num);
	       }
        else {
        	int i = 0;
        	for(Map.Entry<Integer, String> value : Results.entrySet()) {
        		if(value.getKey() < num) {
        			i = value.getKey();
        		} else 
        			break;
        	}
        	return Results.get(i) + conv100s(num - i);
        }
	}
	

	public static String conv2008(int num) {
        if (Results.containsKey(num) ) {
	           return Results.get(num);
	       }
        else {
        	int i = 0;
        	for(Map.Entry<Integer, String> value : Results.entrySet()) {
        		if(value.getKey() < num) {
        			i = value.getKey();
        		} else 
        			break;
        	}
        	return Results.get(i) + conv2008(num - i);
        }
	}
}



	
		

