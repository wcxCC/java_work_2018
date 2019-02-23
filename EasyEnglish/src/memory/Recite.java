package memory;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;

//���еĽ���
public class Recite extends JFrame{
	JLabel label1;		//������ǩ
	JLabel label2;		//��ʾ���ʵ�Ӣ��
	JLabel label3;		//��ʾ���ʵ�����
	JButton button1;	//��ʾ��һ�����ʵİ�ť
	JButton button2;	//��ʾ��һ�����ʵİ�ť
	JButton button3;	//���ذ�ť
	JButton button4;	//�˳���ť
	
	public static EnglishWord [] word;	//���ڴ洢��Ҫ��ʾ��10������
	public static EnglishWord [] rawWord;	//���ڴ洢���ʱ��еĵ���
	int count;							//���ڼ�¼��ʾ�������±�

	EnglishWord lab;		//��ǩ����ʾ�ĵ���

	
	Recite()				//�ڹ��캯����Ϊ���Ա����ռ�
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
	
		
		lab = new EnglishWord();		//��������ʾ�ĵ�������ռ�
		EnglishWord.getFromFile(word, new String("raw.txt"));
//		int count= 0;		//���ڼ�¼Label��ʾ���ǵڼ�������
		this.setTitle("EazyEnglish");		//���ô�������
		this.setLayout(null);			//���ò��ַ�ʽ
		this.setBounds(350, 150, 600, 500);	//���ô��ڵĴ�С
	
		 ImageIcon background = new ImageIcon("");  
	        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
	        label1 = new JLabel(background);  
	        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
	        label1.setBounds(0, 0, this.getWidth(), this.getHeight());  
	        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
	        JPanel imagePanel = (JPanel) this.getContentPane();  
	        imagePanel.setOpaque(false);  
	        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
	        this.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));  
	        
	        this.setBackground(new Color(1188910));			//���ñ�����ɫ
	        
	        button1 = new JButton("��һ��");	//�½���ʾ��һ�����ʵİ�ť
	        button2 = new JButton("��һ��");	//�½���ʾ��һ�����ʵİ�ť
	        button3 = new JButton("����");	//�½����ذ�ť
	        button4 = new JButton("�˳�");	//�½��˳���ť
	        
	  //      String a = new String("Hello");
	 //       String b = new String("���");
	 //       String a = new String(word[count].english);
	   //     String b = new String(word[count].chinese);
	  //      a = word[coun].english;
	  //     b = word[coun].chinese;
	        label2 = new JLabel(word[count].english);			//�½���ʾ����Ӣ�ĵı�ǩ
	        label3 = new JLabel(word[count].chinese);		//�½���ʾ�������ĵı�ǩ	
	        
	   
	        
	  
	        
	        
	        
	        
	        button1.setBounds(100, 250, 80, 40);			//����ť����λ��
	        button2.setBounds(400, 250, 80, 40);
	        button3.setBounds(300, 380, 80, 40);
	        button4.setBounds(400, 380, 80, 40);
	       
	        label2.setBounds(150, 0, 200, 300);			//����ʾ����Ӣ�ĵı�ǩ����λ��
	        label3.setBounds( 300,0,200,300 ); 			//����ʾ�������ĵı�ǩ����λ��
	        
	        label2.setFont(new Font("����", Font.PLAIN,  16));		//��������
	        label3.setFont(new Font("����", Font.PLAIN,  16));		//��������

	        label2.setForeground(Color.green);			//����������ɫ
	        label3.setForeground(Color.green);
	        
	        
	        
	        
	        this.add(label2);		//�����ʾ���ʵı�ǩ�ؼ�
	        this.add(label3);		
	        this.add(button1);		//��Ӱ�ť
	        this.add(button2);
	        this.add(button3);
	        this.add(button4);
	        this.add(label1);		//���label1�ؼ�
	        
	     // ����һ����ť���¼�������
			button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								if(count > 0)
								{
									count--;
									label2.setText(word[count].english);
									label3.setText(word[count].chinese);
								}
								else
									JOptionPane.showMessageDialog(null, "û����һ��");
								
							}
					});	
			// ����һ����ť���¼�������
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count < word.length)
					{
						count++;
						label2.setText(word[count].english);
						label3.setText(word[count].chinese);
					}
					else
						JOptionPane.showMessageDialog(null, "û����һ��");
					
					
				}
		});	
			
			// �����ذ�ť���¼�������
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
			// ���˳���ť���¼�������
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
	      
	        
	      //�������ڼ���
			addWindowListener(new WindowAdapter() {			
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
	       
		  this.setVisible(true);			//ʹ���ڿɼ�
		  
		
		
	}
	

}

class EnglishWord
{
	public String english;			//���ʵ�Ӣ��
	public String chinese;			//���ʵ�������˼
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
		//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
	
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
	
	public static void nWriteToFile(EnglishWord [] word,String file, int n)			//��n��Ԫ��д���ļ���
	{
		FileWriter fw = null;
		int i = 0;
		try {
		//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
	
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
		//����ļ����ڣ���׷�����ݣ�����ļ������ڣ��򴴽��ļ�
	
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

		java.io.File file = new java.io.File("�ļ�");
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

