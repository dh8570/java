package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class testJFrame extends JFrame implements ActionListener {
	JTextField tf = null;
	JTextArea ta = null;
	
	public testJFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
		
		tf = new JTextField(10);
		add(tf);
		
		JButton btn1 = new JButton("추가");
		JButton btn2 = new JButton("불러오기");
		add(btn1);
		add(btn2);
		
		ta = new JTextArea(10, 20);
		add(ta);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		testJFrame frame = new testJFrame("test");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("추가")) {
			String text = tf.getText();
			writeText(text);
		} else if(e.getActionCommand().equals("불러오기")) {
			List<String> textArr = readText();
			
			for(String text:textArr) {
				ta.setText(text);
			}
		}
	}
	
	public void writeText(String text) {
		File f = new File("C:/acorn202206/testFolder/memo.txt");
		FileWriter writer = null;
		BufferedWriter bw = null;
		
		try {
			if(!f.exists()) {
				f.createNewFile();
			}
			writer = new FileWriter(f, true);
			bw = new BufferedWriter(writer);
			bw.append(text);
			bw.flush();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
				if(writer!=null) writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> readText() {
		File f = new File("C:/acorn202206/testFolder/memo.txt");
		FileReader reader = null;
		BufferedReader br = null;
		List<String> textList = new ArrayList<String>();
		
		try {
			reader = new FileReader(f);
			br = new BufferedReader(reader);
			while(br.ready()) {
				String sent = br.readLine();
				textList.add(sent);
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(reader!=null) reader.close();
				if(br!=null) br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return textList;
	}
}
