package memory;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

//背诵的界面
public class Recite extends JFrame{
	JLabel label1;		//背景标签
	JLabel label2;		//显示单词的英文
	JLabel label3;		//显示单词的中午
	JButton button1;	//显示上一个单词的按钮
	JButton button2;	//显示下一个单词的按钮
	JButton button3;	//返回按钮
	JButton button4;	//退出按钮
	
	public static EnglishWord [] word;	//用于存储将要显示的10个单词
	public static EnglishWord [] rawWord;	//用于存储生词表单中的单词
	int count;							//用于记录显示的数组下标

	EnglishWord lab;		//标签中显示的单词

	
	Recite()				//在构造函数中为类成员分配空间
	{
		//init();
		count = 0;
		word = new EnglishWord[10];
		for(int i = 0; i < word.length; i++)
		{
			word[i] = new EnglishWord();
		}
		
		rawWord = new EnglishWord[100];
		
		for(int i = 0; i < rawWord.length; i++)
		{
			rawWord[i] = new EnglishWord();
		}
	}

	public void init()
	{
	
		
		lab = new EnglishWord();		//给正在显示的单词申请空间
		EnglishWord.getFromFile(word, new String("raw.txt"));
//		int count= 0;		//用于记录Label显示的是第几个单词
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
	        
	        button1 = new JButton("上一个");	//新建显示上一个单词的按钮
	        button2 = new JButton("下一个");	//新建显示下一个单词的按钮
	        button3 = new JButton("返回");	//新建返回按钮
	        button4 = new JButton("退出");	//新建退出按钮
	        
	  //      String a = new String("Hello");
	 //       String b = new String("你好");
	 //       String a = new String(word[count].english);
	   //     String b = new String(word[count].chinese);
	  //      a = word[coun].english;
	  //     b = word[coun].chinese;
	        label2 = new JLabel(word[count].english);			//新建显示单词英文的标签
	        label3 = new JLabel(word[count].chinese);		//新建显示单词中文的标签	
	        
	   
	        
	  
	        
	        
	        
	        
	        button1.setBounds(100, 250, 80, 40);			//给按钮设置位置
	        button2.setBounds(400, 250, 80, 40);
	        button3.setBounds(300, 380, 80, 40);
	        button4.setBounds(400, 380, 80, 40);
	       
	        label2.setBounds(150, 0, 200, 300);			//给显示单词英文的标签设置位置
	        label3.setBounds( 300,0,200,300 ); 			//给显示单词中文的标签设置位置
	        
	        label2.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体
	        label3.setFont(new Font("宋体", Font.PLAIN,  16));		//设置字体

	        label2.setForeground(Color.green);			//设置字体颜色
	        label3.setForeground(Color.green);
	        
	        
	        
	        
	        this.add(label2);		//添加显示单词的标签控件
	        this.add(label3);		
	        this.add(button1);		//添加按钮
	        this.add(button2);
	        this.add(button3);
	        this.add(button4);
	        this.add(label1);		//添加label1控件
	        
	     // 给上一个按钮加事件监听器
			button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								if(count > 0)
								{
									count--;
									label2.setText(word[count].english);
									label3.setText(word[count].chinese);
								}
								else
									JOptionPane.showMessageDialog(null, "没有上一个");
								
							}
					});	
			// 给下一个按钮加事件监听器
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count < word.length)
					{
						count++;
						label2.setText(word[count].english);
						label3.setText(word[count].chinese);
					}
					else
						JOptionPane.showMessageDialog(null, "没有下一个");
					
					
				}
		});	
			
			// 给返回按钮加事件监听器
			button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								EnglishWord.WriteToFile(word,"recited.txt");
							//	EnglishWord.allgetFromFile(rawWord, "raw.txt");
								EnglishWord.allgetFromFile(rawWord, "raw.txt", "a.txt", 9);
								EnglishWord.clearFile("raw.txt");
								EnglishWord.allgetFromFile(rawWord, "a.txt", "raw.txt", -1);
								EnglishWord.clearFile("a.txt");
								DFristPage first = new DFristPage();
								first.init();
							}
					});	
			// 给退出按钮加事件监听器
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EnglishWord.WriteToFile(word,"recited.txt");
					//	EnglishWord.allgetFromFile(rawWord, "raw.txt");
						EnglishWord.allgetFromFile(rawWord, "raw.txt", "a.txt", 9);
						EnglishWord.clearFile("raw.txt");
						EnglishWord.allgetFromFile(rawWord, "a.txt", "raw.txt", -1);
						EnglishWord.clearFile("a.txt");
					
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

