
public class Player {
	
	private String name="";
	private char sign;
	private int score;
	
	//For the CPU
	public Player() {
		name="CPU";
		sign='O';
		score=0;
	}
	
	//For the first and second player
	public Player(char sgn) {
		sign=(sgn=='X' || sgn=='O') ? sgn : '?';
		score=0;
	}
	
	public void setName(String n) {
		name=n;
	}
	
	public String getName() {
		return name;
	}
	
	public void incrementScore() {
		score++;
	}
	
	public int getScore() {
		return score;
	}
	
	public char getSign() {
		return sign;
	}
	
	public void reset() {
		score=0;
	}

}
