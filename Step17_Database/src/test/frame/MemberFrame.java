package test.frame;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.pack.MemberDto;
/*
 *  //1. 선택된 row  인덱스를 읽어온다.
   int selectedIndex=table.getSelectedRow();
   
   //2. 선택된 row 의 첫번째(0번째) 칼럼의 숫자를 읽어온다 (삭제할 회원의 번호)
   int num=(int)model.getValueAt(selectedIndex, 0);
   
   
   -------------------------------------
   
   List<MemberDto>  list=dao.getList();
   
   for(MemberDto tmp:list){
      Object[] row={tmp.getNum(), tmp.getName(), tmp.getAddr()};
      model.addRow(row);
   }
 * 
 */
public class MemberFrame extends JFrame implements ActionListener, PropertyChangeListener{
   //필드
   JTextField inputName, inputAddr;
   DefaultTableModel model;
   JTable table;
   
   
   //생성자
   public MemberFrame() {
      setLayout(new BorderLayout());
      
      JLabel label1=new JLabel("이름");
      inputName=new JTextField(10);
      
      JLabel label2=new JLabel("주소");
      inputAddr=new JTextField(10);
      
      JButton saveBtn=new JButton("저장");
      saveBtn.setActionCommand("save");
      
      //삭제 버튼 추가
      JButton deleteBtn=new JButton("삭제");
      deleteBtn.setActionCommand("delete");
      
      JPanel panel=new JPanel();
      panel.add(label1);
      panel.add(inputName);
      panel.add(label2);
      panel.add(inputAddr);
      panel.add(saveBtn);
      panel.add(deleteBtn);
      
      add(panel, BorderLayout.NORTH);
      
      //표형식으로 정보를 출력하기 위한 JTable
      table=new JTable();
      //칼럼명을 String[] 에 순서대로 준비
      String[] colNames= {"번호", "이름", "주소"};
      //테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 갯수)
      model=new DefaultTableModel(colNames, 0) {
    	  @Override
    	  public boolean isCellEditable(int row, int column) {
    		  if(column == 0) {
    			  return false;
    		  }
    		  return super.isCellEditable(row, column);
    	  }
      };
      
      //모델을 테이블에 연결한다.
      table.setModel(model);
      //스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
      JScrollPane scroll=new JScrollPane(table);
      //JScrollPane  을 프레임의 가운데에 배치하기 
      add(scroll, BorderLayout.CENTER);
      
      displayMember();
      
      //버튼에 액션리스너 등록
      saveBtn.addActionListener(this);
      deleteBtn.addActionListener(this);
      
      table.addPropertyChangeListener(this);
   }
   
   //테이블에 데이터 출력하는 메소드
   public void displayMember() {
	   model.setRowCount(0);
	   
	   List<MemberDto> memList = new MemberDao().getAllData();
	   for(MemberDto member:memList) {
		   Object[] row = {member.getNum(), member.getName(), member.getAddr()};
		   model.addRow(row);
	   }
	}
   
   //main  메소드
   public static void main(String[] args) {
      MemberFrame f=new MemberFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setBounds(100, 100, 800, 500);
      f.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
	   
      //눌러진 버튼의 action command 값을 읽어와서 
      String command=e.getActionCommand();
      //분기한다. 
      if(command.equals("save")) {
         String name = inputName.getText();
         String addr = inputAddr.getText();
         
         MemberDto dto = new MemberDto();
         dto.setName(name);
         dto.setAddr(addr);
         
         boolean isSuccess = new MemberDao().insert(dto);
         if(isSuccess) {
        	 displayMember();
         } else {
        	 System.out.println("추가 실패!");
         }
      }else if(command.equals("delete")) {
         try {
        	 MemberDao dao = new MemberDao();
        	 
        	 int[] selectedNums = table.getSelectedRows();
        	 
        	 for(int selectedNum:selectedNums) {
        		 System.out.println(selectedNum);
        		 int num = (int)model.getValueAt(selectedNum, 0);
        		 boolean isSuccess = dao.delete(num);
        	 }
        	 displayMember();
         } catch(Exception e1) {
        	 JOptionPane.showMessageDialog(this, "삭제할 ROW를 선택하세요!");
         }
         
      }
   }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		boolean isEdit = table.isEditing();
		String eventProp = evt.getPropertyName();
		MemberDao dao = new MemberDao();
		MemberDto dto = null;
		boolean isSuccess = true;
		
		if(!isEdit && eventProp.equals("tableCellEditor")) {
			int rowNum = table.getSelectedRow();
			int columnNum = table.getSelectedColumn();
			
			int num = (int)model.getValueAt(rowNum, 0);
			String name = (String)model.getValueAt(rowNum, 1);
			String addr = (String)model.getValueAt(rowNum, 2);
			dto = new MemberDto(num, name, addr);
			isSuccess = dao.update(dto);
			
			if(isSuccess) {
				displayMember();
			} else {
				JOptionPane.showMessageDialog(this, "수정 실패!");
			}
		}
	}
}
