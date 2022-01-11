import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.UIManager;

@SuppressWarnings("unused")
public class TetraCorpMain {

	private JFrame frameMain;
	private BuyTicket buy;
	private CheckTicket check;
	private JTextField selection;
	private JTextField infoTxt;
	private Admin admin;
	private RouteStatistics rs;
	private Date date;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TetraCorpMain window = new TetraCorpMain();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TetraCorpMain() {
		//run database here
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMain = new JFrame();
		frameMain.setTitle("Main Screen - Tetra Corporation");
		frameMain.setBounds(100, 100, 700, 519);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMain.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(0, 0, 684, 480);
		frameMain.getContentPane().add(panel);
		
		JFormattedTextField corp = new JFormattedTextField();
		corp.setBorder(null);
		corp.setForeground(new Color(0, 0, 0));
		corp.setBackground(new Color(153, 0, 51));
		corp.setEditable(false);
		corp.setBounds(0, 0, 684, 159);
		corp.setFont(new Font("Monospaced", Font.PLAIN, 27));
		corp.setHorizontalAlignment(SwingConstants.CENTER);
		corp.setText("Tetra Corporation");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(28, 32, 40));
		panel_1.setBounds(0, 160, 684, 320);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(63, 72, 204));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
		);
		
		JComboBox<String> comboSlct = new JComboBox<String>();
		
		comboSlct.setMaximumRowCount(4);
		
		comboSlct.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Bilet Sat\u0131n Alma", "Bilet/Otobüs Sorgulama", "G\u00FCzergah \u0130statistikleri"}));
		comboSlct.setSelectedIndex(0);
		comboSlct.setBackground(new Color(28, 32, 40));
		comboSlct.setForeground(new Color(255, 255, 255));
		JButton btnTmm = new JButton("Tamam");
		btnTmm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(comboSlct.getSelectedIndex() == 1) {
					if(buy == null)
						buy = new BuyTicket();
					if(!buy.isVisible()) {
						buy.setVisible(true);
					}
				} else if(comboSlct.getSelectedIndex() == 2) {
					if(check == null)
						check = new CheckTicket();
					if(!check.isVisible()) {
						check.setVisible(true);
					}
					
				} else if(comboSlct.getSelectedIndex() == 3) {
					if(rs == null)
						rs = new RouteStatistics();
					if(!rs.isVisible()) {
						rs.setVisible(true);
					}
				}
			}
		});
		
		btnTmm.setBackground(new Color(28, 32, 40));
		btnTmm.setForeground(new Color(255, 255, 255));
		JButton btnAdmin = new JButton("Admin Giri\u015Fi");
		btnAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(admin == null)
					admin = new Admin();
				if(!admin.isVisible()) {
					admin.setVisible(true);
				}
			}
		});
		btnAdmin.setBackground(new Color(28, 32, 40));
		btnAdmin.setForeground(new Color(255, 255, 255));
		
		selection = new JTextField();
		selection.setBorder(null);
		selection.setEditable(false);
		selection.setBackground(new Color(63, 72, 204));
		selection.setHorizontalAlignment(SwingConstants.CENTER);
		selection.setForeground(new Color(0, 0, 0));
		selection.setText(" L\u00FCtfen Yapmak \u0130stedi\u011Finiz \u0130\u015Flemi Se\u00E7in");
		selection.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(209, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(selection, 248, 248, 248)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
							.addComponent(comboSlct, 0, 248, Short.MAX_VALUE)
							.addGroup(gl_panel_2.createSequentialGroup()
								.addComponent(btnAdmin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(66)
								.addComponent(btnTmm, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))
					.addGap(227))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(selection, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboSlct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTmm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAdmin, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(null);
		
		infoTxt = new JTextField();
		infoTxt.setBorder(null);
		infoTxt.setText("Otob\u00FCs Bilet Sat\u0131n Alma - Sorgulama Platformu");
		infoTxt.setHorizontalAlignment(SwingConstants.CENTER);
		infoTxt.setForeground(Color.BLACK);
		infoTxt.setEditable(false);
		infoTxt.setColumns(10);
		infoTxt.setBackground(new Color(153, 0, 51));
		infoTxt.setBounds(204, 122, 275, 37);
		panel.add(infoTxt);
		panel.add(corp);
		panel.add(panel_1);
	}
}
