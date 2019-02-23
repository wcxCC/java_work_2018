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

//���Խ���
public class Test extends JFrame {
	JLabel label1;		//������ǩ
	JLabel label2;		//��ʾ���ʵ�Ӣ��
	
	JLabel label3;		//������ʾ����
	

	
	JButton button3;	//���ذ�ť
	JButton button4;	//�˳���ť
	
	JButton button5;	//����Aѡ�ť
	JButton button6;	//����Bѡ�ť
	JButton button7;	//����Cѡ�ť
	JButton button8;	//����Dѡ�ť
	
	int Score = 0;			//���ڼ�¼����
	int count = 1;			//���ڼ�¼���
	
	int errorCount;		//���ڼ�¼�������
	
	public static EnglishWord [] recitedWord;	//���ڴ洢��Ҫ��ʾ��10������
	public static EnglishWord [] errorWord;	//���ڴ洢��Ҫ��ʾ��10������
	
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
	        
	        

	        
	        button3 = new JButton("����");	//�½����ذ�ť
	        button4 = new JButton("�˳�");	//�½��˳���ť
	        

      button5 = new JButton("A." + recitedWord[count+3].chinese);	//����Aѡ�ť
	    	button6 =new JButton("B." + recitedWord[count].chinese);	//����Bѡ�ť
	   		button7 =new JButton("C." + recitedWord[count + 1].chinese);	//����Cѡ�ť
	    	button8 = new JButton("D." + recitedWord[count + 2].chinese);	//����Dѡ�ť
	     
	    	
	 //   	String a = new String("Hello");
	    	
	    	label3 = new JLabel();
	    	
	    	label2 = new JLabel("���ģ�" + recitedWord[count].english + ", ��ѡ����ȷ��:");			//�½���ʾ����Ӣ�ĵı�ǩ

	        button3.setBounds(450, 350, 80, 40);
	        button4.setBounds(450, 400, 80, 40);
	       
	        
	       
	        label2.setBounds(50, -50, 400, 300);			//����ʾ����Ӣ����ı�ǩ����λ��
	        button5.setBounds(20, 150, 200, 40);			//��4��ѡ������λ��
	        button6.setBounds(250, 150, 200, 40);
	        button7.setBounds(20, 250, 200, 40);
	        button8.setBounds(250, 250, 200, 40);		
	        
	        label3.setBounds(80, 300, 400, 100);
	        
	        
	        this.add(label2);		//�����ʾ���ʵı�ǩ�ؼ�
	        this.add(label3);		//�����ʾ����
/*	        this.add(button1);		//��Ӱ�ť
	        this.add(button2);		*/
	        this.add(button3);
	        this.add(button4);
		        this.add(button5);		//��Ӱ�ť
	        this.add(button6);
	        this.add(button7);
	        this.add(button8);
        this.add(label1);		//���label1�ؼ�
	        

	        
	        label2.setFont(new Font("����", Font.PLAIN,  20));		//��������
	    	        
	        label2.setForeground(Color.green);			//����������ɫ
	        
	        
	        label3.setFont(new Font("����", Font.PLAIN,  20));		//��������
	        
	        label3.setForeground(Color.green);			//����������ɫ
	        