class EnglishWord
{
	public String english;			//单词的英文
	public String chinese;			//单词的中文意思
	public static void getFromFile(EnglishWord [] word,String file)
	{
		try {
			
			 Scanner scanner = new Scanner(new FileInputStream(file)) ;
			 
			 int count = 0;
			 int i = 0;
		        while(scanner.hasNext() && i<word.length){
		          word[i].english= scanner.next() ;
		       //	String a = new String();
		        //	a = scanner.next();
		       //   System.out.println(word[i].english);
		        	
		           if(scanner.hasNext())
		           {
		        	   word[i].chinese= scanner.next() ;
		        	   System.out.println(word[i].chinese);
		        	//   String b = new String();
			        //	b = scanner.next();
		        	   i++;
		           	}
		           else
		        	   break;
		//            System.out.println(world);
		        }
		        
		        scanner.close();
			
		}catch(IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Error--" + e.toString());
			}
		
		
		//EnglishWord [10] word ;
	}
	
	public static void WriteToFile(EnglishWord [] word,String file)
	{
		FileWriter fw = null;
		int i = 0;
		try {
		//如果文件存在，则追加内容；如果文件不存在，则创建文件
	
			java.io.File f = new java.io.File(file);
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		while(i < word.length)
		{
				pw.println(word[i].english + "\t" + word[i].chinese + "\n");
			i++;
		}

		pw.flush();
		try {
		fw.flush();
		pw.close();
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	
	public static void nWriteToFile(EnglishWord [] word,String file, int n)			//将n个元素写入文件中
	{
		FileWriter fw = null;
		int i = 0;
		try {
		//如果文件存在，则追加内容；如果文件不存在，则创建文件
	
			java.io.File f = new java.io.File(file);
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		while(i < n)
		{
				pw.println(word[i].english + "\t" + word[i].chinese + "\n");
			i++;
		}

		pw.flush();
		try {
		fw.flush();
		pw.close();
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
		
	}
	
	public static void rawWriteToFile(EnglishWord word,String file)
	{
		FileWriter fw = null;
	
		try {
		//如果文件存在，则追加内容；如果文件不存在，则创建文件
	
		java.io.File f = new java.io.File(file);
		fw = new FileWriter(f, true);
		} catch (IOException e) {
		e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		
		pw.println("\n" + word.english + "\t" + word.chinese );
		
		

		pw.flush();
		try {
		fw.flush();
		pw.close();
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	
	
	public static void allgetFromFile(EnglishWord [] word,String fromFile, String toFile,int k)
	{
		try {
			
			 Scanner scanner = new Scanner(new FileInputStream(fromFile)) ;
			 
			 int count = 0;
			 int i = 0;
		        while(scanner.hasNext()){
		          word[i].english= scanner.next() ;
		       //	String a = new String();
		        //	a = scanner.next();
		          System.out.println(word[i].english);
		        	
		           if(scanner.hasNext())
		           {
		        	   word[i].chinese= scanner.next() ;
		        	   System.out.println(word[i].chinese);
		        	//   String b = new String();
			        //	b = scanner.next();
		        	   
		        	   if(i > k)
		        	   {
		        		   rawWriteToFile(word[i],toFile);
		        	   }
		        	   i++;
		           	}
		           else
		        	   break;
		//            System.out.println(world);
		        }
		        
		        scanner.close();
			
		}catch(IOException e) 
		{
			JOptionPane.showMessageDialog(null, "Error--" + e.toString());
			}
		
		
		//EnglishWord [10] word ;
	}
	
	
	public static void clearFile(String File)
	{
		java.io.File f = new java.io.File(File);

		FileWriter fw = null;
		try {
		fw = new FileWriter(f);
		fw.write("");
		fw.close();
		} catch (IOException e) {
		e.printStackTrace();
		}

		java.io.File file = new java.io.File("文件");
		if(file.exists()){
		file.delete();
		try {
		file.createNewFile();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		

	}
	
}

