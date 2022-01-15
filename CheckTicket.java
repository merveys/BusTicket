import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Vector;

@SuppressWarnings("unused")
public class CheckTicket extends JFrame {

	private JPanel contentPane;
	private DBConnector db;
	private JTextField textField;
	private CheckTicketSecondary chk2nd;
	private BusInfo info;

	public CheckTicket() {
		setTitle("Selection - Tetra Corporation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		info = null;
		chk2nd = null;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		db = new DBConnector();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 554, 390);
		contentPane.add(panel);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setBackground(new Color(28, 32, 40));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setModel(
				new DefaultComboBoxModel<String>(new String[] { "", "Bilet Sorgulama", "Otob\u00FCs Sorgulama" }));
		comboBox.setSelectedIndex(0);

		JLabel lbl1st = new JLabel("Yapmak \u0130stedi\u011Finiz \u0130\u015Flemi Se\u00E7iniz");
		lbl1st.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1st.setFont(new Font("Calibri", Font.BOLD, 15));
		lbl1st.setForeground(new Color(0, 0, 0));

		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 0));
		textField.setBackground(new Color(255, 255, 255));
		textField.setColumns(10);

		JLabel lbl2nd = new JLabel("Bilet veya Otob\u00FCs ID Giriniz");
		lbl2nd.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2nd.setForeground(Color.BLACK);
		lbl2nd.setFont(new Font("Calibri", Font.BOLD, 15));

		JButton btnNext = new JButton("\u0130leri");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				db.connect(DBConnector.defaultDB);
				Vector<String> result = null;
				if (comboBox.getSelectedIndex() == 1 && textField.getText().length() != 0) {
					result = db.getTicketDetails(Integer.parseInt(textField.getText()));
					if (result.size() > 0) {
						if (chk2nd == null || !chk2nd.isVisible()) {
							chk2nd = new CheckTicketSecondary(
									db.getTicketDetails(Integer.parseInt(textField.getText())));
							db.disconnect();
							chk2nd.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Yolcu Bulunamadı !", "Hata", JOptionPane.ERROR_MESSAGE);
					}
				} else if (comboBox.getSelectedIndex() == 2 && textField.getText().length() != 0) {
					result = db.getBusInfo(Integer.parseInt(textField.getText()));
					if (result.size() > 0) {
						if (info == null || !info.isVisible()) {
							info = new BusInfo(db.getBusInfo(Integer.parseInt(textField.getText())));
							db.disconnect();
							info.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Otobüs Bulunamadı !", "Hata", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNext.setBackground(new Color(28, 32, 40));
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnBack = new JButton("Geri");
		btnBack.addActionListener(e -> {
			this.dispose();
		});
		btnBack.setBackground(new Color(28, 32, 40));
		btnBack.setForeground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addContainerGap(175, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lbl2nd, GroupLayout.PREFERRED_SIZE, 203,
														GroupLayout.PREFERRED_SIZE)
												.addContainerGap())
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(comboBox, 0, 203, Short.MAX_VALUE)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(textField, 203, 203, 203)
																.addComponent(lbl1st)))
												.addGap(176))))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addContainerGap(207, Short.MAX_VALUE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addGap(203)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(79)
								.addComponent(lbl1st)
								.addGap(18)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(33)
								.addComponent(lbl2nd, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnBack)
										.addComponent(btnNext))
								.addContainerGap(80, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);
	}
}
