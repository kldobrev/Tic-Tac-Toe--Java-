import javax.swing.JOptionPane;


public class Field {
	
	private char [][] data;			//data container : X, O or ?
	Player fst;
	Player snd;
	private byte turn;
	private int gameType;
	
	public Field() {
		data=new char[3][3];
		clear();
		turn=1;
		gameType=JOptionPane.showConfirmDialog(null, "Do you want this to be a two player game?");
		
		if(gameType==2)
			System.exit(0);
		else {
			fst=new Player('X');
			String str=null;
			do {
			str=JOptionPane.showInputDialog(null, "Enter a name for player 1:");
			if(str==null)
				System.exit(0);
			if(str.isEmpty())
				JOptionPane.showMessageDialog(null, "You must enter a valid name!");
			} while(str.isEmpty());
			
			fst.setName(str);
		}
		
		if(gameType==0)
			addSndPlayer();
		else
			snd=new Player();
	}
	
	public void addSndPlayer() {			//Sets the settings for the second player
		snd=new Player('O');
		String str;
		do {
			str=JOptionPane.showInputDialog(null, "Enter a name for player 2:");
			if(str==null)
				System.exit(0);
			if(str.isEmpty())
				JOptionPane.showMessageDialog(null, "You must enter a valid name!");
			else if(str.trim().equals(fst.getName().trim())) {
				JOptionPane.showMessageDialog(null, "This name has already been taken!");
				str="";
			}
		} while(str.isEmpty());
		snd.setName(str);
	}
	
	//Clears the game field for a new game
	public void clear() {
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				data[i][j]='?';
	}
	
	public char hasWon() {
		for(int i=0; i<3; i++)
			//rows
			if(data[i][0]==data[i][1] && data[i][1]==data[i][2] && data[i][0]!='?') return data[i][0];
		for(int j=0; j<3; j++)
			//columns
			if(data[0][j]==data[1][j] && data[1][j]==data[2][j] && data[0][j]!='?') return data[0][j];
		//Straight diagonal
		if(data[0][0]==data[1][1] && data[1][1]==data[2][2] &&data[0][0]!='?') return data[0][0];
		//reverse diagonal
		if(data[0][2]==data[1][1] && data[1][1]==data[2][0] && data[0][2]!='?') return data[0][2];
		
		//No winner
		return '?';
	}
	
	//checks if the field is full
	public boolean isFull() {
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(data[i][j]=='?')
					return false;
		
		return true;
	}
	
	public void changeTurn() {
		if(turn==1)
			turn++;
		else
			turn--;
	}
	
	public byte getTurn() {
		return turn;
	}
	
	int getGameType() {
		return gameType;
	}
	
	public void setElemSign(int i, int j) {
		if(turn==1)
			data[i][j]=fst.getSign();
		else
			data[i][j]=snd.getSign();
	}
	
	public char getElem(int i, int j) {
		return data[i][j];
	}
	
	public Player getFirstPlayer() {
		return fst;
	}
	
	public Player getSecondPlayer() {
		return snd;
	}
	
	public void winActions(char ch) {
		String str;
		if(ch=='X') {
			str=fst.getName() + " has won the game!";
			fst.incrementScore();
		}
		else {
			str=snd.getName() + " has won the game!";
			snd.incrementScore();
		}
			
		JOptionPane.showMessageDialog(null, str);
	}

}
