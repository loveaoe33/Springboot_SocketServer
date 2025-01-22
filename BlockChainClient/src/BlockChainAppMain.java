import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.Color;


public class BlockChainAppMain<UserObject> extends JFrame {

	private JPanel contentPane;
    private UserObject userObject;
    private JTextField toPriceText;
    private JTextField priceAccountText;
	/**
	 * Create the frame.
	 */
	public BlockChainAppMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1574, 23);
		desktopPane.add(menuBar);
		init_MenuBar(menuBar, "功能選單");
		init_MenuBar(menuBar,"資料設置");
		init_MenuBar(menuBar,"Help");
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 238, 343, 2);
		desktopPane.add(separator);
		
		JButton btnNewButton = new JButton("轉帳");
		btnNewButton.setFont(new Font("標楷體", Font.PLAIN, 16));
		btnNewButton.setBounds(264, 477, 79, 23);
		desktopPane.add(btnNewButton);
		
		JLabel toPrice = new JLabel("轉帳金額:");
		toPrice.setFont(new Font("標楷體", Font.PLAIN, 14));
		toPrice.setBounds(10, 313, 68, 15);
		desktopPane.add(toPrice);
		
		JLabel priceRemark02 = new JLabel("轉帳備註:");
		priceRemark02.setFont(new Font("標楷體", Font.PLAIN, 14));
		priceRemark02.setBounds(10, 350, 68, 15);
		desktopPane.add(priceRemark02);
		
		toPriceText = new JTextField();
		toPriceText.setBounds(78, 310, 265, 21);
		desktopPane.add(toPriceText);
		toPriceText.setColumns(10);
		
		JLabel priceAccount = new JLabel("轉帳帳戶:");
		priceAccount.setFont(new Font("標楷體", Font.PLAIN, 14));
		priceAccount.setBounds(10, 280, 68, 15);
		desktopPane.add(priceAccount);
		
		priceAccountText = new JTextField();
		priceAccountText.setColumns(10);
		priceAccountText.setBounds(80, 279, 263, 21);
		desktopPane.add(priceAccountText);
		
		JLabel accountName = new JLabel("用戶名:");
		accountName.setFont(new Font("標楷體", Font.PLAIN, 14));
		accountName.setBounds(10, 52, 68, 15);
		desktopPane.add(accountName);
		
		JLabel accountPrice = new JLabel("用戶餘額:");
		accountPrice.setFont(new Font("標楷體", Font.PLAIN, 14));
		accountPrice.setBounds(10, 90, 68, 15);
		desktopPane.add(accountPrice);
		
		JLabel accountLevel = new JLabel("用戶權限:");
		accountLevel.setFont(new Font("標楷體", Font.PLAIN, 14));
		accountLevel.setBounds(10, 128, 68, 15);
		desktopPane.add(accountLevel);
		
		JLabel lastTransDate = new JLabel("最後交易日:");
		lastTransDate.setFont(new Font("標楷體", Font.PLAIN, 14));
		lastTransDate.setBounds(10, 164, 79, 15);
		desktopPane.add(lastTransDate);
		
		JLabel lastTransPrice = new JLabel("最後轉帳金額:");
		lastTransPrice.setFont(new Font("標楷體", Font.PLAIN, 14));
		lastTransPrice.setBounds(10, 199, 101, 15);
		desktopPane.add(lastTransPrice);
		
		JLabel priceRemark01 = new JLabel("交易備註:");
		priceRemark01.setFont(new Font("標楷體", Font.PLAIN, 14));
		priceRemark01.setBounds(154, 52, 68, 15);
		desktopPane.add(priceRemark01);
		
		TextArea priceRemark01Area = new TextArea();
		priceRemark01Area.setBounds(154, 73, 189, 159);
		desktopPane.add(priceRemark01Area);
		
		TextArea priceRemark02Area = new TextArea();
		priceRemark02Area.setBounds(78, 337, 265, 134);
		desktopPane.add(priceRemark02Area);
		
		JLabel accountNamelabel = new JLabel("loveaoe33");
		accountNamelabel.setForeground(Color.RED);
		accountNamelabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		accountNamelabel.setBounds(10, 75, 68, 15);
		desktopPane.add(accountNamelabel);
		
		JLabel accountPricelabel = new JLabel("5.000");
		accountPricelabel.setForeground(Color.RED);
		accountPricelabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		accountPricelabel.setBounds(10, 115, 68, 15);
		desktopPane.add(accountPricelabel);
		
		JLabel accountLevellabel = new JLabel("一般");
		accountLevellabel.setForeground(Color.RED);
		accountLevellabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		accountLevellabel.setBounds(10, 148, 68, 15);
		desktopPane.add(accountLevellabel);
		
		JLabel lastTransDatelabel = new JLabel("20250122");
		lastTransDatelabel.setForeground(Color.RED);
		lastTransDatelabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		lastTransDatelabel.setBounds(10, 181, 68, 15);
		desktopPane.add(lastTransDatelabel);
		
		JLabel lastTransPricelabel = new JLabel("+50.000");
		lastTransPricelabel.setForeground(Color.RED);
		lastTransPricelabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		lastTransPricelabel.setBounds(10, 220, 68, 15);
		desktopPane.add(lastTransPricelabel);
		init_textArea();
		
		

		
		
		
		
		
	}
	public void init_textArea() {  //初始化區塊區資訊與按鈕功能
		JTextArea area=new JTextArea();
		JScrollPane textscrollPane=new JScrollPane(area);
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
		JButton areaNewButton=new JButton("查詢最新區塊");
		areaNewButton.addActionListener(e->System.out.println("按鈕1"));
		JButton areaAllButton=new JButton("查詢所有區塊");
		areaAllButton.addActionListener(e->System.out.println("按鈕2"));
		JButton contractAddressButton=new JButton("查看合約地址");
		contractAddressButton.addActionListener(e->System.out.println("按鈕3"));
		JButton transactionHistory=new JButton("查看交易紀錄");
		transactionHistory.addActionListener(e->System.out.println("按鈕4"));
		JButton nodePrice=new JButton("節點餘額查詢");
		nodePrice.addActionListener(e->System.out.println("按鈕5"));
		JButton nodeWallet=new JButton("錢包位置查詢");
		nodeWallet.addActionListener(e->System.out.println("按鈕6"));


		buttonPanel.add(areaNewButton );
		buttonPanel.add(areaAllButton );
		buttonPanel.add(contractAddressButton );
		buttonPanel.add(transactionHistory );

		buttonPanel.add(nodePrice );

		buttonPanel.add(nodeWallet );


		JSplitPane jsPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,textscrollPane,buttonPanel);
		jsPane.setDividerLocation(355);
		jsPane.setDividerSize(10);
		contentPane.add(jsPane);
		
		
	}
	public void init_actionListen() {
		
		
	}
	
	
	public void init_MenuBar(JMenuBar Tools,String Item) {
		if(Item.equals("功能選單")) {
			creat_Menu(Tools,new String[] {"功能1","功能2","功能3"},"功能選單");

			
		}else if(Item.equals("資料設置")) {
			creat_Menu(Tools,new String[] {"功能1","功能2","功能3"},"資料設置");

			
		}else if(Item.equals("Help")) {
			creat_Menu(Tools,new String[] {"功能1","功能2","功能3"},"Help");

			
		}

		
	}
	
	private void creat_Menu(JMenuBar menu,String []Items ,String MenuName) {  //初始化menu
		JMenu menus =new JMenu(MenuName);
		menu.add(menus);
		for(String menuItem: Items) {
			JMenuItem Item=new JMenuItem(menuItem);
			menus.add(Item);
			Item.addActionListener(e->	creat_MenuWindow(MenuName,e.getActionCommand()));
		}
		
	}
	
	private void creat_MenuWindow(String MenuName,String MenuFunciont) { //選擇開啟視窗
		
      JOptionPane.showConfirmDialog(contentPane, MenuFunciont+MenuName);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlockChainAppMain frame = new BlockChainAppMain();
					frame.setVisible(true);
//					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
