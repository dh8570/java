package frame08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcFrame extends JFrame implements ActionListener {
	JTextField tf_num1;
	JTextField tf_num2;
	JLabel label_result;
	
	public CalcFrame() {
		//프레임의 레이아웃 법칙 설정하기 
		setLayout(new BorderLayout());
		
		//JPanel
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.YELLOW);
		//Panel 을 북쪽에 배치하기 
		add(topPanel, BorderLayout.NORTH);
		
		//JTextField 객체를 만들에서 JPanel 에 추가하기 
		tf_num1=new JTextField(10);
		topPanel.add(tf_num1);
		//기능 버튼 객체를 만들어서 JPanel 에 추가하기
		JButton plusBtn=new JButton("+");
		JButton minusBtn=new JButton("-");
		JButton multiBtn=new JButton("*");
		JButton divideBtn=new JButton("/");
		topPanel.add(plusBtn);
		topPanel.add(minusBtn);
		topPanel.add(multiBtn);
		topPanel.add(divideBtn);
		//두번째 JTextField  만들어서 페널에 추가 하기
		tf_num2=new JTextField(10);
		topPanel.add(tf_num2);
		//JLabel
		JLabel label1=new JLabel("=");
		label_result=new JLabel("0");
		//페널에 레이블 추가하기
		topPanel.add(label1);
		topPanel.add(label_result);
		
		plusBtn.addActionListener(this);
		minusBtn.addActionListener(this);
		multiBtn.addActionListener(this);
		divideBtn.addActionListener(this);
	}
	
	public static void main(String[] args) {
		CalcFrame frame=new CalcFrame();
		//프레임의 제목 설정
		frame.setTitle("계산기");
		//프레임을 닫으면 자동으로 프로세스가 종료 되도록 한다.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// 동작 commend 문자열 저장
			Object comm = e.getActionCommand();
			
			// 입력창 문자열 get
			// Double 타입으로 변환
			Double num1 = Double.parseDouble(tf_num1.getText());
			Double num2 = Double.parseDouble(tf_num2.getText());
			Double num = 0.0;
			
			if(comm.equals("+")) {
				num = (num1+num2);
			} else if(comm.equals("-")) {
				num = (num1-num2);
			} else if(comm.equals("*")) {
				num = (num1*num2);
			} else {
				num = (num1/num2);
			}
			String result = cutNum(2, num);
			label_result.setText(result);
		} catch(NumberFormatException except) {
			System.out.println("숫자형식으로 입력해 주세요");
		} catch(ArithmeticException except) {
			System.out.println("0으로 나눌 수 없어요");
		}
	}
	
	public String cutNum(int cutSize, Double num) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(cutSize);
		nf.setGroupingUsed(false);
		
		return nf.format(num);
	}
}
