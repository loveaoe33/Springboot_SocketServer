import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JRadioButton;

public class BlockChainLogin extends JFrame {

	private JPanel contentPane;
	private String switchRadio="";

	/**
	 * Create the frame.
	 */
	public BlockChainLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setOpaque(false);
		desktopPane.setForeground(new Color(119, 136, 153));
		desktopPane.setLayout(null);
		contentPane.add(desktopPane);
	
		JButton nodeButton = new JButton("登入");
		nodeButton.setBounds(349, 118, 87, 46);
		nodeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
                if(switchRadio.equals("")) {
                	JOptionPane.showConfirmDialog(nodeButton, "請先選擇網路", "Confirm",JOptionPane.DEFAULT_OPTION);
                	return;
                }
				if (contractCheck().equals("True")) {
				
					
					System.out.println("已存在帳號");
					System.out.println("已選擇"+switchRadio);
					callAccount();


				} else if(contractCheck().equals("Process")){
					System.out.println("帳號審核中...");
				}else {
					int result = JOptionPane.showConfirmDialog(nodeButton, "帳號不存在,註冊合約帳號?", "Confirm",
							JOptionPane.YES_NO_OPTION);
   
					if (result == JOptionPane.YES_OPTION) {
						System.out.println("User chose YES");

					} else if (result == JOptionPane.NO_OPTION) {

						System.out.println("User chose no");

					}
				}
			}

		});
		desktopPane.add(nodeButton);

		JLabel accountLabel = new JLabel("合約帳號:");
		accountLabel.setBounds(188, 100, 77, 34);
		accountLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		desktopPane.add(accountLabel);

		JLabel passwordLabel = new JLabel("合約密碼:");
		passwordLabel.setBounds(188, 165, 77, 34);
		passwordLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		desktopPane.add(passwordLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(188, 128, 129, 31);
		desktopPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(188, 189, 129, 25);
		desktopPane.add(textArea_1);

		JButton btnNewButton_1 = new JButton("SERVER節點檢查");
		btnNewButton_1.setBounds(349, 179, 149, 46);
		desktopPane.add(btnNewButton_1);
		
		JRadioButton eth1Button = new JRadioButton("私有鏈1.0");
	
		JRadioButton  eth2Button = new JRadioButton("私有鏈2.0");
		ButtonGroup group=new ButtonGroup();
		group.add(eth1Button);
		group.add(eth2Button);
		
		eth1Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchRadio="私有鏈1.0";
			}
			
			
		});
		
		eth2Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switchRadio="私有鏈2.0";
			}
			
			
		});
		

		eth1Button.setBounds(188, 244, 107, 23);
		eth2Button.setBounds(349, 243, 107, 25);
		desktopPane.add(eth1Button);
		desktopPane.add(eth2Button);
	}
	
    private void callAccount() {
    	JOptionPane.showConfirmDialog(contentPane, "test","test",JOptionPane.INFORMATION_MESSAGE);
    	 
    }
	private String contractCheck() {

		return "True";
	}
 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlockChainLogin frame = new BlockChainLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
