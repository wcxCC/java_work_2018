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

//������ѵ���

//��ϰ���ʵĽ���
public class Review extends JFrame{
	JLabel label1;		//������ǩ
	JLabel label2;		//��ʾ���ʵ�Ӣ��
	JLabel label3;		//��ʾ���ʵ�����
	JButton button1;	//��ʾ��һ�����ʵİ�ť
	JButton button2;	//��ʾ��һ�����ʵİ�ť
	JButton button3;	//��ʾ����Ѵʱ��İ�ť
	JButton button4;	//��ʾ�����ɵ��Ѵʰ�ť
	JButton button5;	//���ذ�ť
	JButton button6;	//�˳���ť
	
	JButton button7;		//������ϰ��ť��ť
	
	JTextArea t1;		//��ʾ�����ݵ��ı���,������ʾ����ӵ��ѵ���
	
	int count ;
	int difCount;		//���ڴ����ӵ��Ѵ�
	
	public static EnglishWord [] recitedWord;	//���ڴ洢��Ҫ��ʾ��10������
	public static EnglishWord [] difWord;		//���ڴ���Ѵ�
	
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
	        
	        button1 = new JButton("��һ��");	//�½���ʾ��һ�����ʵİ�ť
	        button2 = new JButton("��һ��");	//�½���ʾ��һ�����ʵİ�ť
	        
	        button3 = new JButton("��ӵ��Ѵʵ�");	//�½���ʾ����Ѵʱ��İ�ť
	        button4 = new JButton("��ʾ����ӵ��Ѵ�");	//�½���ʾ�������Ѵʵİ�ť
	        
	        button5 = new JButton("����");	//�½����ذ�ť
	        button6 = new JButton("�˳�");	//�½��˳���ť
	        button7 = new JButton("������ϰ");		//������ϰ��ť��ť
	        
	        t1 = new JTextArea(100, 100);		//�½���ʾ�����ı���
	        
	       
	        
	        label2 = new JLabel("Ӣ�ģ�" + recitedWord[count].english);			//�½���ʾ����Ӣ�ĵı�ǩ
	        label3 = new JLabel("���ģ�" + recitedWord[count].chinese);		//�½���ʾ�������ĵı�ǩ	
	        
	        button1.setBounds(50, 150, 80, 40);			//����ť����λ��
	        button2.setBounds(400, 150, 80, 40);
	        button3.setBounds(180, 150, 150, 40);
	        button4.setBounds(420, 260, 150, 40);
	        
	        button5.setBounds(450, 330, 80, 40);
	        button6.setBounds(450, 400, 80, 40);
	        
	        button7.setBounds(430, 260, 150, 40);
	        
	        label2.setBounds(100, -50, 150, 300);			//����ʾ����Ӣ�ĵı�ǩ����λ��
	        label3.setBounds( 340,-50,200,300 ); 			//����ʾ�������ĵı�ǩ����λ��
	        
	        t1.setBounds(20, 30, 300, 1000);
	        
	        t1.setBackground((new Color(65541)));			//���ñ�����ɫ
	        
	        t1.setVisible(false);   		//�����ı���
	        button7.setVisible(false);//���ػָ���ť
	        
	        label2.setFont(new Font("����", Font.PLAIN,  16));		//��������
	        label3.setFont(new Font("����", Font.PLAIN,  16));		//��������

	        label2.setForeground(Color.green);			//����������ɫ
	        label3.setForeground(Color.green);
	        t1.setForeground(Color.green);			//����������ɫ
	        
	        t1.setFont(new Font("����", Font.PLAIN,  16));		//��������
	        
	        label2.setFont(new Font("����", Font.PLAIN,  16));		//��������
	        label3.setFont(new Font("����", Font.PLAIN,  16));		//��������

	        label2.setForeground(Color.green);			//����������ɫ
	        label3.setForeground(Color.green);
	        
	        getContentPane().add(label2);		//�����ʾ���ʵı�ǩ�ؼ�
	        getContentPane().add(label3);		
	        getContentPane().add(t1);			//����ı���
	        getContentPane().add(button1);		//��Ӱ�ť
	        getContentPane().add(button2);
	        getContentPane().add(button3);
	        getContentPane().add(button4);
	        getContentPane().add(button5);
	        getContentPane().add(button6);
	        getContentPane().add(button7);
	        getContentPane().add(label1);		//���label1�ؼ�
	        
	        // ����һ����ť���¼�������
			button1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if(count > 0)
								{
									count--;
									label2.setText(recitedWord[count].english);
									label3.setText(recitedWord[count].chinese);
								}
								else
									JOptionPane.showMessageDialog(null, "û����һ��");
								
							
								
							}
					});	
			// ����һ����ť���¼�������
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(count < recitedWord.length)
					{
						count++;
						label2.setText(recitedWord[count].english);
						label3.setText(recitedWord[count].chinese);
					}
					else
						JOptionPane.showMessageDialog(null, "û����һ��");
					
					
				
					
				}
		});	
			 // ������Ѵʵ��Ѵʵ���ť���¼�������
			button3.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								difWord[difCount] =  recitedWord[count];
								JOptionPane.showMessageDialog(null, "��ӳɹ�");
								
								difCount ++;
								
							}
					});	
			// ���鿴������Ѵʰ�ť���¼�������
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String a = new String();
					for(int i=0; i< difCount; i++)
			        {
			        	
			        	
			        		a = a +  difWord[i].english + "\t" + difWord[i].chinese + "\n";
			        		
			        	
			        }
			//		JOptionPane.showMessageDialog(null, "Hello");
					label2.setVisible(false);	//���ض����
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
			
			
			// �����ذ�ť���¼�������
			button5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								EnglishWord.nWriteToFile(difWord, "dif.txt", difCount);
								DFristPage first = new DFristPage();
								first.init();
								
							}
					});	
			// ���˳���ť���¼�������
			button6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EnglishWord.nWriteToFile(difWord, "dif.txt", difCount);
					System.exit(0);
					
				}
		});	
	      
			
			 // ��������ϰ��ť��ť���¼�������
			button7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								label2.setVisible(true);	//��ʾ��ť��ϰ����
								label3.setVisible(true);		
								button1.setVisible(true);
								button2.setVisible(true);
								button3.setVisible(true);	
								button4.setVisible(true);
								
								button7.setVisible(false);	//���ػָ���ť���ı���
								t1.setVisible(false);
								
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