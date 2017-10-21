	package exec01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class exec01Tests {

	//Nesse teste, demostramos o funcionamento do mecanismo que possibilita ao programador escolher facilmente entre todos os tipos de cartas.
	//Basta que ele instancie o modelo de carta desejado com os dados necessarios (remetente, destinat�rio, endere�o de ambos e data) e, ap�s, instacie um builder com o modelo gerado.
	//Observemos que os tr�s modelos trabalham corretamente e para adicionar um novo modelo basta herdar da classe abstrata Letter e implementar as fun��es necess�rias.
	
	private Date date_;
	private Person sender_;
	private Phone senderPhone_;
	private Person destinatary_;
	private Phone destinataryPhone_;
	private Address addressSender_;
	private Address addressDestiny_;
	private LetterBuilder builder_;
	
	
	
	@Before
	public void setup() {
		date_ = new Date(16,10,2017);
		senderPhone_ = new Phone (34, 33333333);
		destinataryPhone_ = new Phone (12, 999999999);
		sender_ = new Person("Jos� da Silva", senderPhone_, "zedasilva@gmail.com");
		destinatary_ = new Person("Maria da Rosa", destinataryPhone_, "mariadarosa@outlook.com");
		addressSender_ = new Address("Rua da Pedra", 12, "Uberaba", "Brasil", "38015-000");
		addressDestiny_ = new Address("Alameda da Terra", 548, "S�o Jos� dos Campos", "Brasil", "12228-000");
		
	}
	
	@Test
	public void JoseSendsALoveLettlerToMaria() {
		LoveLetter loveLetter_ = new LoveLetter(sender_, destinatary_,addressSender_, addressDestiny_ ,date_);
		builder_ = new LetterBuilder(loveLetter_);
		String generatedString = builder_.buildLetter();
		String hardCodedString = "16/10/2017\n" + 
				"\n" + 
				"Jos� da Silva\n" + 
				"Rua da Pedra, 12, Uberaba, Brasil\n" + 
				"38015-000\n" + 
				"\n" + 
				"Maria da Rosa\n" + 
				"Alameda da Terra, 548, S�o Jos� dos Campos, Brasil\n" + 
				"12228-000\n" + 
				"\n" + 
				"My lovely Maria da Rosa,\n" + 
				"\n" + 
				"Love you!\n" + 
				"\n" + 
				"\n" + 
				"___________________\n" + 
				"\n" + 
				"Your lover, Jos� da Silva.";
				
		assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsAComercialLettlerToMaria() {
		ComercialLetter comercialLetter_ = new ComercialLetter(sender_, destinatary_,addressSender_, addressDestiny_ ,date_);
		builder_ = new LetterBuilder(comercialLetter_);
		String generatedString = builder_.buildLetter();
		String hardCodedString = "16/10/2017\n" + 
				"\n" + 
				"Jos� da Silva\n" + 
				"Rua da Pedra, 12, Uberaba, Brasil\n" + 
				"38015-000\n" + 
				"Maria da Rosa\nAlameda da Terra, 548, S�o Jos� dos Campos, Brasil\n" + 
				"12228-000\n" + 
				"\n" + 
				"Dear Maria da Rosa\n" + 
				"\n" + 
				"Sincerely,\n" + 
				"\n" + 
				"\n" + 
				"__________________\n" + 
				"Jos� da Silva\n" + 
				"(34) 33333333\n" + 
				"email:zedasilva@gmail.com";
		
		
		assertEquals(generatedString, hardCodedString);
	}
	
	@Test
	public void JoseSendsAReadersNoteToMaria() {
		ReadersNote readersNote_ = new ReadersNote(sender_, destinatary_,addressSender_, addressDestiny_ ,date_);
		builder_ = new LetterBuilder(readersNote_ );
		String generatedString = builder_.buildLetter();
		String hardCodedString = "16/10/2017\n" + 
				"\n" + 
				"Jos� da Silva\n" + 
				"Rua da Pedra, 12, Uberaba, Brasil\n" + 
				"38015-000\n" + 
				"Maria da Rosa\n" + 
				"Alameda da Terra, 548, S�o Jos� dos Campos, Brasil\n" + 
				"12228-000\n" + 
				"\n" + 
				"Reader's Note\n" + 
				"\n" + 
				"Dear Mr. Editorial Director, \n" + 
				"\n" + 
				"Best regards,\n" + 
				"\n" +  
				"__________________\n" + 
				"Jos� da Silva";
		
		System.out.println(generatedString);
		assertEquals(generatedString, hardCodedString);
	}

}
