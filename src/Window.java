import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button [][] singleB;
	private Field gameField;
	private JLabel score;
	
	Window(String name) {
		super(name);
		JPanel fieldPanel=new JPanel(new GridBagLayout());
		fieldPanel.setBackground(new Color(180,240,255));
		
		GridBagConstraints cons=new GridBagConstraints();

		singleB=new Button[3][3];
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
		{
				singleB[i][j]=new Button();
				singleB[i][j].setRowCol(i, j);
				cons.gridx=i;
				cons.gridy=j;
				handleClicks(singleB[i][j]);
				fieldPanel.add(singleB[i][j], cons);
			}
		
		add(fieldPanel, BorderLayout.NORTH);
		
		gameField=new Field();
		
		JPanel statPanel=new JPanel(new GridBagLayout());
		statPanel.setBackground(Color.YELLOW);
		
		score=new JLabel();
		String str=gameField.getFirstPlayer().getName() + "   -   " + gameField.getFirstPlayer().getScore() + ':' + gameField.getSecondPlayer().getScore() + "   -   " + gameField.getSecondPlayer().getName();
		score.setText(str);
		score.setFont(new Font("Serif", Font.PLAIN, 25));
		score.setForeground(new Color(120,45,45));
		
		statPanel.add(score, cons);
		add(statPanel, BorderLayout.CENTER);
	}
	
	//Everything that should be done when you make a turn
	private void handleClicks(final Button but) {
		but.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						if(gameField.getElem(but.getRow(), but.getCol())!='?') return;	//if the button is not pressed for the first time do not do anything
						but.setSigned(gameField.getTurn());
						gameField.setElemSign(but.getRow(), but.getCol());
						gameField.changeTurn();
						executeTurn();
					}
				}
		);
	}
	
	//MAIN GAME LOGIC
	private void executeTurn() {
		
		if(gameField.getGameType()==1 && gameField.getTurn()==2 && gameField.isFull()==false) {
			 cpuTurn();
			 if(gameField.hasWon()=='?')
				 gameField.changeTurn();
		 }
		
		char result=gameField.hasWon();
		if(result=='?') {
			if(gameField.isFull()) {
				JOptionPane.showMessageDialog(null, "Draw!");
				newRound();
			}
			return;
		}
		else {
			gameField.winActions(result);
			if((gameField.getGameType()==1 && result=='X') || gameField.getGameType()!=1)
				gameField.changeTurn();
			newRound();
		}
	}
	
	/* This one's pretty dumb, I know. I just didin't have the time
	to make up a smarter CPU */
	private void cpuTurn() {
		boolean cycle=true;
		Random ran=new Random();
		do {
			int i=ran.nextInt(3);
			int j=ran.nextInt(3);
			if(gameField.getElem(i, j)=='?') {
				gameField.setElemSign(i, j);
				singleB[i][j].setSigned(2);
				cycle=false;
			}
		} while(cycle);
	}
	
	private void newRound() {
		gameField.clear();
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				singleB[i][j].unsign();
		
		setStatistics();
		
		if(gameField.getTurn()==2 && gameField.getGameType()==1) {
			cpuTurn();
			gameField.changeTurn();
		}
	}
	
	private void setStatistics() {
		String str=gameField.getFirstPlayer().getName() + "   -   " + gameField.getFirstPlayer().getScore() + ':' + gameField.getSecondPlayer().getScore() + "   -   " + gameField.getSecondPlayer().getName();
		score.setText(str);
	}

}
