package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
class MyFrame extends JFrame{
	public MyFrame() {
		 setTitle("ѧ��ѡ��ϵͳ ");  	 
         setSize(500,500);
         setVisible(true);
         setBackground(Color.MAGENTA);
	}
}
class MyWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		Window window=(Window)e.getComponent();
		window.dispose();
		
	}
}

public class GridBagLayoutDemo implements ActionListener {
    public static void main(String args[])throws IOException {
    	GridBagLayoutDemo demo = new GridBagLayoutDemo();
    }
    public GridBagLayoutDemo() {
    	f = new MyFrame();
        j1 = new JButton("�γ�");
        j2 = new JButton("ѡ��\n");
        j3 = new JButton("�˿�");
        j4 = new JPanel();
        String[] str = { "��java��", "  C����", "  c++" , "  ��������ԭ��" , "  �����ϵͳ" , "  ���������" , "  ���ݽṹ", "  ��ɢ��ѧ", "  �ߵ���ѧ" , "  ��ѧӢ��" , "  �г�Ӫ��" , "  �����ֶ�����������" , "  ��ѧ����"   };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton(" �ر�");
        j8 = new JList(str);
        j9 = new TextField();
        j9.setBackground(Color.CYAN);
        

        j2.addActionListener(this);
       
        j3.addActionListener(new ActionListener() {
			
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				try {
     					String namet=j6.getText();
     				    String courset=j5.getToolTipText();
     					j9.setText(namet+" tuike " +courset);				
     					st = new StringBuffer(4096);
     					temp = null;
     					br = new BufferedReader(new FileReader(f1)); 
     					while((temp = br.readLine())!= null){ 
     					       if ((temp.indexOf(namet))==-1) {
     					    	   st.append(temp).append("\r\n");
     						}       
     					} 
     					br.close(); 
     					bw = new BufferedWriter((new FileWriter(f1))); 
     					bw.write(st.toString()); 
     					bw.close();
     				} catch (IOException e1) {
     					System.out.println("�ļ��������");
     				}
     				
     			}
     		});
         	
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
        f.add(j1);
        f.add(j2);
        f.add(j3);
        f.add(j4);
        f.add(j5);
        f.add(j6);
        f.add(j7);
        f.add(j8);
        f.add(j9);
        GridBagConstraints s= new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;
        s.gridwidth=1;s.weightx = 0;s.weighty=0;
       
        layout.setConstraints(j1, s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j2, s);
        s.gridwidth=1;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j3, s);
        s.gridwidth=0;s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j4, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j5, s);
        s.gridwidth=4;
        s.weightx = 1;
        s.weighty=0;
        layout.setConstraints(j6, s);
        s.gridwidth=0;
        s.weightx = 0;
        s.weighty=0;
        layout.setConstraints(j7, s);
        s.gridwidth=2;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j8, s);
        s.gridwidth=5;
        s.weightx = 0;
        s.weighty=1;
        layout.setConstraints(j9, s);
        f.addWindowListener(new MyWindow());
    }
    JButton j1;
    JButton j2;
    JButton j3;
    JPanel j4;
    JComboBox j5;
    JTextField j6;
    JButton j7;
    JList j8;
    TextField j9;
    Teacher teacher;
    Course course;
    Student student;
    MyFrame f ;
    File f1= new File(".."+File.separator+"ѡ��.txt"); 
  	FileWriter wr;//����д���ַ�����,�����ַ����ݵ�д��
  	BufferedReader br;//������ȥ�ַ��Ļ�����,�����ַ��Ķ�ȡ
  	BufferedWriter bw ;//����д�Ļ���,�����ַ����ݵĻ���д��
  	String temp; //����ȡ����һ���ַ���,ͨ��whileѭ�����뻺����
  	StringBuffer st ;//�����ַ���������,��ȡ�������ݽ��л���
  	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = j6.getText();
		String scourse =(String)j5.getSelectedItem();
		System.out.println(scourse);
		course=new Course(1, scourse, "���ۺϽ�ѧ¥0921��",3,3);
		teacher=new Teacher(1, "���ڿ���ʦ��������", "��������",course);
		student=new Student(1,name, "��������",course,teacher);	   
      	    j9.setText(" "+student);	
      	 
   
              
    
            try {
              	 wr=new FileWriter(f1,true);
            	    	 wr.write("  "+student.getName()+"  "+student.getCourse()+"  "+student.getTeather()+"\n");
            	    	 wr.flush();
            	    	 wr.close();
      			} catch (IOException e1) {
      				System.out.println("�ļ��������");
      			}
      		
      	}
           
	}
    

