package lab02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class unitTests {
	private String input;
	
	@Before
	public void setup()
	{
	}
		
	
	@Test
	public void whenTheSeparatorIsCommaAndTheOnlyInvalidCharIsSpaceReturnsTheSum()
	{
		input = "";
		assertEquals(0, CalculadoraString.add(input));
		input = "1";
		assertEquals(1, CalculadoraString.add(input));
		input = "1,2,3";
		assertEquals(6, CalculadoraString.add(input));
		input = "1, 2,3";
		assertEquals(6, CalculadoraString.add(input));
	}
}
