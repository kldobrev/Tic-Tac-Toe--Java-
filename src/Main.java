import javax.swing.JFrame;

public class Main {
	
	public static void main(String [] args) {
		
		Window game=new Window("Tic-Tac-Toe");
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setSize(450, 350);
		game.setResizable(false);
		game.setVisible(true);
	}
}
