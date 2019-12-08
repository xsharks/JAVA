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
		 setTitle("学生选课系统 ");  	 
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
        j1 = new JButton("课程");
        j2 = new JButton("选课\n");
        j3 = new JButton("退课");
        j4 = new JPanel();
        String[] str = { "《java》", "  C语言", "  c++" , "  计算机组成原理" , "  计算机系统" , "  计算机网络" , "  数据结构", "  离散数学", "  高等数学" , "  大学英语" , "  市场营销" , "  管弦乐队配器与赏析" , "  大学体育"   };
        j5 = new JComboBox(str);
        j6 = new JTextField();
        j7 = new JButton(" 关闭");
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
     					System.out.println("文件传输错误");
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
    File f1= new File(".."+File.separator+"选课.txt"); 
  	FileWriter wr;//声明写入字符的类,用于字符数据的写入
  	BufferedReader br;//声明读去字符的缓存类,用于字符的读取
  	BufferedWriter bw ;//声明写的缓存,用于字符数据的缓存写入
  	String temp; //声明取出的一行字符串,通过while循环存入缓存中
  	StringBuffer st ;//声明字符串缓存区,对取出的数据进行缓存
  	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = j6.getText();
		String scourse =(String)j5.getSelectedItem();
		System.out.println(scourse);
		course=new Course(1, scourse, "《综合教学楼0921》",3,3);
		teacher=new Teacher(1, "《授课老师张世博》", "《夏旺》",course);
		student=new Student(1,name, "《夏旺》",course,teacher);	   
      	    j9.setText(" "+student);	
      	 
   
              
    
            try {
              	 wr=new FileWriter(f1,true);
            	    	 wr.write("  "+student.getName()+"  "+student.getCourse()+"  "+student.getTeather()+"\n");
            	    	 wr.flush();
            	    	 wr.close();
      			} catch (IOException e1) {
      				System.out.println("文件传输错误");
      			}
      		
      	}
           
	}
    

