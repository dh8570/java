package frame07;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AFrame extends JFrame {
	public AFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		JTextField inputMsg1 = new JTextField(10);
		JTextField inputMsg2 = new JTextField(10);
		JButton btn1 = new JButton("btn1");
		
		add(inputMsg1);
		add(btn1);
		add(inputMsg2);
		
		btn1.addActionListener((e) -> {
			String msg1 = inputMsg1.getText();
			inputMsg2.setText(msg1);
		});
	}
	
	public static void main(String[] args) {
		JFrame frame = new AFrame("frame1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
}
