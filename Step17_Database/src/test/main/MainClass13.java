package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import test.dao.MemberDao;
import test.pack.MemberDto;

public class MainClass13 extends JFrame implements ActionListener {
	JTextField num = null;
	JTextField name = null;
	JTextField addr = null;
	JTextArea ja = null;
	
	public MainClass13(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		JTextPane numTitle = new JTextPane();
		JTextPane nameTitle = new JTextPane();
		JTextPane addrTitle = new JTextPane();
		num = new JTextField(10);
		name = new JTextField(10);
		addr = new JTextField(10);
		
		JButton allSelect = new JButton("전체 조회");
		JButton select = new JButton("조회");
		JButton insert = new JButton("추가");
		JButton update = new JButton("수정");
		JButton delete = new JButton("삭제");
		
		ja = new JTextArea(40, 40);
		ja.setEnabled(false);
		
		add(numTitle);
		add(nameTitle);
		add(addrTitle);
		add(num);
		add(name);
		add(addr);
		
		add(allSelect);
		add(select);
		add(insert);
		add(update);
		add(delete);
		
		add(ja);
		
		allSelect.addActionListener(this);
		select.addActionListener(this);
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
	}
	
	public static void main(String[] args) {
		MainClass13 frame = new MainClass13("DB Manager");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionComm = e.getActionCommand();
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();
		MemberDto mem = new MemberDto();
		boolean isSuccess = true;
		
		if(actionComm.equals("전체 조회")) {
			List<MemberDto> memList = new ArrayList<>();
			memList = dao.getAllData();
			
			String text = "";
			
			for(int i=0; i<memList.size(); i++) {
				mem = memList.get(i);
				text += "회원번호 : "+mem.getNum()+"\t회원명 : "+mem.getName()+"\t주소 : "+mem.getAddr()+"\r\n";
			}
			
			ja.setText("전체 회원 정보\r\n"
					+ "------------------------------------------------------------------------------------------------\r\n"
					+ text);
		} else if(actionComm.equals("조회")) {
			Integer paramNum = 0;
			try {
				paramNum = Integer.parseInt(num.getText());
			} catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "회원번호를 입력하세요!", "Did not add UserNum", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				mem = dao.getData(paramNum);
				Integer userNum = mem.getNum();
				ja.setText("최신 회원 정보\r\n"
						+ "------------------------------------------------------------------------------------------------\r\n"
						+ "회원번호 : "+userNum.toString()+"\r\n"
						+ "회원명 : "+mem.getName()+"\r\n"
						+ "주소 : "+mem.getAddr());
			} catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "입력한 회원정보가 없습니다.", "Do not have UserData", JOptionPane.WARNING_MESSAGE);
			}
		} else if(actionComm.equals("추가")) {
			if(name.getText().equals("") || addr.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "추가할 회원정보를 입력하세요!", "Did not add UserData", JOptionPane.ERROR_MESSAGE);
			}
			dto.setName(name.getText());
			dto.setAddr(addr.getText());
			isSuccess = dao.insert(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "회원정보가 추가되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
				mem = dao.getData();
				Integer userNum = mem.getNum();
				ja.setText("추가된 회원 정보\r\n"
						+ "------------------------------------------------------------------------------------------------\r\n"
						+ "회원번호 : "+userNum.toString()+"\r\n"
						+ "회원명 : "+mem.getName()+"\r\n"
						+ "주소 : "+mem.getAddr());
			} else {
				JOptionPane.showMessageDialog(null, "추가 실패!", "Fail to add User", JOptionPane.ERROR_MESSAGE);
			}
		} else if(actionComm.equals("수정")) {
			String test = null;
			try{
				test = num.getText();
				dto.setNum(Integer.parseInt(test));
			} catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "회원번호를 입력하세요!", "Did not add UserNum", JOptionPane.ERROR_MESSAGE);
			}
			if((name.getText().equals("")) || (addr.getText().equals(""))) {
				JOptionPane.showMessageDialog(null, "수정할 회원정보를 입력하세요!", "Did not add UserData", JOptionPane.ERROR_MESSAGE);
			}
			dto.setName(name.getText());
			dto.setAddr(addr.getText());
			isSuccess = dao.update(dto);
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "회원정보가 수정되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
				mem = dao.getData(dto.getNum());
				Integer userNum = mem.getNum();
				ja.setText("수정된 회원 정보\r\n"
						+ "------------------------------------------------------------------------------------------------\r\n"
						+ "회원번호 : "+userNum.toString()+"\r\n"
						+ "회원명 : "+mem.getName()+"\r\n"
						+ "주소 : "+mem.getAddr());
			} else {
				JOptionPane.showMessageDialog(null, "수정 실패!", "Fail to update User", JOptionPane.ERROR_MESSAGE);
			}
		} else if(actionComm.equals("삭제")) {
			Integer deleteNum = null;
			try {
				deleteNum = Integer.parseInt(num.getText());
			} catch(Exception e1) {
				JOptionPane.showMessageDialog(null, "회원번호를 입력하세요!", "Did not add UserNum", JOptionPane.ERROR_MESSAGE);
			}
			mem = dao.getData(deleteNum);
			isSuccess = dao.delete(deleteNum);
			if(isSuccess) {
				JOptionPane.showMessageDialog(null, "회원정보가 삭제되었습니다.", "Success", JOptionPane.INFORMATION_MESSAGE);
				ja.setText("삭제된 회원 정보\r\n"
						+ "------------------------------------------------------------------------------------------------\r\n"
						+ "회원번호 : "+deleteNum.toString()+"\r\n"
						+ "회원명 : "+mem.getName()+"\r\n"
						+ "주소 : "+mem.getAddr());
			} else {
				JOptionPane.showMessageDialog(null, "삭제 실패!", "Fail to delete User", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
