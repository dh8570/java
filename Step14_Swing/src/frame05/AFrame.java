package frame05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AFrame extends JFrame implements ActionListener{
	public AFrame(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		JButton sendBtn = new JButton("전송");
		add(sendBtn);
		
		sendBtn.addActionListener(this);
		
		JButton deleteBtn = new JButton("삭제");
		add(deleteBtn);
		
		deleteBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		JFrame frame = new AFrame("a1");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "전송") {
			JOptionPane.showMessageDialog(this, "전송합니다.");
		} else {
			JOptionPane.showMessageDialog(this, "삭제합니다.");
		}
	}
}