	        label3.setText("��ǰ������" + Score);	

			
			// �����ذ�ť���¼�������
			button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								DFristPage first = new DFristPage();
								first.init();
							}
					});	
			// ���˳���ť���¼�������
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
					
				}
		});	
			
			// ��Aѡ�ť���¼�������
			button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(count == 3 || count == 7)
								{
									Score += 10;
									label3.setText("��ǰ������" + Score);
								}
								else
								{
									errorWord[errorCount] =  recitedWord[count];
									errorCount++;
								}
								count++;		
								if(count < 11)
								{
									if(count == 3 || count == 7)			//��ΪA��ʱ��
									{
										 button5.setText("A." + recitedWord[count].chinese);
										 button6.setText("B." + recitedWord[count-2].chinese);
										button7.setText("C." + recitedWord[count +2].chinese);
										button8.setText("D." + recitedWord[count + 3].chinese);
									}
									if(count == 1 || count == 9)		//��ΪB��ʱ��
									{
										button5.setText("A." + recitedWord[count - 1].chinese);
										button6.setText("B." + recitedWord[count].chinese);
										button7.setText("C." + recitedWord[count +1].chinese);
										button8.setText("D." + recitedWord[count + 2].chinese);
									}
									if(count == 10 || count == 5 || count == 6)	//��ΪC��ʱ��
									{ 
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count].chinese);
										button7.setText("D." + recitedWord[count +1].chinese);
									}
									
									if(count == 2 || count == 4 || count == 8)	//��ΪD��ʱ��
									{
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count +3].chinese);
										button8.setText("D." + recitedWord[count].chinese);
									}
									label2.setText("���ģ�" + recitedWord[count].english + ", ��ѡ����ȷ��:");
								}
								else
						//			JOptionPane.showMessageDialog(null, "û����һ��");
								{
									label3.setBounds(20, 30, 400, 400);
									 label3.setText("��������" + Score);
									 button5.setVisible(false);
									 button6.setVisible(false);
									 button7.setVisible(false);
									 button8.setVisible(false);
									 
									 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
									
								}
								
								
							}
					});		
			// ��Bѡ�ť���¼�������
			button6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count == 1 || count == 9)
					{
						Score += 10;
						label3.setText("��ǰ������" + Score);
					}
					else
					{
						errorWord[errorCount] =  recitedWord[count];
						errorCount++;
					}
					
					count++;		
					
					
				if(count < 11)
					{
						if(count == 3 || count == 7)			//��ΪA��ʱ��
						{
							 button5.setText("A." + recitedWord[count].chinese);
							 button6.setText("B." + recitedWord[count-2].chinese);
							button7.setText("C." + recitedWord[count +2].chinese);
							button8.setText("D." + recitedWord[count + 3].chinese);
						}
						if(count == 1 || count == 9)		//��ΪB��ʱ��
						{
							button5.setText("A." + recitedWord[count - 1].chinese);
							button6.setText("B." + recitedWord[count].chinese);
							button7.setText("C." + recitedWord[count +1].chinese);
							button8.setText("D." + recitedWord[count + 2].chinese);
						}
						if(count == 10 || count == 5 || count == 6)	//��ΪC��ʱ��
						{ 
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count].chinese);
							button7.setText("D." + recitedWord[count +1].chinese);
						}
						
						if(count == 2 || count == 4 || count == 8)	//��ΪD��ʱ��
						{
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count +3].chinese);
							button8.setText("D." + recitedWord[count].chinese);
						}
						label2.setText("���ģ�" + recitedWord[count].english + ", ��ѡ����ȷ��:");
					}
					else
			//			JOptionPane.showMessageDialog(null, "û����һ��");
					{
						label3.setBounds(20, 30, 400, 400);
						 label3.setText("��������" + Score);
						 button5.setVisible(false);
						 button6.setVisible(false);
						 button7.setVisible(false);
						 button8.setVisible(false);
						 
						 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
						
					}
					
				}
		});	
			
			// ��Cѡ�ť���¼�������
			button7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(count == 10 || count == 5 || count == 6)
								{
									Score += 10;
									label3.setText("��ǰ������" + Score);
								}
								else
								{
									errorWord[errorCount] =  recitedWord[count];
									errorCount++;
								}
								count++;		
						
								if(count < 11)
								{
									if(count == 3 || count == 7)			//��ΪA��ʱ��
									{
										 button5.setText("A." + recitedWord[count].chinese);
										 button6.setText("B." + recitedWord[count-2].chinese);
										button7.setText("C." + recitedWord[count +2].chinese);
										button8.setText("D." + recitedWord[count + 3].chinese);
									}
									if(count == 1 || count == 9)		//��ΪB��ʱ��
									{
										button5.setText("A." + recitedWord[count - 1].chinese);
										button6.setText("B." + recitedWord[count].chinese);
										button7.setText("C." + recitedWord[count +1].chinese);
										button8.setText("D." + recitedWord[count + 2].chinese);
									}
									if(count == 10 || count == 5 || count == 6)	//��ΪC��ʱ��
									{ 
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count].chinese);
										button7.setText("D." + recitedWord[count +1].chinese);
									}
									
									if(count == 2 || count == 4 || count == 8)	//��ΪD��ʱ��
									{
										button5.setText("A." + recitedWord[count-3].chinese);
									    button6.setText("B." + recitedWord[count-2].chinese);
									
										button7.setText("C." + recitedWord[count +3].chinese);
										button8.setText("D." + recitedWord[count].chinese);
									}
									label2.setText("���ģ�" + recitedWord[count].english + ", ��ѡ����ȷ��:");
								}	
								else
						//			JOptionPane.showMessageDialog(null, "û����һ��");
								{
									label3.setBounds(20, 30, 400, 400);
									 label3.setText("��������" + Score);
									 button5.setVisible(false);
									 button6.setVisible(false);
									 button7.setVisible(false);
									 button8.setVisible(false);
									 
									 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
									
								}
							}
					});			
			// ��Dѡ�ť���¼�������
			button8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count == 2 || count == 4 || count == 8)
					{
						Score += 10;
						label3.setText("��ǰ������" + Score);
					}
					else
					{
						errorWord[errorCount] =  recitedWord[count];
						errorCount++;
					}
					count++;		
			
					if(count < 11)
					{
						if(count == 3 || count == 7)			//��ΪA��ʱ��
						{
							 button5.setText("A." + recitedWord[count].chinese);
							 button6.setText("B." + recitedWord[count-2].chinese);
							button7.setText("C." + recitedWord[count +2].chinese);
							button8.setText("D." + recitedWord[count + 3].chinese);
						}
						if(count == 1 || count == 9)		//��ΪB��ʱ��
						{
							button5.setText("A." + recitedWord[count - 1].chinese);
							button6.setText("B." + recitedWord[count].chinese);
							button7.setText("C." + recitedWord[count +1].chinese);
							button8.setText("D." + recitedWord[count + 2].chinese);
						}
						if(count == 10 || count == 5 || count == 6)	//��ΪC��ʱ��
						{ 
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count].chinese);
							button7.setText("D." + recitedWord[count +1].chinese);
						}
						
						if(count == 2 || count == 4 || count == 8)	//��ΪD��ʱ��
						{
							button5.setText("A." + recitedWord[count-3].chinese);
						    button6.setText("B." + recitedWord[count-2].chinese);
						
							button7.setText("C." + recitedWord[count +3].chinese);
							button8.setText("D." + recitedWord[count].chinese);
						}
						label2.setText("���ģ�" + recitedWord[count].english + ", ��ѡ����ȷ��:");
					}
					else
			//			JOptionPane.showMessageDialog(null, "û����һ��");
					{
						label3.setBounds(20, 30, 400, 400);
						 label3.setText("��������" + Score);
						 button5.setVisible(false);
						 button6.setVisible(false);
						 button7.setVisible(false);
						 button8.setVisible(false);
						 
						 EnglishWord.nWriteToFile(errorWord, "error.txt", errorCount);
						
					}
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