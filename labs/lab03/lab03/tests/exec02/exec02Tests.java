package exec02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class exec02Tests {
	
	private DateFactory dateFCT_;
	private Date date_;
	
	private PersonFactory personFCT_;
	private Person sender_;
	private Person destinatary_;
	
	private PhoneFactory phoneFCT_;
	private Phone senderPhone_;
	private Phone destinataryPhone_;
	
	private AddressFactory addressFCT_;
	private Address addressSender_;
	private Address addressDestiny_;
	
	private LetterBuilder builder_;
	
	@Before
	public void setup()
	{
		dateFCT_ = new DateFactory();
		personFCT_ = new PersonFactory();
		addressFCT_ = new AddressFactory();
		phoneFCT_ = new PhoneFactory();
	}
	

	@Test
	public void JoseSendsALoveLettlerToMariaWithFieldsinEnglish() {
		String idiom = "EN_US";
		date_ = dateFCT_.makeDate(16,10,2017, idiom);
		
		senderPhone_ = phoneFCT_.makePhone (34, 33333333,idiom);
		destinataryPhone_ = phoneFCT_.makePhone(12, 999999999,idiom);
		sender_ = personFCT_.makePerson("Jos� da Silva", senderPhone_, "zedasilva@gmail.com", "M", idiom);
		destinatary_ =  personFCT_.makePerson("Maria da Rosa", destinataryPhone_, "mariadarosa@outlook.com","F", idiom);
		
		addressSender_ = addressFCT_.makeAddress("Rua da Pedra", 12, "Uberaba", "Brasil", "38015-000", idiom);
		addressDestiny_ = addressFCT_.makeAddress("Alameda da Terra", 548, "S�o Jos� dos Campos", "Brasil", "12228-000", idiom);
		
		
		LoveLetter loveLetter_ = new LoveLetter(sender_, destinatary_,addressSender_, addressDestiny_ ,date_);
		builder_ = new LetterBuilder(loveLetter_);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "10/16/2017\n" + 
				"\n" + 
				"Mr Jos� da Silva\n" + 
				"Rua da Pedra Street, Number 12, Uberaba, Brasil\n" + 
				"38015-000\n" + 
				"\n" + 
				"Ms Maria da Rosa\n" + 
				"Alameda da Terra Street, Number 548, S�o Jos� dos Campos, Brasil\n" + 
				"12228-000\n" + 
				"\n" + 
				"My lovely Ms Maria da Rosa,\n" + 
				"\n" + 
				"Love you!\n" + 
				"\n" + 
				"\n" + 
				"___________________\n" + 
				"\n" + 
				"Your lover, Mr Jos� da Silva."	;	
		
		assertEquals(generatedString, hardCodedString);
	}

	@Test
	public void JoseSendsALoveLettlerToMariaWithSomeFieldsinPortuguese() {
		String idiom = "PT_BR";
		date_ = dateFCT_.makeDate(16,10,2017, idiom);
		
		senderPhone_ = phoneFCT_.makePhone (34, 33333333,idiom);
		destinataryPhone_ = phoneFCT_.makePhone(12, 999999999,idiom);
		sender_ = personFCT_.makePerson("Jos� da Silva", senderPhone_, "zedasilva@gmail.com", "M", idiom);
		destinatary_ =  personFCT_.makePerson("Maria da Rosa", destinataryPhone_, "mariadarosa@outlook.com","F", idiom);
		
		addressSender_ = addressFCT_.makeAddress("Rua da Pedra", 12, "Uberaba", "Brasil", "38015-000", idiom);
		addressDestiny_ = addressFCT_.makeAddress("Alameda da Terra", 548, "S�o Jos� dos Campos", "Brasil", "12228-000", idiom);
		
		
		LoveLetter loveLetter_ = new LoveLetter(sender_, destinatary_,addressSender_, addressDestiny_ ,date_);
		builder_ = new LetterBuilder(loveLetter_);
		String generatedString = builder_.buildLetter();
		
		String hardCodedString = "16/10/2017\n" + 
				"\n" + 
				"Sr Jos� da Silva\n" + 
				"Rua da Pedra, N�mero 12, Uberaba, Brasil\n" + 
				"38015-000\n" + 
				"\n" + 
				"Sra Maria da Rosa\n" + 
				"Alameda da Terra, N�mero 548, S�o Jos� dos Campos, Brasil\n" + 
				"12228-000\n" + 
				"\n" + 
				"My lovely Sra Maria da Rosa,\n" + 
				"\n" + 
				"Love you!\n" + 
				"\n" + 
				"\n" + 
				"___________________\n" + 
				"\n" + 
				"Your lover, Sr Jos� da Silva.";
		
		System.out.println(generatedString);
		assertEquals(generatedString, hardCodedString);
	}

}
