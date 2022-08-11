package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class TestFrame extends JFrame implements ActionListener {
	JTextField input1;
	
	public TestFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		input1 = new JTextField(10);
		add(input1);
		
		JButton btn1 = new JButton("print");
		add(btn1);
		
		btn1.addActionListener(this);
	}
	
	public static void main(String[] args) {
		JFrame frame = new TestFrame("testFrame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread(() -> {
			String a = input1.getText();
			Integer num = Integer.parseInt(a);
			int i = 1;
			
			while(i != 11) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println(num+"x"+i+"="+(num*i));
				i++;
			}
		}).start();
	}
}
