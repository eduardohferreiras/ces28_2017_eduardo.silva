package exec04;

import org.junit.Before;
import org.junit.Test;

import exec03.ComercialLetter;
import exec03.GenericAddress;
import exec03.GenericDate;
import exec03.GenericPerson;
import exec03.GenericPhone;
import exec03.LetterBuilder;
import exec03.LoveLetter;
import exec03.ReadersNote;

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
	public void JoseSendsALoveLettlerToMariainPortuguese() {
		String idiom = "PT_BR";

		LoveLetter loveLetter_ = new LoveLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(loveLetter_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		//System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsALoveLettlerToMariainPortuguese2() {
		String idiom = "PT_BR";

		LoveLetter loveLetter_ = new LoveLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(loveLetter_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		//System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}
	
	private GenericDate _date;
	

}
