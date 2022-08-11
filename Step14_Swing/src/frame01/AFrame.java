package frame01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AFrame extends JFrame {
	public AFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		
		setLayout(layout);
		
		JButton btn1 = new JButton("btn1");
		add(btn1);
		
		JButton btn2 = new JButton("btn2");
		add(btn2);
		
		JButton btn3 = new JButton("btn3");
		add(btn3);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AFrame("a1");
	}
}
