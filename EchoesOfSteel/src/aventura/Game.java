package aventura;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Game {
	
	JFrame ventana;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, chapter1NamePanel, chapter1TitlePanel, continueButtonPanel;
	JLabel titleLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelText, chapter1TitleLabel, chapter1DescLabel;
	JButton startButton, choice1, choice2, choice3, choice4, continueButton;
	JTextArea mainTextArea;
	
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font titleButtonFont = new Font("Times New Roman", Font.BOLD, 25);
	Font chapterDesc = new Font("Times New Roman", Font.BOLD, 40);
	Font normalFont = new Font("Times New Roman", Font.BOLD, 20);
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	ChapterHandler chapterHandler = new ChapterHandler();
	
	Border line = BorderFactory.createLineBorder(Color.RED, 1);
	Border margin = BorderFactory.createEmptyBorder(10, 25, 10, 25);
	
	int playerHP;
	String weapon, position, chapter;
	
	public static void main(String[] args) {
		
		new Game();

	}
	
	public Game() {
		
		ventana = new JFrame();
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setBackground(Color.black);
		ventana.setLayout(null);
		ventana.setResizable(false);
		con = ventana.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleLabel = new JLabel("Echoes Of Steel");
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 350, 200, 100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.red);
		startButton.setBorder(BorderFactory.createCompoundBorder(line, margin));
		startButton.setFont(titleButtonFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
		
		ventana.setVisible(true);
		
	}
	
	public void chapter1() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		chapter = "chapter1";
		
		chapter1NamePanel = new JPanel();
		chapter1NamePanel.setBounds(100, 100, 600, 100);
		chapter1NamePanel.setBackground(Color.black);
		chapter1TitleLabel = new JLabel("Chapter 1:");
		chapter1TitleLabel.setForeground(Color.red);
		chapter1TitleLabel.setFont(titleFont);
		
		chapter1TitlePanel = new JPanel();
		chapter1TitlePanel.setBounds(100, 250, 600, 50);
		chapter1TitlePanel.setBackground(Color.black);
		chapter1DescLabel = new JLabel("The Awakening");
		chapter1DescLabel.setForeground(Color.red);
		chapter1DescLabel.setFont(chapterDesc);
		
		chapter1NamePanel.add(chapter1TitleLabel);
		chapter1TitlePanel.add(chapter1DescLabel);
		
		continueButtonPanel = new JPanel();
		continueButtonPanel.setBounds(300, 350, 200, 100);
		continueButtonPanel.setBackground(Color.black);
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.black);
		continueButton.setForeground(Color.red);
		continueButton.setBorder(BorderFactory.createCompoundBorder(line, margin));
		continueButton.setFont(titleButtonFont);
		continueButton.setFocusPainted(false);
		continueButton.addActionListener(chapterHandler);
		
		continueButtonPanel.add(continueButton);
		
		con.add(chapter1NamePanel);
		con.add(chapter1TitlePanel);
		con.add(continueButtonPanel);
		
	}
	
	public void createGameScreen() {
		
		chapter1NamePanel.setVisible(false);
		chapter1TitlePanel.setVisible(false);
		continueButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(200, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		mainTextArea = new JTextArea("You wake up on the cold floor of a ruined room.\nYou don't remember your name.\n\nNext to you is a rusty sword.\nWhen you touch it… you hear something."
				+ "\n\n\"...I can still cut...\"\nA shiver runs through your body.");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.red);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setEditable(false);
		mainTextArea.setFocusable(false);
		mainTextArea.setHighlighter(null);
		
		mainTextPanel.add(mainTextArea);
		
		con.add(mainTextPanel);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(150, 370, 500, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		
		choice1 = new JButton("Open an old wooden door");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.red);
		choice1.setFont(normalFont);
		choice1.setBorder(BorderFactory.createCompoundBorder(line, margin));
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		
		choice2 = new JButton("Go down a descending corridor");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.red);
		choice2.setFont(normalFont);
		choice2.setBorder(BorderFactory.createCompoundBorder(line, margin));
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton("-----------------");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.red);
		choice3.setFont(normalFont);
		choice3.setBorder(BorderFactory.createCompoundBorder(line, margin));
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		
		choice4 = new JButton("-----------------");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.red);
		choice4.setFont(normalFont);
		choice4.setBorder(BorderFactory.createCompoundBorder(line, margin));
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);
		
		con.add(choiceButtonPanel);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.red);
		playerPanel.add(hpLabel);
		
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.red);
		playerPanel.add(hpLabelNumber);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.red);
		playerPanel.add(weaponLabel);
		
		weaponLabelText = new JLabel();
		weaponLabelText.setFont(normalFont);
		weaponLabelText.setForeground(Color.red);
		playerPanel.add(weaponLabelText);
		
		con.add(playerPanel);
		
		playerSetup();
		
	}
	
	public void playerSetup() {
		
		playerHP = 20;
		weapon = "Rusty Sword";
		
		weaponLabelText.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		
		ruinedRoom();
		
	}
	
	public void ruinedRoom() {
		
		position = "ruinedRoom";
		
		mainTextArea.setText("You wake up on the cold floor of a ruined room.\nYou don't remember your name.\n\nNext to you is a rusty sword.\nWhen you touch it… you hear something."
				+ "\n\n\"...I can still cut...\"\nA shiver runs through your body.");
		
		choice1.setText("Open an old wooden door");
		choice2.setText("Go down a descending corridor");
		choice3.setText("-----------------");
		choice4.setText("-----------------");
		
	}
	
	public void woodenDoor() {
		
		position = "woodenDoor";
		
		mainTextPanel.setBounds(200, 150, 600, 150);
		mainTextArea.setText("You push the door slowly.\n\nInside there is an enemy: A wounded looter.\n\nHe sees you and attacks.");
		choice1.setText("Attack");
		choice2.setText("Defend");
		choice3.setText("-----------------");
		choice4.setText("-----------------");
		
	}
	
	public void corridor() {
		
		position = "corridor";
		
		mainTextPanel.setBounds(290, 150, 600, 150);
		mainTextArea.setText("You go down carefully.\n\nIt's dark... too dark.\n\nSomething moves.");
		choice1.setText(">");
		choice2.setText("-----------------");
		choice3.setText("-----------------");
		choice4.setText("-----------------");
		
	}
	
	public class TitleScreenHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			chapter1();
		}
		
	}
	
	public class ChapterHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
		
	}
	
	public class ChoiceHandler implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			String choice = event.getActionCommand();
			
			switch(position) {
				case "ruinedRoom":
					switch(choice) {
						case "c1": woodenDoor(); break;
						case "c2": corridor(); break;
					}
					break;
				case "woodenDoor":
					switch(choice) {
						case "c1": break;
						case "c2": break;
					}
					break;
				case "corridor":
					switch(choice) {
						case "c1": break;
					}
					break;
			}
			
		}
		
	}
}
