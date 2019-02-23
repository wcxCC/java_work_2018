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

//��������
public class SeeTable extends JFrame {
	public SeeTable() {
		//init();
	}
	
	JLabel label1;		//������ǩ
	
	JTextArea t1;		//��ʾ�����ݵ��ı���
	
	JScrollPane scrollPane;		//���������
	
	JButton button1;	//��ʾ����İ�ť
	JButton button2;	//��ʾ���ʵİ�ť
	JButton button3;	//��ʾ�ѱ����ʵİ�ť
	JButton button4;	//��ʾ�ܵ��ʱ�İ�ť
	JButton button5;	//��ʾ���Ȿ
	JButton button6;	//���ذ�ť
	JButton button7;	//�˳���ť
	
	
	public static EnglishWord [] errorWord;	//���ڴ洢��Ҫ��ʾ�Ĵ�����еĵ���
	public static EnglishWord [] rawWord;	//���ڴ洢��Ҫ��ʾ�����ʱ��еĵ���
	public static EnglishWord [] recitedWord;	//���ڴ洢��Ҫ��ʾ���ѱ����ʱ��еĵ���
	public static EnglishWord [] allWord;	//���ڴ洢��Ҫ��ʾ���ܱ��еĵ���
	public static EnglishWord [] difWord;	//���ڴ洢��Ҫ��ʾ��������еĵ���

	

	
	public void init()
	{
		this.setTitle("EazyEnglish");		//���ô�������
		getContentPane().setLayout(null);			//���ò��ַ�ʽ
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
	        
	        button1 = new JButton("��ʵ�");	//�½���ʾ��ʵ��İ�ť
	        button2 = new JButton("���ʵ�");	//�½���ʾ���ʵ��İ�ť
	        button3 = new JButton("�ѱ��ʵ�");	//�½���ʾ�ѱ��ʵ��İ�ť
	        button4 = new JButton("�ܴʵ�");	//�½���ʾ�ܴʵ��İ�ť
	        button5 = new JButton("�Ѵʵ�");		//�½���ʾ�Ѵʵ��İ�ť
	        
	        button6 = new JButton("����");	//�½����ذ�ť
	        button7 = new JButton("�˳�");	//�½��˳���ť
	        
	        t1 = new JTextArea(100, 1000);		//�½���ʾ�����ı���
	        
	        scrollPane = new JScrollPane(t1);	//��ʾ������
	        
	       
	        
	        button1.setBounds(200, 50, 200, 40);			//����ť����λ��
	        button2.setBounds(200, 120, 200, 40);
	        button3.setBounds(200, 190, 200, 40);
	        button4.setBounds(200, 260, 200, 40);
	        button5.setBounds(200, 330, 200, 40);
	        button6.setBounds(80, 410, 80, 40);
	        button7.setBounds(465, 410, 80, 40);
	        
	      //  label2.setBounds(100, -50, 150, 300);			//����ʾ����Ӣ�ĵı�ǩ����λ��
	        
	        
	        scrollPane.setVisible(false);   //���ع�����
	        scrollPane.setBounds(20, 30, 400, 400);
	        
	        scrollPane.setViewportView(t1);	//����ı�����������
	        
//	        t1.setBounds(20, 30, 400, 1000);
	        
	        t1.setBackground(new Color(197128));			//���ñ�����ɫ
	     
	        getContentPane().add(button1);		//��Ӱ�ť
	        getContentPane().add(button2);
	        getContentPane().add(button3);
	        getContentPane().add(button4);
	        getContentPane().add(button5);
	        getContentPane().add(button6);
	        getContentPane().add(button7);
	        
	        getContentPane().add(scrollPane);	//��ӹ�����
	        
	
//	        this.add(t1);		//�����ʾ�����ı���
	        
	        getContentPane().add(label1);		//���label1�ؼ�
	        
	        
	   //     
	        t1.setFont(new Font("����", Font.PLAIN,  16));		//��������

	        t1.setForeground(Color.green);			//����������ɫ

	        
	     // �����ⰴť���¼�������
		button1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							 	button1.setBounds(450, 30, 90, 40);			//����ť����λ��
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
						    	   a = "�����Ϊ��";
						       }
						       
						       t1.setText(a);   //��label2��Ϊ���ɼ�
						       
						       scrollPane.setVisible(true);   //���ع�����
						       
			
						        
						       
						}
				});	
		// �����ʰ�ť���¼�������
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setBounds(450, 30, 90, 40);			//����ť����λ��
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
		    	   a = "�����Ϊ��";
		       }
		       
		       t1.setText(a);   //��label2��Ϊ���ɼ�
		       
		       scrollPane.setVisible(true);    //��scrollPane��Ϊ���ɼ�
		        
				
			}
	});	
		// ���ѱ����ʰ�ť���¼�������
		button3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							button1.setBounds(450, 30, 90, 40);			//����ť����λ��
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
					    	   a = "�����Ϊ��";
					       }
					       
					       t1.setText(a);   //��label2��Ϊ���ɼ�
					       
					       scrollPane.setVisible(true);    //��scrollPane��Ϊ���ɼ�
					        
					        
							
						}
				});	
		// ���ܵ��ʰ�ť���¼�������
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button1.setBounds(450, 30, 90, 40);			//����ť����λ��
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
		    	   a = "�����Ϊ��";
		       }
		       
		       t1.setText(a);   //��label2��Ϊ���ɼ�
		       
		       scrollPane.setVisible(true);    //��scrollPane��Ϊ���ɼ�
		        
		        
				
			
				
			}
	});	
		
		// ���Ѵʵ���ť���¼�������
				button5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						button1.setBounds(450, 30, 90, 40);			//����ť����λ��
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
				    	   a = "�����Ϊ��";
				       }
				       
				       t1.setText(a);   //��label2��Ϊ���ɼ�
				       
				       scrollPane.setVisible(true);    //��scrollPane��Ϊ���ɼ�
				        
						
					
						
					}
			});	

		
		// �����ذ�ť���¼�������
		button6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							DFristPage first = new DFristPage();
							first.init();
						}
				});	
		// ���˳���ť���¼�������
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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