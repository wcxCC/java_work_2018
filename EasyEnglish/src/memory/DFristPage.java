package memory;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//@SuppressWarnings("serial")
public class DFristPage extends JFrame {
	public DFristPage() {
		init();
	}
	// TODO �Զ����ɵķ������
	JLabel label1;		//������ǩ
	JLabel label2;		//��ʾ�汾��Ϣ
	private JButton DRecite; 	//���еİ�ť
	private JButton DReview;	//��ϰ�İ�ť
	private JButton DTable;		//�鿴���ʱ�İ�ť
	private JButton DTest;		//��ⱳ��Ч�ʵİ�ť
	private JButton DExit;		//�˳��İ�ť
	String version = "�汾1.0	\n�����ߣ������\nѧ�ţ�8002117004";				//������ʾ�汾��Ϣ

	public void init()
	{
		this.setTitle("EazyEnglish");
		
		getContentPane().setLayout(null);
		this.setBounds(350, 150, 600, 500);
		
		DRecite = new JButton("��ʼ������");		//����ť
		DReview = new JButton("��ϰ����");
		DTable = new JButton("�鿴���ʱ�");
		DTest = new JButton("����Ч�ʲ���");
		DExit = new JButton("�˳�");
		
		
		
		
		 ImageIcon background = new ImageIcon();  
	        // �ѱ���ͼƬ��ʾ��һ����ǩ����  
	        label1 = new JLabel(background);  
	        // �ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ�����������  
	         label1.setBounds(0, 0, this.getWidth(), this.getHeight());  
	        // �����ݴ���ת��ΪJPanel���������÷���setOpaque()��ʹ���ݴ���͸��  
	        JPanel imagePanel = (JPanel) this.getContentPane();  
	        imagePanel.setOpaque(false);  
	        // �ѱ���ͼƬ��ӵ��ֲ㴰�����ײ���Ϊ����  
	       // this.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));  
	       
	        
	        label2 = new JLabel(version);		//�½���ǩ		
	        
	        label2.setBounds( this.getWidth()-450, this.getHeight()-150,500,200 ); 
	        
	    //    label2.setBackground(new Color( 11976644));
	        
	        getContentPane().add(label2);
	        label2.setFont(new Font("����", Font.PLAIN,  16));
	        label2.setForeground(Color.white);			//���ð汾��Ϣ��������ɫ
	   
	   
		
		
		
		
		
		
		
		DRecite.setBounds(200, 30, 200, 40);
		DReview.setBounds(200, 110, 200, 40);
		DTable.setBounds(200, 190, 200, 40);
		DTest.setBounds(200, 270, 200, 40);
		DExit.setBounds(200, 350, 200, 40);
		//��Ӹ�����ť
		getContentPane().add(DRecite);
		getContentPane().add(DReview);
		getContentPane().add(DTable);
	
		getContentPane().add(DTest);
		getContentPane().add(DExit);
	     getContentPane().add(label1);
		
		this.setBackground(new Color(1188910));
		
		// ���Ƴ���ť���¼�������
		DExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
				});	
		// �����а�ť���¼�������
		DRecite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recite r = new Recite();
				r.init();
				
			}
		});	
		
		// ����ϰ��ť���¼�������
				DReview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Review rev = new Review();
						rev.init();
						
					}
			});	
				
				// ���鿴���ʱ�İ�ť���¼�������
				DTable.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 SeeTable s = new SeeTable();
						  s.init();
					}
					
				});	
				//����ⱳ��Ч�ʵİ�ť����¼�������
				DTest.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Test t = new Test();
						t.init();
					
							
					}
			});
		//�������ڼ���
		addWindowListener(new WindowAdapter() {			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		this.setVisible(true);
		
	}
}
