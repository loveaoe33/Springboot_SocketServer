import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.util.JapaneseCalendar;

import javax.swing.JDesktopPane;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.util.Date;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.TextArea;


public class BlockChainAdmin<SingleClassMethod> extends JFrame {

	private JPanel contentPane;
	private SingleClassMethod singleClassMethod;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlockChainAdmin frame = new BlockChainAdmin();

		
			 

			     
			        
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void add(JapaneseCalendar calendar, String center) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the frame.
	 */
	public BlockChainAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 937, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		        
		        
		
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 44, 217, 208);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(237, 44, 217, 208);
		contentPane.add(list_1);
		
		JList list_1_1 = new JList();
		list_1_1.setBounds(464, 44, 217, 208);
		contentPane.add(list_1_1);
		
		JList list_1_1_1 = new JList();
		list_1_1_1.setBounds(691, 44, 217, 208);
		contentPane.add(list_1_1_1);
		
		JLabel lblNewLabel = new JLabel("本月申請:");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 19, 82, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("尚未審核:");
		lblNewLabel_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(237, 19, 73, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號查詢:");
		lblNewLabel_1_1.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(464, 19, 63, 15);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("日期查詢:");
		lblNewLabel_1_2.setFont(new Font("標楷體", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(692, 19, 73, 15);
		contentPane.add(lblNewLabel_1_2);
		
		TextField textField = new TextField();
		textField.setBounds(527, 15, 154, 23);
		contentPane.add(textField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 299, 898, 2);
		
	
        
        
		contentPane.add(separator);
		
		
		JSeparator separator_1 = new JSeparator(SwingConstants.VERTICAL);
		separator_1.setBounds(463, 299, 2, 263);
		contentPane.add(separator_1);
		
		table = new JTable();
		table.setBounds(464, 554, 457, -242);
		contentPane.add(table);
		
		Button acceptButton = new Button("Accept");
		acceptButton.setFont(new Font("標楷體", Font.BOLD, 14));
		acceptButton.setActionCommand("");
		acceptButton.setBounds(378, 441, 76, 23);
		contentPane.add(acceptButton);
		
		Button rejectButton = new Button("Reject");
		rejectButton.setFont(new Font("標楷體", Font.BOLD, 14));
		rejectButton.setBounds(378, 474, 76, 23);
		contentPane.add(rejectButton);
		
		Button updateButton = new Button("Update");
		updateButton.setFont(new Font("標楷體", Font.BOLD, 14));
		updateButton.setBounds(378, 503, 76, 23);
		contentPane.add(updateButton);
		
		Button cancelButton = new Button("Cancel");
		cancelButton.setFont(new Font("標楷體", Font.BOLD, 14));
		cancelButton.setBounds(378, 529, 76, 23);
		contentPane.add(cancelButton);
		
		JLabel lblNewLabel_2 = new JLabel("ResAccount:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 328, 122, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ResPassword:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(10, 377, 122, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("ResLevel:");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(10, 463, 122, 15);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("ResDate:");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(10, 511, 122, 15);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("ResDepart:");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBounds(10, 420, 122, 15);
		contentPane.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("ResRemark:");
		lblNewLabel_2_3_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_2.setBounds(188, 377, 122, 15);
		contentPane.add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("AccountPrice:");
		lblNewLabel_2_3_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1.setBounds(188, 328, 122, 15);
		contentPane.add(lblNewLabel_2_3_1_1);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(10, 348, 122, 23);
		contentPane.add(textField_1);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(10, 398, 122, 23);
		contentPane.add(textField_2);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(10, 441, 122, 23);
		contentPane.add(textField_3);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(10, 482, 122, 23);
		contentPane.add(textField_4);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(10, 529, 122, 23);
		contentPane.add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(188, 349, 122, 23);
		contentPane.add(textField_6);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(188, 398, 184, 154);
		contentPane.add(textArea);
	
	}
}
