package frame04;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AFrame extends JFrame{
	public AFrame(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("btn1");
		add(btn1);
		
		btn1.addActionListener((e) -> {
			JOptionPane.showMessageDialog(AFrame.this, "a1");
		});
		
		JButton btn2 = new JButton("btn2");
		add(btn2);
		
		btn2.addActionListener((e) -> {
			JOptionPane.showMessageDialog(AFrame.this, "a2");
		});
	}
	
	public static void main(String[] args) {
		JFrame frame = new AFrame("a1");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
