
public class Player {
	
	private String name="";
	private char sign;
	private int score;
	
	public Player() {			//For the CPU
		name="CPU";
		sign='O';
		score=0;
	}
	
	public Player(char sgn) {			//For the first and second player
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
