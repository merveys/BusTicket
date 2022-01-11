import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private static String userName = "swiftending";
	private static String password = "111111";
	private Administration admin;
	
	public Admin() {
		setTitle("Administration - Tetra Corporation");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 51));
		panel.setBounds(0, 0, 394, 371);
		contentPane.add(panel);
		
		JLabel lblUsername = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblUsername.setBounds(51, 148, 126, 31);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		
		JFormattedTextField usernameField = new JFormattedTextField();
		usernameField.setBounds(181, 152, 136, 23);
		usernameField.setBackground(new Color(255, 255, 255));
		usernameField.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblUsername_1 = new JLabel("Parola");
		lblUsername_1.setBounds(51, 190, 126, 31);
		lblUsername_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername_1.setForeground(new Color(255, 255, 255));
		lblUsername_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 195, 136, 22);
		passwordField.setBackground(new Color(255, 255, 255));
		
		JButton btnGiris = new JButton("Giri\u015F");
		btnGiris.setBounds(252, 254, 65, 23);
		btnGiris.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(usernameField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Kullanıcı Adı Girin !", 
							  "Boş Kullanıcı Adı !", JOptionPane.ERROR_MESSAGE);
				} else if (Arrays.equals("".toCharArray(), passwordField.getPassword())) {
					JOptionPane.showMessageDialog(null, "Parola Girin !", 
							  "Boş Parola !", JOptionPane.ERROR_MESSAGE);
				} else if(!usernameField.getText().equals(Admin.userName)) {
					JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Parola !", 
							  "Hatalı Girdi !", JOptionPane.ERROR_MESSAGE);
				} else if(!Arrays.equals(Admin.password.toCharArray(), passwordField.getPassword())) {
					JOptionPane.showMessageDialog(null, "Hatalı Kullanıcı Adı veya Parola !", 
							  "Hatalı Girdi !", JOptionPane.ERROR_MESSAGE);
				} else {
					admin = new Administration();
					admin.setVisible(true);
					dispose();
				}
			}
		});
		btnGiris.setForeground(new Color(255, 255, 255));
		btnGiris.setBackground(new Color(28, 32, 40));
		
		JButton btnGeri = new JButton("Geri");
		btnGeri.setBounds(181, 254, 65, 23);
		btnGeri.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnGeri.setForeground(new Color(255, 255, 255));
		btnGeri.setBackground(new Color(28, 32, 40));
		panel.setLayout(null);
		panel.add(lblUsername_1);
		panel.add(lblUsername);
		panel.add(btnGeri);
		panel.add(usernameField);
		panel.add(passwordField);
		panel.add(btnGiris);
		
		JFormattedTextField lblAdmin = new JFormattedTextField();
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setText("Admin Giri\u015Fi");
		lblAdmin.setForeground(new Color(255, 255, 255));
		lblAdmin.setEditable(false);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdmin.setBackground(new Color(153, 0, 51));
		lblAdmin.setBounds(81, 67, 236, 57);
		panel.add(lblAdmin);
	}
}
