package HangmanGame.GameFunctionality;

public class Word {
	
	private String randomWord[] = {"TORO", "GEMA", "GOMA", "PISO", "RABO", "TIMO", "RETO", "COCO", "MESA", "COPA"};
	private String secret;
	private String arrayWord[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	//RANDOM SECRET WORD CONSTRUCTOR
	public Word() {
		this.secret = randomWord[(int)Math.floor(Math.random()*9)];

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


