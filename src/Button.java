import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class Button extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Icon picNorm;
	private Icon picHover;
	private Icon signOne;
	private Icon signTwo;
	private int row;
	private int col;
	
	public Button() {
		super("");
		picNorm=new ImageIcon(getClass().getResource("Normal.png"));
		picHover=new ImageIcon(getClass().getResource("Hover.png"));
		signOne=new ImageIcon(getClass().getResource("SignX.png"));
		signTwo=new ImageIcon(getClass().getResource("SignO.png"));
		this.setIcon(picNorm);
		this.setRolloverIcon(picHover);
	}
	
	public void setSigned(int sign) {
		if(sign==1)
			this.setIcon(signOne);
		else
			this.setIcon(signTwo);
		this.setRolloverEnabled(false);
	}
	
	public void unsign() {
		this.setRolloverEnabled(true);
		this.setIcon(picNorm);
	}

	public void setRowCol(int r, int c) {
		row=r;
		col=c;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}

	public Dimension getPreferredSize() {
		return new Dimension(79,79);
	}
	
	public Dimension getMinimumSize() {
		return new Dimension(79,79);
	}
	
	public Dimension getMaximumSize() {
		return new Dimension(79,79);
	}

}
