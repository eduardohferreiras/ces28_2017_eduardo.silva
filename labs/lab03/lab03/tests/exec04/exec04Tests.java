package exec04;

import static org.junit.Assert.*;

import org.junit.Before;

import org.junit.Test;

import exec04.ComercialLetter;
import exec04.GenericAddress;
import exec04.GenericDate;
import exec04.GenericPerson;
import exec04.GenericPhone;
import exec04.LetterBuilder;
import exec04.LoveLetter;
import exec04.ReadersNote;

public class exec04Tests {
	private GenericDate date_;
	
	private GenericPerson sender_;
	private GenericPerson destinatary_;
	

	private GenericPhone senderPhone_;
	private GenericPhone destinataryPhone_;
	
	private GenericAddress addressSender_;
	private GenericAddress addressDestiny_;
	
	private LetterBuilder builder_;
	
	@Before
	public void setup()
	{
		date_ = new GenericDate(16,10,2017);
		
		senderPhone_ = new GenericPhone (34, 33333333);
		destinataryPhone_ = new GenericPhone(12, 999999999);
		sender_ = new GenericPerson("Jos� da Silva", senderPhone_, "zedasilva@gmail.com", "M");
		destinatary_ =  new GenericPerson("Maria da Rosa", destinataryPhone_, "mariadarosa@outlook.com","F");
		
		addressSender_ = new GenericAddress("Rua da Pedra", 12, "Uberaba", "Brasil", "38015-000");
		addressDestiny_ = new GenericAddress("Alameda da Terra", 548, "S�o Jos� dos Campos", "Brasil", "12228-000");
	}
	
	
	@Test
	public void JoseSendsAComercialToMariainPortuguese() {
		String idiom = "PT_BR";

		ComercialLetter letter_ = new ComercialLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(letter_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "16/10/2017\n" + 
				"\n" + 
				"Sr Jos� da Silva\n" + 
				"Rua da Pedra, N�mero 12, Uberaba, Brasil\n" + 
				"38015-000\n" + 
				"Sra Maria da Rosa\n" + 
				"Alameda da Terra, N�mero 548, S�o Jos� dos Campos, Brasil\n" + 
				"12228-000\n" + 
				"\n" + 
				"Prezado(a) Sra Maria da Rosa\n" + 
				"\n" + 
				"Atenciosamente,\n" + 
				"\n" + 
				"\n" + 
				"__________________\n" + 
				"Sr Jos� da Silva\n" + 
				"DDD: 34 Number: 33333333\n" + 
				"email:zedasilva@gmail.com";	
		
		assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsAComercialToMariainPortuguese2() {
		String idiom = "PT_BR";
		sender_.changePhone(new PT_BRPhone2(34, 33333333));
		ComercialLetter letter_ = new ComercialLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		
		builder_ = new LetterBuilder(letter_, idiom);
		
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}
	
	private GenericDate _date;
	

}
