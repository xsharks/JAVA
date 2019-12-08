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
![images](https://github.com/xsharks/JAVA/blob/master/%E5%9B%BE%E7%89%874.png)

# 运行结果
![images](https://github.com/xsharks/JAVA/blob/master/图片2.png)
![images](https://github.com/xsharks/JAVA/blob/master/%E5%9B%BE%E7%89%871.png)
![images](https://github.com/xsharks/JAVA/blob/master/%E5%9B%BE%E7%89%873.png)

#实验感想

在本次实验中我通过学习之前老师讲解的知识，以及综合之前几次Java实验的内容，对本次『学生选课系统』实验进行编程运行，在不断的修改，在其中的参数与数据的联系，并且考虑操作中可能出现的异常，处理异常。由于本次试验又使用到了Github这个开源托管平台，第二次的使用我也有一次熟悉了操作，相信这个平台能够在以后的学习乃至工作中带来更多的启发。 最后，Java课程的学习已经伴随着实验以及考试结束了，我还有很多不会的知识，不过我也会继续努力的，为这个行业增光添彩

