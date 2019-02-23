package memory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//看表单的类
public class SeeTable extends JFrame {
	public SeeTable() {
		//init();
	}
	
	JLabel label1;		//背景标签
	
	JTextArea t1;		//显示表单内容的文本区
	
	JScrollPane scrollPane;		//定义滚动框
	
	JButton button1;	//显示错题的按钮
	JButton button2;	//显示生词的按钮
	JButton button3;	//显示已背单词的按钮
	JButton button4;	//显示总单词表的按钮
	JButton button5;	//显示难题本
	JButton button6;	//返回按钮
	JButton button7;	//退出按钮
	
	
	public static EnglishWord [] errorWord;	//用于存储将要显示的错题表单中的单词
	public static EnglishWord [] rawWord;	//用于存储将要显示的生词表单中的单词
	public static EnglishWord [] recitedWord;	//用于存储将要显示的已背单词表单中的单词
	public static EnglishWord [] allWord;	//用于存储将要显示的总表单中的单词
	public static EnglishWord [] difWord;	//用于存储将要显示的难题表单中的单词

	

	
	public void init()
	{
		this.setTitle("EazyEnglish");		//设置窗口名称
		getContentPane().setLayout(null);			//设置布局方式
		this.setBounds(350, 150, 600, 500);	//设置窗口的大小
	
		 ImageIcon background = new ImageIcon("");  
	        // 把背景图片显示在一个标签里面  
	        label1 = new JLabel(background);  
	        // 把标签的大小位置设置为图片刚好填充整个面板  
	        label1.setBounds(0, 0, this.getWidth(), this.getHeight());  
	        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
	        JPanel imagePanel = (JPanel) this.getContentPane();  
	        imagePanel.setOpaque(false);  
	        // 把背景图片添加到分层窗格的最底层作为背景  
	        this.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));  
	        
	        this.setBackground(new Color(1188910));			//设置背景颜色
	        
	        button1 = new JButton("错词单");	//新建显示错词单的按钮
	        button2 = new JButton("生词单");	//新建显示生词单的按钮
	        button3 = new JButton("已背词单");	//新建显示已背词单的按钮
	        button4 = new JButton("总词单");	//新建显示总词单的按钮
	        button5 = new JButton("难词单");		//新建显示难词单的按钮
	        
	        button6 = new JButton("返回");	//新建返回按钮
	        button7 = new JButton("退出");	//新建退出按钮
	        
	        t1 = new JTextArea(100, 1000);		//新建显示表单的文本区
	        
	        scrollPane = new JScrollPane(t1);	//显示滚动框
	        
	       
	        
	        button1.setBounds(200, 50, 200, 40);			//给按钮设置位置
	        button2.setBounds(200, 120, 200, 40);
	        button3.setBounds(200, 190, 200, 40);
	        button4.setBounds(200, 260, 200, 40);
	        button5.setBounds(200, 330, 200, 40);
	        button6.setBounds(80, 410, 80, 40);
	        button7.setBounds(465, 410, 80, 40);
	        
	      //  label2.setBounds(100, -50, 150, 300);			//给显示单词英文的标签设置位置
	        
	        
	        scrollPane.setVisible(false);   //隐藏滚动框
	        scrollPane.setBounds(20, 30, 400, 400);
	        
	        scrollPane.setViewportView(t1);	//添加文本区到滚动框
	        
//	        t1.setBounds(20, 30, 400, 1000);
	        
	        t1.setBackground(new Color(197128));			//设置背景颜色
	     
	        getContentPane().add(button1);		//添加按钮
	        getContentPane().add(button2);
	        getContentPane().add(button3);
	        getContentPane().add(button4);
	        getContentPane().add(button5);
	        getContentPane().add(button6);
	        getContentPane().add(button7);
	        
	        getContentPane().add(scrollPane);	//添加滚动框
	        
	
