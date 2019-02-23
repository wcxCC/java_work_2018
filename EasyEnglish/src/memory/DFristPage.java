package memory;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


//@SuppressWarnings("serial")
public class DFristPage extends JFrame {
	public DFristPage() {
		init();
	}
	// TODO 自动生成的方法存根
	JLabel label1;		//背景标签
	JLabel label2;		//显示版本信息
	private JButton DRecite; 	//背诵的按钮
	private JButton DReview;	//复习的按钮
	private JButton DTable;		//查看单词表的按钮
	private JButton DTest;		//检测背诵效率的按钮
	private JButton DExit;		//退出的按钮
	String version = "版本1.0	\n开发者：吴承轩\n学号：8002117004";				//用于显示版本信息

	public void init()
	{
		this.setTitle("EazyEnglish");
		
		getContentPane().setLayout(null);
		this.setBounds(350, 150, 600, 500);
		
		DRecite = new JButton("开始背单词");		//建按钮
		DReview = new JButton("复习单词");
		DTable = new JButton("查看单词表");
		DTest = new JButton("背诵效率测试");
		DExit = new JButton("退出");
		
		
		
		
		 ImageIcon background = new ImageIcon();  
	        // 把背景图片显示在一个标签里面  
	        label1 = new JLabel(background);  
	        // 把标签的大小位置设置为图片刚好填充整个面板  
	         label1.setBounds(0, 0, this.getWidth(), this.getHeight());  
	        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
	        JPanel imagePanel = (JPanel) this.getContentPane();  
	        imagePanel.setOpaque(false);  
	        // 把背景图片添加到分层窗格的最底层作为背景  
	       // this.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));  
	       
	        
	        label2 = new JLabel(version);		//新建标签		
	        
	        label2.setBounds( this.getWidth()-450, this.getHeight()-150,500,200 ); 
	        
	    //    label2.setBackground(new Color( 11976644));
	        
	        getContentPane().add(label2);
	        label2.setFont(new Font("宋体", Font.PLAIN,  16));
	        label2.setForeground(Color.white);			//设置版本信息的字体颜色
	   
	   
		
		
		
		
		
		
		
		DRecite.setBounds(200, 30, 200, 40);
		DReview.setBounds(200, 110, 200, 40);
		DTable.setBounds(200, 190, 200, 40);
		DTest.setBounds(200, 270, 200, 40);
		DExit.setBounds(200, 350, 200, 40);
		//添加各个按钮
		getContentPane().add(DRecite);
		getContentPane().add(DReview);
		getContentPane().add(DTable);
	
		getContentPane().add(DTest);
		getContentPane().add(DExit);
	     getContentPane().add(label1);
		
		this.setBackground(new Color(1188910));
		
		// 给推出按钮加事件监听器
		DExit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
				});	
		// 给背诵按钮加事件监听器
		DRecite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recite r = new Recite();
				r.init();
				
			}
		});	
		
		// 给复习按钮加事件监听器
				DReview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Review rev = new Review();
						rev.init();
						
					}
			});	
				
				// 给查看单词表的按钮加事件监听器
				DTable.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 SeeTable s = new SeeTable();
						  s.init();
					}
					
				});	
				//给检测背诵效率的按钮添加事件监听器
				DTest.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Test t = new Test();
						t.init();
					
							
					}
			});
		//建立窗口监听
		addWindowListener(new WindowAdapter() {			
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
		this.setVisible(true);
		
	}
}
