import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;

public class BlockChainAppMain<UserObject> extends JFrame {

	private JPanel contentPane;
    private UserObject userObject;
	/**
	 * Create the frame.
	 */
	public BlockChainAppMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1574, 23);
		desktopPane.add(menuBar);
		init_MenuBar(menuBar, "功能選單");
		init_MenuBar(menuBar,"資料設置");
		init_MenuBar(menuBar,"Help");

		

		
		
		
		
		
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
			Item.addActionListener((e->	creat_MenuWindow(MenuName,e.getActionCommand())));
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
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
