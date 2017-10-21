package exec03;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class exec03Tests {

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
	public void JoseSendsALoveLettlerToMariainEnglish() {
		String idiom = "EN_US";

		LoveLetter loveLetter_ = new LoveLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(loveLetter_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
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
	public void JoseSendsACommercialLetterToMariainEnglish() {
		String idiom = "EN_US";

		ComercialLetter comercialLetter_ = new ComercialLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(comercialLetter_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		//System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsACommercialLetterToMariainPortuguese() {
		String idiom = "PT_BR";

		ComercialLetter comercialLetter_ = new ComercialLetter(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(comercialLetter_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		//ystem.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsAReadersNoteToMariainPortuguese() {
		String idiom = "PT_BR";

		ReadersNote readersNote_ = new ReadersNote(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(readersNote_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsAReadersNoteToMariainEnglish() {
		String idiom = "EN_US";

		ReadersNote readersNote_ = new ReadersNote(sender_, destinatary_, addressSender_,addressDestiny_, date_,idiom);
		builder_ = new LetterBuilder(readersNote_, idiom);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "";	
		
		System.out.println(generatedString);
		
		//assertEquals(generatedString, hardCodedString);
	}

}
