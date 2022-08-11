package frame03;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AFrame extends JFrame{
	public AFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		BorderLayout layout = new BorderLayout();
		
		setLayout(layout);
		
		JButton btn1 = new JButton("btn1");
		add(btn1, BorderLayout.NORTH);
		
		JButton btn2 = new JButton("btn2");
		add(btn2, BorderLayout.WEST);
		
		JButton btn3 = new JButton("btn3");
		add(btn3, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AFrame("a1");
	}
}