//	        this.add(t1);		//添加显示表单的文本区
	        
	        getContentPane().add(label1);		//添加label1控件
	        
	        
	   //     
	        t1.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体

	        t1.setForeground(Color.green);			//设置字体颜色

	        
	     // 给错题按钮加事件监听器
		button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							 	button1.setBounds(450, 30, 90, 40);			//给按钮设置位置
						        button2.setBounds(450, 90, 90, 40);
						        button3.setBounds(450, 150, 90, 40);
						        button4.setBounds(450, 210, 90, 40);
						        button5.setBounds(450, 270, 90, 40);
						        button6.setBounds(450, 330, 90, 40);
						        button7.setBounds(450, 390, 90, 40);

								int count = 0;
								errorWord = new EnglishWord[100];
								for(int i = 0; i < errorWord .length; i++)
								{
									errorWord[i] = new EnglishWord();
								}
						        EnglishWord.getFromFile(errorWord , new String("error.txt"));
						        String a ;
						        a = new String();
						        for(int i=0; i<errorWord .length; i++)
						        {
						        
						        		a = a +  errorWord [i].english + "\t" + errorWord [i].chinese + "\n";
						      
						        }
						       if(a.length() == 0)
						       {
						    	   a = "错题表单为空";
						       }
						       
						       t1.setText(a);   //将label2设为不可见
						       
						       scrollPane.setVisible(true);   //隐藏滚动框
						       
			
						        
						       
						}
				});	
		// 给生词按钮加事件监听器
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setBounds(450, 30, 90, 40);			//给按钮设置位置
		        button2.setBounds(450, 90, 90, 40);
		        button3.setBounds(450, 150, 90, 40);
		        button4.setBounds(450, 210, 90, 40);
		        button5.setBounds(450, 270, 90, 40);
		        button6.setBounds(450, 330, 90, 40);
		        button7.setBounds(450, 390, 90, 40);

				int count = 0;
				rawWord = new EnglishWord[100];
				for(int i = 0; i < rawWord .length; i++)
				{
					rawWord[i] = new EnglishWord();
				}
				
		        EnglishWord.getFromFile(rawWord, new String("raw.txt"));
		        String a ;
		        a = new String();
		        for(int i=0; i<rawWord.length; i++)
		        {
		        	
		        	
		        		a = a +  rawWord[i].english + "\t" + rawWord[i].chinese + "\n";
		        		
		        	
		        }
		       if(a.length() == 0)
		       {
		    	   a = "错题表单为空";
		       }
		       
		       t1.setText(a);   //将label2设为不可见
		       
		       scrollPane.setVisible(true);    //将scrollPane设为不可见
		        
				
			}
	});	
		// 给已背单词按钮加事件监听器
		button3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							button1.setBounds(450, 30, 90, 40);			//给按钮设置位置
					        button2.setBounds(450, 90, 90, 40);
					        button3.setBounds(450, 150, 90, 40);
					        button4.setBounds(450, 210, 90, 40);
					        button5.setBounds(450, 270, 90, 40);
					        button6.setBounds(450, 330, 90, 40);
					        button7.setBounds(450, 390, 90, 40);

							int count = 0;
							recitedWord = new EnglishWord[100];
							for(int i = 0; i < recitedWord .length; i++)
							{
								recitedWord[i] = new EnglishWord();
							}
					        
					        EnglishWord.getFromFile(recitedWord, new String("recited.txt"));
					        String a ;
					        a = new String();
					        for(int i=0; i<recitedWord.length; i++)
					        {
					        	
					        	
					        		a = a +  recitedWord[i].english + "\t" + recitedWord[i].chinese + "\n";
					        		
					        	
					        }
					       if(a.length() == 0)
					       {
					    	   a = "错题表单为空";
					       }
					       
					       t1.setText(a);   //将label2设为不可见
					       
					       scrollPane.setVisible(true);    //将scrollPane设为不可见
					        
					        
							
						}
				});	
		// 给总单词按钮加事件监听器
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setBounds(450, 30, 90, 40);			//给按钮设置位置
		        button2.setBounds(450, 90, 90, 40);
		        button3.setBounds(450, 150, 90, 40);
		        button4.setBounds(450, 210, 90, 40);
		        button5.setBounds(450, 270, 90, 40);
		        button6.setBounds(450, 330, 90, 40);
		        button7.setBounds(450, 390, 90, 40);

				int count = 0;
				allWord = new EnglishWord[100];
				for(int i = 0; i < allWord .length; i++)
				{
					allWord[i] = new EnglishWord();
				}
		        
		        EnglishWord.getFromFile(allWord, new String("all.txt"));
		        String a ;
		        a = new String();
		        for(int i=0; i<allWord.length; i++)
		        {
		        	
		        	
		        		a = a +  allWord[i].english + "\t" + allWord[i].chinese + "\n";
		        		
		        	
		        }
		       if(a.length() == 0)
		       {
		    	   a = "错题表单为空";
		       }
		       
		       t1.setText(a);   //将label2设为不可见
		       
		       scrollPane.setVisible(true);    //将scrollPane设为不可见
		        
		        
				
			
				
			}
	});	
		
		// 给难词单按钮加事件监听器
				button5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						button1.setBounds(450, 30, 90, 40);			//给按钮设置位置
				        button2.setBounds(450, 90, 90, 40);
				        button3.setBounds(450, 150, 90, 40);
				        button4.setBounds(450, 210, 90, 40);
				        button5.setBounds(450, 270, 90, 40);
				        button6.setBounds(450, 330, 90, 40);
				        button7.setBounds(450, 390, 90, 40);

						int count = 0;
						difWord = new EnglishWord[100];
						for(int i = 0; i < difWord .length; i++)
						{
							difWord[i] = new EnglishWord();
						}
				        
				        EnglishWord.getFromFile(difWord, new String("dif.txt"));
				        String a ;
				        a = new String();
				        for(int i=0; i<difWord.length; i++)
				        {
				        	
				        	
				        		a = a +  difWord[i].english + "\t" + difWord[i].chinese + "\n";
				        		
				        	
				        }
				       if(a.length() == 0)
				       {
				    	   a = "错题表单为空";
				       }
				       
				       t1.setText(a);   //将label2设为不可见
				       
				       scrollPane.setVisible(true);    //将scrollPane设为不可见
				        
						
					
						
					}
			});	

		
		// 给返回按钮加事件监听器
		button6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DFristPage first = new DFristPage();
							first.init();
						}
				});	
		// 给退出按钮加事件监听器
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
	});	
      
		
		
        
      //建立窗口监听
		addWindowListener(new WindowAdapter() {			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
       
	  this.setVisible(true);			//使窗口可见
	        
	       
	       
	}
}