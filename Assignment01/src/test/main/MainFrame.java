package test.main;

import java.awt.BorderLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.WorkDao;
import test.dto.WorkDto;
import test.main.MainFrame;

public class MainFrame extends JFrame implements ActionListener, PropertyChangeListener {
	JTextArea inputDo = null;
	JTextField inputDate = null;
	JTable table = null;
	DefaultTableModel model = null;
	
	public MainFrame() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("할 일");
		inputDo = new JTextArea(24, 10);
		
		JLabel label2 = new JLabel("마감일");
		inputDate = new JTextField(10);
		
		JButton orderByBtn1 = new JButton("할 일로 정렬");
		orderByBtn1.setActionCommand("orderByDo");
		
		JButton orderByBtn2 = new JButton("마감일로 정렬");
		orderByBtn2.setActionCommand("orderByDate");
		
		JButton selectOneBtn = new JButton("조회");
		selectOneBtn.setActionCommand("select");
		
		JButton saveBtn = new JButton("저장");
	    saveBtn.setActionCommand("save");
	    
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel1.add(label1);
		panel1.add(inputDo);
		panel2.add(label2);
		panel2.add(inputDate);
		panel3.add(orderByBtn1);
		panel3.add(orderByBtn2);
		panel3.add(selectOneBtn);
		panel3.add(saveBtn);
		panel3.add(deleteBtn);
		
		add(panel1, BorderLayout.WEST);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.NORTH);
		
		table = new JTable();
		
		String[] colNames = {"번호", "할 일", "마감일"};
		
		model = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				if(column == 0) {
					return false;
				}
				return true;
			}
		};
		
		table.setModel(model);
		
		JScrollPane scroll = new JScrollPane(table);
		
		add(scroll, BorderLayout.EAST);
		
		displayWork("Num");
		
		orderByBtn1.addActionListener(this);
		orderByBtn2.addActionListener(this);
		selectOneBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		table.addPropertyChangeListener(this);
	}
	
	public void displayWork(String selectType) {
		model.setRowCount(0);
		
		List<WorkDto> workList = new WorkDao().getAllData(selectType);
		for(WorkDto work:workList) {
			Object[] obj = {work.getNum(), work.getContent(), work.getDatetime()};
			model.addRow(obj);
		}
	}
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String eventComm = e.getActionCommand();
		boolean isSuccess = true;
		
		if(eventComm.equals("orderByDo")) {
			displayWork("Content");
		} else if(eventComm.equals("orderByDate")) {
			displayWork("Datetime");
		} else if(eventComm.equals("select")) {
			Integer inputNum = Integer.parseInt(JOptionPane.showInputDialog(this, "검색할 데이터의 index를 입력해주세요."));
			WorkDao dao = new WorkDao();
			WorkDto work = dao.getData(inputNum);
			
			if(work!=null) {
				model.setRowCount(0);
				
				Object[] obj = {work.getNum(), work.getContent(), work.getDatetime()};
				model.addRow(obj);
			} else {
				JOptionPane.showMessageDialog(this, "조회할 데이터가 없습니다!", "Do not have Data", JOptionPane.WARNING_MESSAGE);
				displayWork("Num");
			}
		} else if(eventComm.equals("save")) {
			String content = inputDo.getText();
			String datetime = inputDate.getText();
			
			if(content.isEmpty() || datetime.isEmpty()) {
				JOptionPane.showMessageDialog(this, "추가할 데이터정보를 입력하세요!", "Did not input Data", JOptionPane.WARNING_MESSAGE);
				return;
			} else if(datetime.length()!=8) {
				JOptionPane.showMessageDialog(this, "정확한 날짜 타입으로 입력하세요!\r[날짜 타입 : 8글자]", "Did not input Correct type", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			WorkDto work = new WorkDto();
			work.setContent(content);
			work.setDatetime(datetime);
			
			WorkDao dao = new WorkDao();
			isSuccess = dao.insert(work);
			
			if(isSuccess) {
				displayWork("Num");
			} else {
				JOptionPane.showMessageDialog(this, "데이터 추가 실패!", "Fail to input Data", JOptionPane.WARNING_MESSAGE);
			}
		} else if(eventComm.equals("delete")) {
			int[] selectedNums = table.getSelectedRows();
			if(selectedNums.length==0) {
				JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요!", "Did not choice Data", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			WorkDao dao = new WorkDao();
			for(int selectedNum:selectedNums) {
				int num = (int)model.getValueAt(selectedNum, 0);
				isSuccess = dao.delete(num);
				
				if(!isSuccess) {
					JOptionPane.showMessageDialog(this, "데이터 삭제 실패!", "Fail to delete Data", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			
			displayWork("Num");
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propName = evt.getPropertyName();
		boolean isEdit = table.isEditing();
		boolean isSuccess = true;
		
		// 셀 수정이 아니고 propName이 tableCellEditor 일 때 해당 row의 수정된 결과 저장
		if(propName.equals("tableCellEditor") && !isEdit) {
			int selectedNum = table.getSelectedRow();
			int num = (int)model.getValueAt(selectedNum, 0);
			String content = (String)model.getValueAt(selectedNum, 1);
			String datetime = (String)model.getValueAt(selectedNum, 2);
			datetime = datetime.replace(" 00:00:00", "");
			
			System.out.println(num+content+datetime);
			
			WorkDto dto = new WorkDto(num, content, datetime);
			WorkDao dao = new WorkDao();
			isSuccess = dao.update(dto);
			
			displayWork("Num");
			
			if(!isSuccess) {
				JOptionPane.showMessageDialog(this, "데이터 수정 실패!", "Fail to update Data", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
