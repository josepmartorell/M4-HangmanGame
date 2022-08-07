package HangmanGame.GameFunctionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import HangmanGame.GameInterface.GamingInterface;

public class EventManager implements ActionListener{
	
	private GamingInterface gamingInterface;
    private Lives lives;
    private Word word;
    private String[] letters;
    private ArrayList<String> mask = new ArrayList<String>();
    
    int pole;
    int hits;

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
			try {
				initializeGame();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			//SPECIFIC EVENT SOURCE BUTTON FROM BUTTONGROUP EVENT
		}else if(e.getActionCommand().equals("letter")) {
			JButton letter = (JButton) e.getSource();			
			//MONITORING THE LETTERS OF THE HIDDEN WORD COMPARING THEM WITH THE USER'S ONE	
			for (String string : letters) {
				System.out.println("SECRET: "+string+" USER KEY: "+letter.getText());			
			}			
			try {
				checkKey(letter.getText(), mask);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
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
		
	public void initializeGame() throws FileNotFoundException, IOException{
		//RESTORE GALLOWNS POLE
		gamingInterface.label_gallowns_pole.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/hangman0.jpg"))));
		pole = 0;
		//SHOW BULBS
		gamingInterface.label_bulb_1.setVisible(true);
		gamingInterface.label_bulb_2.setVisible(true);
		gamingInterface.label_bulb_3.setVisible(true);
		gamingInterface.label_bulb_4.setVisible(true);
		gamingInterface.label_bulb_5.setVisible(true);		
		//SECRET WORD INVOCATION
		word = new Word();
		String secretWord = word.getSecretWord();
		letters = word.wordSplited();
		for (String string : letters) {//MONITORING
			System.out.println(string);
		}
		//MASK THE HIDDEN WORD
		mask = new ArrayList<String>();
		for (int i = 0; i < secretWord.length(); i++) {
			mask.add("*");
		}
		//A WAY TO CONVERT AN ARRAY INTO A STRING
		String str = String.valueOf(mask);
		//SAMPLE PER SCREEN
		gamingInterface.textFieldWord.setText(str.replace("[", "").replace("]", "").replace(",",""));
		//RESET FAILURE SCORE
		gamingInterface.lblFailures.setVisible(true);
		gamingInterface.lblFailures.setText("Failures: "+0);
		//ACTIVATE KEYBOARD 
		for (Enumeration<AbstractButton> buttons = gamingInterface.keyboard.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(true);
        }
		//ACTIVATE HINT BUTTON
		gamingInterface.btn_hint.setEnabled(true);


	};
	//CHECK THE TURN AND IF IT CORRECTLY SHOWS THE CORRECT LETTERS AND IF IT FAILS IT CONTINUES BUILDING THE GALLOWNS POLE
	public void checkKey(String letter, ArrayList<String> mask) throws FileNotFoundException, IOException {
		int index = 0;
	    boolean gate = true;
		for (int j = 0; j < letters.length; j++) {
			if(letters[j].equals(letter)) {
				mask.set(index, letter);
				gate = false;
				hits++;
			}
			index++;
		}
		String str = String.valueOf(mask);
		gamingInterface.textFieldWord.setText(str.replace("[", "").replace("]", "").replace(",", ""));
		System.out.println(str);
		if(gate) {
			pole++;
			gamingInterface.label_gallowns_pole.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/hangman"+(pole)+".jpg"))));
			gate = true;
		}
		gameOver(pole);
		
	};
	//GAME OVER 
	public void gameOver(int gallownsPole) throws FileNotFoundException, IOException {
		//UPDATE FAILURES SCORE
		gamingInterface.lblFailures.setText("Failures: "+(pole));
		//IF GALLOWNS POLE TRACKS UP TO THE SIX POLES IT FINISHES THE GAME
		if(gallownsPole == 6) {
			//SET KEYBOARD DEACTIVATED
			for (Enumeration<AbstractButton> buttons = gamingInterface.keyboard.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();
	            button.setEnabled(false);
	        }
			//DEACTIVATE HINT BUTTON
			gamingInterface.btn_hint.setEnabled(false);
			//GAME OVER ALERT
			JOptionPane.showMessageDialog(gamingInterface,"YOU'VE LOST DE GAME :( "+"\nFailed: "+pole, "GAME OVER", JOptionPane.YES_NO_OPTION);
			//CLEAN WORD DISPLAYER
			gamingInterface.textFieldWord.setText("");

		}else if(hits == letters.length){
			JOptionPane.showMessageDialog(gamingInterface,"YOU'VE WIN DE GAME :) "+"\nFailed: "+pole, "GAME OVER", JOptionPane.YES_NO_OPTION);
		}
	}
		
};
	
			



	
	
	


