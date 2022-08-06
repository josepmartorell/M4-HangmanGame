package HangmanGame.GameFunctionality;

public class Word {
	
	private String randomWord[] = {"TORO", "GEMA", "GOMA", "PISO", "RABO", "TIMO", "RETO", "COCO", "MESA", "COPA"};
	private String secret;
	private String arrayWord[];
	
	//RANDOM SECRET WORD CONSTRUCTOR
	public Word() {
		this.secret = randomWord[(int)(Math.random()*(randomWord.length-0+1)+0)];

	}
    //GETTER
	public String getSecretWord() {
		return secret;
	}
	
	public String[] getArrayWord() {
		return arrayWord;
	}
	public void setArrayWord(String[] arrayWord) {
		this.arrayWord = arrayWord;
	}
	// WORD SPLITTER METHOD
	public String[] wordSplited() {
		return this.secret.split("");
	}
		

}


