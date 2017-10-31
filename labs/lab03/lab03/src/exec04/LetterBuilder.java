package exec04;

public class LetterBuilder {

	private Letter specificLanguageletter_;
	
	LetterBuilder(Letter letter, String idiom)
	{
		specificLanguageletter_ = letter.getSpecificLetter(idiom);
		
	}
	
	public String buildLetter()
	{
		return specificLanguageletter_.model();
	}
	
	
}
