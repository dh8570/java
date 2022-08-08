package test.main;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass03 {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(200, 250);
		f.setTitle("aa");
		f.setLayout(new BorderLayout());
		
		JButton btn = new JButton();
		btn.setText("btn1");
		btn.setVisible(true);
		f.add(btn, BorderLayout.SOUTH);
		f.setVisible(true);
	}
}
