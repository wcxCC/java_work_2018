package memory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//测试界面
public class Test extends JFrame {
	JLabel label1;		//背景标签
	JLabel label2;		//显示单词的英文
	
	JLabel label3;		//用于显示分数
	

	
	JButton button3;	//返回按钮
	JButton button4;	//退出按钮
	
	JButton button5;	//测试A选项按钮
	JButton button6;	//测试B选项按钮
	JButton button7;	//测试C选项按钮
	JButton button8;	//测试D选项按钮
	
	int Score = 0;			//用于记录分数
	int count = 1;			//用于记录题号
	
	int errorCount;		//用于记录错题题号
	
	public static EnglishWord [] recitedWord;	//用于存储将要显示的10个单词
	public static EnglishWord [] errorWord;	//用于存储将要显示的10个单词
	
	Test() 
	{
		//init();
		count = 0;
		errorCount = 0;
		recitedWord = new EnglishWord[12];
		for(int i = 0; i < recitedWord.length; i++)
		{
			recitedWord[i] = new EnglishWord();
		}
		
		errorWord = new EnglishWord[10];
		for(int i = 0; i < errorWord.length; i++)
		{
			errorWord[i] = new EnglishWord();
		}
		
		
	}
	public void init()
	{
	EnglishWord.getFromFile(recitedWord, new String("recited.txt"));
		this.setTitle("EazyEnglish");		//设置窗口名称
			this.setLayout(null);			//设置布局方式
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
	        
	        

	        
	        button3 = new JButton("返回");	//新建返回按钮
	        button4 = new JButton("退出");	//新建退出按钮
	        

      button5 = new JButton("A." + recitedWord[count+3].chinese);	//测试A选项按钮
	    	button6 =new JButton("B." + recitedWord[count].chinese);	//测试B选项按钮
	   		button7 =new JButton("C." + recitedWord[count + 1].chinese);	//测试C选项按钮
	    	button8 = new JButton("D." + recitedWord[count + 2].chinese);	//测试D选项按钮
	     
	    	
	 //   	String a = new String("Hello");
	    	
	    	label3 = new JLabel();
	    	
	    	label2 = new JLabel("中文：" + recitedWord[count].english + ", 请选择正确答案:");			//新建显示单词英文的标签

	        button3.setBounds(450, 350, 80, 40);
	        button4.setBounds(450, 400, 80, 40);
	       
	        
	       
	        label2.setBounds(50, -50, 400, 300);			//给显示单词英文题的标签设置位置
	        button5.setBounds(20, 150, 200, 40);			//给4个选项设置位置
	        button6.setBounds(250, 150, 200, 40);
	        button7.setBounds(20, 250, 200, 40);
	        button8.setBounds(250, 250, 200, 40);		
	        
	        label3.setBounds(80, 300, 400, 100);
	        
	        
	        this.add(label2);		//添加显示单词的标签控件
	        this.add(label3);		//添加显示分数
/*	        this.add(button1);		//添加按钮
	        this.add(button2);		*/
	        this.add(button3);
	        this.add(button4);
		        this.add(button5);		//添加按钮
	        this.add(button6);
	        this.add(button7);
	        this.add(button8);
        this.add(label1);		//添加label1控件
	        

	        
	        label2.setFont(new Font("宋体", Font.PLAIN,  20));		//设置字体
	    	        
	        label2.setForeground(Color.green);			//设置字体颜色
	        
	        
	        label3.setFont(new Font("宋体", Font.PLAIN,  20));		//设置字体
	        
	        label3.setForeground(Color.green);			//设置字体颜色
	        
	        label3.setText("当前分数：" + Score);	

			
			// 给返回按钮加事件监听器
			button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								DFristPage first = new DFristPage();
								first.init();
							}
					});	
			// 给退出按钮加事件监听器
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
					
				}
		});	
			
			// 给A选项按钮加事件监听器
			button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(count == 3 || count == 7)
								{
									Score += 10;
									label3.setText("当前分数：" + Score);
								}
								else
								{
									errorWord[errorCount] =  recitedWord[count];
									errorCount++;
								}
								count++;		
								if(count < 11)
								{
									if(count == 3 || count == 7)			//答案为A的时候
									{
										 button5.setText("A." + recitedWord[count].chinese);
										 button6.setText("B." + recitedWord[count-2].chinese);
										button7.setText("C." + recitedWord[count +2].chinese);
										button8.setText("D." + recitedWord[count + 3].chinese);
									}
									if(count == 1 || count == 9)		//答案为B的时候
									{
										button5.setText("A." + recitedWord[count - 1].chinese);
										button6.setText("B." + recitedWord[count].chinese);
										button7.setText("C." + recitedWord[count +1].chinese);
										button8.setText("D." + recitedWord[count + 2].chinese);
									}
									if(count == 10 || count == 5 || count == 6)	//答案为C的时候
									{ 
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count].chinese);
										button7.setText("D." + recitedWord[count +1].chinese);
									}
									
									if(count == 2 || count == 4 || count == 8)	//答案为D的时候
									{
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count +3].chinese);
										button8.setText("D." + recitedWord[count].chinese);
									}
									label2.setText("中文：" + recitedWord[count].english + ", 请选择正确答案:");
								}
								else
						//			JOptionPane.showMessageDialog(null, "没有下一个");
								{
									label3.setBounds(20, 30, 400, 400);
									 label3.setText("最后分数：" + Score);
									 button5.setVisible(false);
									 button6.setVisible(false);
									 button7.setVisible(false);
									 button8.setVisible(false);
									 
									 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
									
								}
								
								
							}
					});		
			// 给B选项按钮加事件监听器
			button6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count == 1 || count == 9)
					{
						Score += 10;
						label3.setText("当前分数：" + Score);
					}
					else
					{
						errorWord[errorCount] =  recitedWord[count];
						errorCount++;
					}
					
					count++;		
					
					
				if(count < 11)
					{
						if(count == 3 || count == 7)			//答案为A的时候
						{
							 button5.setText("A." + recitedWord[count].chinese);
							 button6.setText("B." + recitedWord[count-2].chinese);
							button7.setText("C." + recitedWord[count +2].chinese);
							button8.setText("D." + recitedWord[count + 3].chinese);
						}
						if(count == 1 || count == 9)		//答案为B的时候
						{
							button5.setText("A." + recitedWord[count - 1].chinese);
							button6.setText("B." + recitedWord[count].chinese);
							button7.setText("C." + recitedWord[count +1].chinese);
							button8.setText("D." + recitedWord[count + 2].chinese);
						}
						if(count == 10 || count == 5 || count == 6)	//答案为C的时候
						{ 
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count].chinese);
							button7.setText("D." + recitedWord[count +1].chinese);
						}
						
						if(count == 2 || count == 4 || count == 8)	//答案为D的时候
						{
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count +3].chinese);
							button8.setText("D." + recitedWord[count].chinese);
						}
						label2.setText("中文：" + recitedWord[count].english + ", 请选择正确答案:");
					}
					else
			//			JOptionPane.showMessageDialog(null, "没有下一个");
					{
						label3.setBounds(20, 30, 400, 400);
						 label3.setText("最后分数：" + Score);
						 button5.setVisible(false);
						 button6.setVisible(false);
						 button7.setVisible(false);
						 button8.setVisible(false);
						 
						 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
						
					}
					
				}
		});	
			
			// 给C选项按钮加事件监听器
			button7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(count == 10 || count == 5 || count == 6)
								{
									Score += 10;
									label3.setText("当前分数：" + Score);
								}
								else
								{
									errorWord[errorCount] =  recitedWord[count];
									errorCount++;
								}
								count++;		
						
								if(count < 11)
								{
									if(count == 3 || count == 7)			//答案为A的时候
									{
										 button5.setText("A." + recitedWord[count].chinese);
										 button6.setText("B." + recitedWord[count-2].chinese);
										button7.setText("C." + recitedWord[count +2].chinese);
										button8.setText("D." + recitedWord[count + 3].chinese);
									}
									if(count == 1 || count == 9)		//答案为B的时候
									{
										button5.setText("A." + recitedWord[count - 1].chinese);
										button6.setText("B." + recitedWord[count].chinese);
										button7.setText("C." + recitedWord[count +1].chinese);
										button8.setText("D." + recitedWord[count + 2].chinese);
									}
									if(count == 10 || count == 5 || count == 6)	//答案为C的时候
									{ 
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count].chinese);
										button7.setText("D." + recitedWord[count +1].chinese);
									}
									
									if(count == 2 || count == 4 || count == 8)	//答案为D的时候
									{
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count +3].chinese);
										button8.setText("D." + recitedWord[count].chinese);
									}
									label2.setText("中文：" + recitedWord[count].english + ", 请选择正确答案:");
								}	
								else
						//			JOptionPane.showMessageDialog(null, "没有下一个");
								{
									label3.setBounds(20, 30, 400, 400);
									 label3.setText("最后分数：" + Score);
									 button5.setVisible(false);
									 button6.setVisible(false);
									 button7.setVisible(false);
									 button8.setVisible(false);
									 
									 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
									
								}
							}
					});			
			// 给D选项按钮加事件监听器
			button8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count == 2 || count == 4 || count == 8)
					{
						Score += 10;
						label3.setText("当前分数：" + Score);
					}
					else
					{
						errorWord[errorCount] =  recitedWord[count];
						errorCount++;
					}
					count++;		
			
					if(count < 11)
					{
						if(count == 3 || count == 7)			//答案为A的时候
						{
							 button5.setText("A." + recitedWord[count].chinese);
							 button6.setText("B." + recitedWord[count-2].chinese);
							button7.setText("C." + recitedWord[count +2].chinese);
							button8.setText("D." + recitedWord[count + 3].chinese);
						}
						if(count == 1 || count == 9)		//答案为B的时候
						{
							button5.setText("A." + recitedWord[count - 1].chinese);
							button6.setText("B." + recitedWord[count].chinese);
							button7.setText("C." + recitedWord[count +1].chinese);
							button8.setText("D." + recitedWord[count + 2].chinese);
						}
						if(count == 10 || count == 5 || count == 6)	//答案为C的时候
						{ 
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count].chinese);
							button7.setText("D." + recitedWord[count +1].chinese);
						}
						
						if(count == 2 || count == 4 || count == 8)	//答案为D的时候
						{
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count +3].chinese);
							button8.setText("D." + recitedWord[count].chinese);
						}
						label2.setText("中文：" + recitedWord[count].english + ", 请选择正确答案:");
					}
					else
			//			JOptionPane.showMessageDialog(null, "没有下一个");
					{
						label3.setBounds(20, 30, 400, 400);
						 label3.setText("最后分数：" + Score);
						 button5.setVisible(false);
						 button6.setVisible(false);
						 button7.setVisible(false);
						 button8.setVisible(false);
						 
						 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
						
					}
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