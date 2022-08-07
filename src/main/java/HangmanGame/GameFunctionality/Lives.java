package HangmanGame.GameFunctionality;

public class Lives {
	
	int numLives = 7;
	int failures = 0;

	public int getNumLives() {
		return numLives;
	}

	public void setNumLives(int numLives) {
		this.numLives = numLives--;
		
	}

}
