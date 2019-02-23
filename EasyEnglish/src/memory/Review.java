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
import javax.swing.JTextArea;

//有添加难单词

//复习单词的界面
public class Review extends JFrame{
	JLabel label1;		//背景标签
	JLabel label2;		//显示单词的英文
	JLabel label3;		//显示单词的中午
	JButton button1;	//显示上一个单词的按钮
	JButton button2;	//显示下一个单词的按钮
	JButton button3;	//显示添加难词本的按钮
	JButton button4;	//显示新生成的难词按钮
	JButton button5;	//返回按钮
	JButton button6;	//退出按钮
	
	JButton button7;		//继续复习按钮按钮
	
	JTextArea t1;		//显示表单内容的文本区,用于显示新添加的难单词
	
	int count ;
	int difCount;		//用于存放添加的难词
	
	public static EnglishWord [] recitedWord;	//用于存储将要显示的10个单词
	public static EnglishWord [] difWord;		//用于存放难词
	
	Review() 
	{
		//init();
		count = 0;
		difCount = 0;
		recitedWord = new EnglishWord[10];
		for(int i = 0; i < recitedWord.length; i++)
		{
			recitedWord[i] = new EnglishWord();
		}
		
		difWord = new EnglishWord[10];
		for(int i = 0; i < difWord.length; i++)
		{
			difWord[i] = new EnglishWord();
		}
		
		
		
	}
	
	public void init()
	{
		EnglishWord.getFromFile(recitedWord, new String("recited.txt"));
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
	        
	        button1 = new JButton("上一个");	//新建显示上一个单词的按钮
	        button2 = new JButton("下一个");	//新建显示下一个单词的按钮
	        
	        button3 = new JButton("添加到难词单");	//新建显示添加难词本的按钮
	        button4 = new JButton("显示新添加的难词");	//新建显示新生成难词的按钮
	        
	        button5 = new JButton("返回");	//新建返回按钮
	        button6 = new JButton("退出");	//新建退出按钮
	        button7 = new JButton("继续复习");		//继续复习按钮按钮
	        
	        t1 = new JTextArea(100, 100);		//新建显示表单的文本区
	        
	       
	        
	        label2 = new JLabel("英文：" + recitedWord[count].english);			//新建显示单词英文的标签
	        label3 = new JLabel("中文：" + recitedWord[count].chinese);		//新建显示单词中文的标签	
	        
	        button1.setBounds(50, 150, 80, 40);			//给按钮设置位置
	        button2.setBounds(400, 150, 80, 40);
	        button3.setBounds(180, 150, 150, 40);
	        button4.setBounds(420, 260, 150, 40);
	        
	        button5.setBounds(450, 330, 80, 40);
	        button6.setBounds(450, 400, 80, 40);
	        
	        button7.setBounds(430, 260, 150, 40);
	        
	        label2.setBounds(100, -50, 150, 300);			//给显示单词英文的标签设置位置
	        label3.setBounds( 340,-50,200,300 ); 			//给显示单词中文的标签设置位置
	        
	        t1.setBounds(20, 30, 300, 1000);
	        
	        t1.setBackground((new Color(65541)));			//设置背景颜色
	        
	        t1.setVisible(false);   		//隐藏文本区
	        button7.setVisible(false);//隐藏恢复按钮
	        
	        label2.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体
	        label3.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体

	        label2.setForeground(Color.green);			//设置字体颜色
	        label3.setForeground(Color.green);
	        t1.setForeground(Color.green);			//设置字体颜色
	        
	        t1.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体
	        
	        label2.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体
	        label3.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体

	        label2.setForeground(Color.green);			//设置字体颜色
	        label3.setForeground(Color.green);
	        
	        getContentPane().add(label2);		//添加显示单词的标签控件
	        getContentPane().add(label3);		
	        getContentPane().add(t1);			//添加文本区
	        getContentPane().add(button1);		//添加按钮
	        getContentPane().add(button2);
	        getContentPane().add(button3);
	        getContentPane().add(button4);
	        getContentPane().add(button5);
	        getContentPane().add(button6);
	        getContentPane().add(button7);
	        getContentPane().add(label1);		//添加label1控件
	        
	        // 给上一个按钮加事件监听器
			button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(count > 0)
								{
									count--;
									label2.setText(recitedWord[count].english);
									label3.setText(recitedWord[count].chinese);
								}
								else
									JOptionPane.showMessageDialog(null, "没有上一个");
								
							
								
							}
					});	
			// 给下一个按钮加事件监听器
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count < recitedWord.length)
					{
						count++;
						label2.setText(recitedWord[count].english);
						label3.setText(recitedWord[count].chinese);
					}
					else
						JOptionPane.showMessageDialog(null, "没有下一个");
					
					
				
					
				}
		});	
			 // 给添加难词到难词单按钮加事件监听器
			button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								difWord[difCount] =  recitedWord[count];
								JOptionPane.showMessageDialog(null, "添加成功");
								
								difCount ++;
								
							}
					});	
			// 给查看新添加难词按钮加事件监听器
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a = new String();
					for(int i=0; i< difCount; i++)
			        {
			        	
			        	
			        		a = a +  difWord[i].english + "\t" + difWord[i].chinese + "\n";
			        		
			        	
			        }
			//		JOptionPane.showMessageDialog(null, "Hello");
					label2.setVisible(false);	//隐藏多余的
					label3.setVisible(false);		
					button1.setVisible(false);
					button2.setVisible(false);
					button3.setVisible(false);	
					button4.setVisible(false);
					t1.setText(a);
					button7.setVisible(true);
					t1.setVisible(true);
				        
				       
				}
		});	
			
			
			// 给返回按钮加事件监听器
			button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								EnglishWord.nWriteToFile(difWord, "dif.txt", difCount);
								DFristPage first = new DFristPage();
								first.init();
								
							}
					});	
			// 给退出按钮加事件监听器
			button6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EnglishWord.nWriteToFile(difWord, "dif.txt", difCount);
					System.exit(0);
					
				}
		});	
	      
			
			 // 给继续复习按钮按钮加事件监听器
			button7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								label2.setVisible(true);	//显示按钮复习界面
								label3.setVisible(true);		
								button1.setVisible(true);
								button2.setVisible(true);
								button3.setVisible(true);	
								button4.setVisible(true);
								
								button7.setVisible(false);	//隐藏恢复按钮和文本区
								t1.setVisible(false);
								
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