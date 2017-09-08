package lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class unitTests {
	private String input;

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
		
	}
	
	//
}
