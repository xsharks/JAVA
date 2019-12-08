# 计G191 2019322033 夏旺

# 实验名称
综合实验 选课退课输入输出
# 实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常
  # 代码
```java
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
```

退课
```java
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
```
# 流程图、
![images]()

# 运行结果
![images]()
![images]()
![images]()

