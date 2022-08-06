package HangmanGame.GameFunctionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import HangmanGame.GameInterface.GamingInterface;

public class EventManager implements ActionListener{
	
	private GamingInterface gamingInterface;
    private Lives lives;
    private Word word;
    private String[] letters;
    private String[] mask;
    //private ButtonGroup keyboard;

	public EventManager(GamingInterface gameingInterface) {
		//INTERFACE INSTANCE
		this.gamingInterface = gameingInterface;
		this.lives = new Lives();
		this.word = new Word();
		this.letters = this.word.wordSplited();
		
		

	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("START GAME")) {
			//INITIALIZE GAME
			initializeGame();
			//SPECIFIC EVENT SOURCE BUTTON FROM BUTTONGROUP EVENT
		}else if(e.getActionCommand().equals("letter")) {
			JButton letra = (JButton) e.getSource();
			//CYCLES THE LETTERS OF THE SECRET WORD COMPARING THEM WITH THE USER'S PASSWORD
			for (String string : letters) {
				System.out.println("SECRET: "+string+" USER KEY: "+letra.getText()); //MONITORING
				if(string == letra.getText()) {
					
				}
				
			}
			gamingInterface.textFieldWord.setText("");
			
		}else if(e.getActionCommand().equals("About")) {
			JOptionPane.showMessageDialog(gamingInterface,  "THE HANGMAN GAME (PREMIUM VERSION)\n"
					+ "\nCreators:"
					+ "\n -> Felipe Gomez\n"
					+ " -> Adria Mila\n"
					+ " -> Josep Martorell\n\n"
					+ "Special thanks to JOSE MARÍN *****");
		}else if(e.getActionCommand().equals("Exit")) {
			System.exit(0);
		};

		
	}
	
	
	
	public void initializeGame(){
		//SHOW BULBS
		gamingInterface.label_bulb_1.setVisible(true);
		gamingInterface.label_bulb_2.setVisible(true);
		gamingInterface.label_bulb_3.setVisible(true);
		gamingInterface.label_bulb_4.setVisible(true);
		gamingInterface.label_bulb_5.setVisible(true);
		//SECRET WORD ESTABLISHMENT
		String secretWord = word.getSecretWord();
		System.out.println(secretWord+" "+secretWord.length()+" letters"); //MONITORING
		word = new Word();
		letters = word.wordSplited();

		System.out.println();
		//ACTIVATE KEYBOARD 
		for (Enumeration<AbstractButton> buttons = gamingInterface.keyboard.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(true);
        }


	};
	
			
}


	
	
	


