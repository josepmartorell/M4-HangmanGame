package HangmanGame.GameInterface;

import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import HangmanGame.GameFunctionality.EventManager;

public class GamingInterface extends JFrame {

	private JPanel contentPane;
	private EventManager eventManager = new EventManager(this);
	
	public JLabel label_gallowns_pole;
	public JTextField textFieldWord;
	public JLabel label_bulb_1;
	public JLabel label_bulb_2;
	public JLabel label_bulb_3;
	public JLabel label_bulb_4;
	public JLabel label_bulb_5;
	public JLabel lblFailures;
	public ButtonGroup keyboard;

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public GamingInterface() throws FileNotFoundException, IOException {
		setTitle("HANGMAN GAME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 637);
		
		// MENUBAR IMPLEMENTATION
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem menuItem_About = new JMenuItem("About");
		menuItem_About.addActionListener(eventManager);
		menuItem_About.setActionCommand("About");
		menu.add(menuItem_About);
		
		JMenuItem menuItem_Exit = new JMenuItem("Exit");
		menuItem_Exit.addActionListener(eventManager);
		menuItem_Exit.setActionCommand("Exit");
		menu.add(menuItem_Exit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(28, 20, 307, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btn_start = new JButton("START GAME");
		btn_start.setBounds(10, 10, 287, 37);
		btn_start.addActionListener(eventManager);
		btn_start.setActionCommand("START GAME");
		panel.add(btn_start);
		
		JButton btn_hint = new JButton("HINT");
		btn_hint.setBounds(10, 68, 287, 35);
		btn_hint.addActionListener(eventManager);
		btn_hint.setActionCommand("HINT");
		panel.add(btn_hint);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(28, 154, 307, 113);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 57, 287, 46);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		// MASKED WORD MONITORING LABEL 
		textFieldWord = new JTextField();
		textFieldWord.setForeground(Color.BLACK);
		textFieldWord.setBackground(Color.DARK_GRAY);
		textFieldWord.setEditable(false);
		textFieldWord.setBounds(10, 10, 267, 26);
		panel_2.add(textFieldWord);
		textFieldWord.setColumns(10);
	
		label_bulb_1 = new JLabel("");
		label_bulb_1.setBounds(10, 17, 32, 30);
		label_bulb_1.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/bulb.png"))));
		label_bulb_1.setVisible(false);
		panel_1.add(label_bulb_1);
		
		label_bulb_2 = new JLabel("");
		label_bulb_2.setBounds(52, 17, 32, 30);
		label_bulb_2.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/bulb.png"))));
		label_bulb_2.setVisible(false);
		panel_1.add(label_bulb_2);
		
		label_bulb_3 = new JLabel("");
		label_bulb_3.setBounds(94, 17, 32, 30);
		label_bulb_3.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/bulb.png"))));
		label_bulb_3.setVisible(false);
		panel_1.add(label_bulb_3);
		
		label_bulb_4 = new JLabel("");
		label_bulb_4.setBounds(136, 17, 32, 30);
		label_bulb_4.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/bulb.png"))));
		label_bulb_4.setVisible(false);
		panel_1.add(label_bulb_4);
		
		label_bulb_5 = new JLabel("");
		label_bulb_5.setBounds(178, 17, 32, 30);
		label_bulb_5.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/bulb.png"))));
		label_bulb_5.setVisible(false);
		panel_1.add(label_bulb_5);
		
		// FAILURES MONITORING LABEL
		lblFailures = new JLabel("Failures:");
		lblFailures.setFont(new Font("Comic Sans MS", Font.BOLD, 10));
		lblFailures.setForeground(Color.DARK_GRAY);
		lblFailures.setBounds(220, 34, 77, 13);
		panel_1.add(lblFailures);
		
		// KEYBOARD ELEMENTS GROUP
		keyboard = new ButtonGroup();
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(28, 291, 307, 249);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btn_A = new JButton("A");
		btn_A.setBounds(10, 10, 50, 21);
		btn_A.addActionListener(eventManager);
		btn_A.setActionCommand("letter");
		panel_3.add(btn_A);
		keyboard.add(btn_A);
		
		JButton btn_B = new JButton("B");
		btn_B.setBounds(70, 10, 50, 21);
		btn_B.addActionListener(eventManager);
		btn_B.setActionCommand("letter");
		panel_3.add(btn_B);
		keyboard.add(btn_B);
		
		JButton btn_C = new JButton("C");
		btn_C.setBounds(127, 10, 50, 21);
		btn_C.addActionListener(eventManager);
		btn_C.setActionCommand("letter");
		panel_3.add(btn_C);
		keyboard.add(btn_C);
		
		JButton btn_D = new JButton("D");
		btn_D.setBounds(187, 10, 50, 21);
		btn_D.addActionListener(eventManager);
		btn_D.setActionCommand("letter");
		panel_3.add(btn_D);
		keyboard.add(btn_D);
		
		JButton btn_E = new JButton("E");
		btn_E.setBounds(247, 10, 50, 21);
		btn_E.addActionListener(eventManager);
		btn_E.setActionCommand("letter");
		panel_3.add(btn_E);
		keyboard.add(btn_E);
		
		JButton btn_F = new JButton("F");
		btn_F.setBounds(10, 41, 50, 21);
		btn_F.addActionListener(eventManager);
		btn_F.setActionCommand("letter");
		panel_3.add(btn_F);
		keyboard.add(btn_F);
		
		JButton btn_G = new JButton("G");
		btn_G.setBounds(70, 41, 50, 21);
		btn_G.addActionListener(eventManager);
		btn_G.setActionCommand("letter");
		panel_3.add(btn_G);
		keyboard.add(btn_G);
		
		JButton btn_H = new JButton("H");
		btn_H.setBounds(127, 41, 50, 21);
		btn_H.addActionListener(eventManager);
		btn_H.setActionCommand("letter");
		panel_3.add(btn_H);
		keyboard.add(btn_H);
		
		JButton btn_I = new JButton("I");
		btn_I.setBounds(187, 41, 50, 21);
		btn_I.addActionListener(eventManager);
		btn_I.setActionCommand("letter");
		panel_3.add(btn_I);
		keyboard.add(btn_I);
		
		JButton btn_J = new JButton("J");
		btn_J.setBounds(247, 41, 50, 21);
		btn_J.addActionListener(eventManager);
		btn_J.setActionCommand("letter");
		panel_3.add(btn_J);
		keyboard.add(btn_J);
		
		JButton btn_K = new JButton("K");
		btn_K.setBounds(10, 72, 50, 21);
		btn_K.addActionListener(eventManager);
		btn_K.setActionCommand("letter");
		panel_3.add(btn_K);
		keyboard.add(btn_K);
		
		JButton btn_L = new JButton("L");
		btn_L.setBounds(70, 72, 50, 21);
		btn_L.addActionListener(eventManager);
		btn_L.setActionCommand("letter");
		panel_3.add(btn_L);
		keyboard.add(btn_L);
			
		JButton btn_M = new JButton("M");
		btn_M.setBounds(127, 72, 50, 21);
		btn_M.addActionListener(eventManager);
		btn_M.setActionCommand("letter");
		panel_3.add(btn_M);
		keyboard.add(btn_M);
		
		JButton btn_N = new JButton("N");
		btn_N.setBounds(187, 72, 50, 21);
		btn_N.addActionListener(eventManager);
		btn_N.setActionCommand("letter");
		panel_3.add(btn_N);
		keyboard.add(btn_N);
		
		JButton btn_Ñ = new JButton("Ñ");
		btn_Ñ.setBounds(247, 72, 50, 21);
		btn_Ñ.addActionListener(eventManager);
		btn_Ñ.setActionCommand("letter");
		panel_3.add(btn_Ñ);
		keyboard.add(btn_Ñ);
		
		JButton btn_O = new JButton("O");
		btn_O.setBounds(10, 103, 50, 21);
		btn_O.addActionListener(eventManager);
		btn_O.setActionCommand("letter");
		panel_3.add(btn_O);
		keyboard.add(btn_O);
		
		JButton btn_P = new JButton("P");
		btn_P.setBounds(70, 103, 47, 21);
		btn_P.addActionListener(eventManager);
		btn_P.setActionCommand("letter");
		panel_3.add(btn_P);
		keyboard.add(btn_P);
		
		JButton btn_Q = new JButton("Q");
		btn_Q.setBounds(127, 103, 50, 21);
		btn_Q.addActionListener(eventManager);
		btn_Q.setActionCommand("letter");
		panel_3.add(btn_Q);
		keyboard.add(btn_Q);
		
		JButton btn_R = new JButton("R");
		btn_R.setBounds(187, 103, 50, 21);
		btn_R.addActionListener(eventManager);
		btn_R.setActionCommand("letter");
		panel_3.add(btn_R);
		keyboard.add(btn_R);
		
		JButton btn_S = new JButton("S");
		btn_S.setBounds(247, 103, 50, 21);
		btn_S.addActionListener(eventManager);
		btn_S.setActionCommand("letter");
		panel_3.add(btn_S);
		keyboard.add(btn_S);
		
		JButton btn_T = new JButton("T");
		btn_T.setBounds(10, 134, 50, 21);
		btn_T.addActionListener(eventManager);
		btn_T.setActionCommand("letter");
		panel_3.add(btn_T);
		keyboard.add(btn_T);
		
		JButton btn_U = new JButton("U");
		btn_U.setBounds(70, 134, 49, 21);
		btn_U.addActionListener(eventManager);
		btn_U.setActionCommand("letter");
		panel_3.add(btn_U);
		keyboard.add(btn_U);
		
		JButton btn_V = new JButton("V");
		btn_V.setBounds(127, 134, 50, 21);
		btn_V.addActionListener(eventManager);
		btn_V.setActionCommand("letter");
		panel_3.add(btn_V);
		keyboard.add(btn_V);
		
		JButton btn_W = new JButton("W");
		btn_W.setBounds(187, 134, 50, 21);
		btn_W.addActionListener(eventManager);
		btn_W.setActionCommand("letter");
		panel_3.add(btn_W);
		keyboard.add(btn_W);
		
		JButton btn_X = new JButton("X");
		btn_X.setBounds(247, 134, 50, 21);
		btn_X.addActionListener(eventManager);
		btn_X.setActionCommand("letter");
		panel_3.add(btn_X);
		keyboard.add(btn_X);
		
		JButton btn_Y = new JButton("Y");
		btn_Y.setBounds(12, 165, 48, 21);
		btn_Y.addActionListener(eventManager);
		btn_Y.setActionCommand("letter");
		panel_3.add(btn_Y);
		keyboard.add(btn_Y);
		
		JButton btn_Z = new JButton("Z");
		btn_Z.setBounds(70, 165, 50, 21);
		btn_Z.addActionListener(eventManager);
		btn_Z.setActionCommand("letter");
		panel_3.add(btn_Z);
		keyboard.add(btn_Z);
		
		//SET KEYBOARD DEACTIVATED
		for (Enumeration<AbstractButton> buttons = keyboard.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(false);
        }
		
		// GALLOWNS POLE SCREEN LABEL
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_4.setBounds(345, 20, 497, 520);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		label_gallowns_pole = new JLabel("gallowns pole");
		label_gallowns_pole.setBounds(10, 10, 477, 500);
		label_gallowns_pole.setIcon(new ImageIcon(ImageIO.read(new FileInputStream("resources/hangman1.jpg"))));
		panel_4.add(label_gallowns_pole);
	}
}
