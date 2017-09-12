package lab02;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import lab02.CalculadoraString;


public class unitTests {
	private String input;

	
    @Rule
    public ExpectedException expectedExc = ExpectedException.none();
    
	@Test
	public void whenTheSeparatorIsCommaAndTheOnlyInvalidCharIsSpaceReturnsTheSum()
	{	
		input = "";
		assertEquals(0, CalculadoraString.add(input));
		input = "1";
		assertEquals(1, CalculadoraString.add(input));
		input = "1,2,3";
		assertEquals(6, CalculadoraString.add(input));
		input = "1   ,      2,3";
		assertEquals(6, CalculadoraString.add(input));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void charsOnInputsAreIllegal()
	{
		input = "X,5,6";
		CalculadoraString.add(input);
	}
	
	@Test
	public void whenThereAreALotOfSpacesAndCommasTheMethodWillIgnoreThoseChars()
	{
		input = "  , , ,     ,  ,";
		assertEquals(0, CalculadoraString.add(input));
		input = ",,,,  ,,  ,,,,";
		assertEquals(0, CalculadoraString.add(input));
		input = "1,2,3,  , ,,  ,4";
		assertEquals(10, CalculadoraString.add(input));
		input = " ";
		assertEquals(0, CalculadoraString.add(input));
	}

	@Test
	public void newLineCharCanBeASeparatorToo()
	{
		input = "1\n2,3";
		assertEquals(6, CalculadoraString.add(input));
		input = "1,\n";
		assertEquals(1, CalculadoraString.add(input));
	}	
	
	@Test
	public void newCustomSeparatorsAreAccepted()
	{
		input = "//[;]\n1;2,3\n4";
		assertEquals(10, CalculadoraString.add(input));
		input = "//[;]\n\n\n\n1,;,2,,, ,  ; ; ;;;3\n4";
		assertEquals(10, CalculadoraString.add(input));
		input = "//[*]\n\n\n\n1,*,2,,, , *3\n4";
		assertEquals(10, CalculadoraString.add(input));
		input = "//[ ]\n\n\n\n1,,2,,, , 3\n4";
		assertEquals(10, CalculadoraString.add(input));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void undefinedCustomSeparatorAreNotAccepted() throws IllegalArgumentException{
		input = "//[]\n\n\n\n1,,2,,, , 3\n4";
		CalculadoraString.add(input);
	}
	
	@Test
	public void negativeIntegerGeneratesProperException(){
		expectedExc.expect(IllegalArgumentException.class);
		expectedExc.expectMessage("negativos proibidos [-58 -34 -14]");
		CalculadoraString.add("//[*]\n1*,*-58,-34\n\n-14");
	}
	
	//
}
