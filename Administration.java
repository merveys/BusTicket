package DatabaseProject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;


public class Administration extends JFrame {

	private JPanel contentPane;
	private DBConnector db;
	private JTextField txtBegin;
	private JTextField txtEnd;
	private SimpleDateFormat formatter;
	private JTextField txtDBName;
	

	public Administration() {
		setTitle("Administration - Tetra");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		db = new DBConnector();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 0, 51));
		panel.setBounds(0, 0, 591, 335);
		contentPane.add(panel);
		formatter = new SimpleDateFormat("yyyy-MM-dd");

		JButton btnExit = new JButton("\u00C7\u0131k\u0131\u015F");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				db.disconnect();
				dispose();
			}
		});
		btnExit.setBackground(new Color(28, 32, 40));
		btnExit.setForeground(new Color(220, 220, 220));

		txtBegin = new JTextField();
		txtBegin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBegin.setForeground(Color.BLACK);
		txtBegin.setBackground(Color.WHITE);
		txtBegin.setColumns(10);
		
		

		JLabel lblDateBegin = new JLabel("Ba\u015Flang\u0131\u00E7 Tarihi");
		lblDateBegin.setBorder(null);
		lblDateBegin.setForeground(Color.WHITE);
		lblDateBegin.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblDateEnd = new JLabel("Biti\u015F Tarihi");
		lblDateEnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateEnd.setForeground(Color.WHITE);
		lblDateEnd.setBorder(null);

		txtEnd = new JTextField();
		txtEnd.setForeground(Color.BLACK);
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEnd.setColumns(10);
		txtEnd.setBackground(Color.WHITE);

		JButton btnCreate = new JButton("Olu\u015Ftur");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtBegin.getText().isEmpty() || txtEnd.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Boş Alan Bırakmayınız !",
							"Boş Alan !", JOptionPane.ERROR_MESSAGE);
				} else {
					db.connect(DBConnector.defaultDB);
					String begin = txtBegin.getText();
					String end = txtEnd.getText();
					try {
						formatter.parse(begin);
						formatter.parse(end);
						db.initBus(begin, end);
						JOptionPane.showMessageDialog(null, "Sefer Oluşturma Başarılı !",
								"Başarılı !", JOptionPane.INFORMATION_MESSAGE);
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null, "Hatalı Tarih Formatı !",
								"Hata !", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnCreate.setForeground(new Color(220, 220, 220));
		btnCreate.setBackground(new Color(28, 32, 40));

		JLabel lblTopluSeferOluturma = new JLabel("Toplu Sefer Olu\u015Fturma");
		lblTopluSeferOluturma.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTopluSeferOluturma.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopluSeferOluturma.setForeground(Color.WHITE);
		lblTopluSeferOluturma.setBorder(null);

		txtDBName = new JTextField();
		txtDBName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDBName.setBackground(Color.WHITE);
		txtDBName.setColumns(10);
		txtDBName.setText("Tetra");

		JLabel lblDBName = new JLabel("Database Adı Girin");
		lblDBName.setHorizontalAlignment(SwingConstants.CENTER);
		lblDBName.setForeground(Color.WHITE);
		lblDBName.setBorder(null);

		JLabel lblDBCreation = new JLabel("Database Oluşturma");
		lblDBCreation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDBCreation.setForeground(Color.WHITE);
		lblDBCreation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDBCreation.setBorder(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(28, 32, 40));

		JButton btnDB = new JButton("Oluştur");
		btnDB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtDBName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Database Adı Girin !",
							"Hata !", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						db.createDBandComponents(txtDBName.getText());
						JOptionPane.showMessageDialog(null, "Database Başarıyla Oluşturuldu !",
								"Başarılı !", JOptionPane.INFORMATION_MESSAGE);
						
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null, "Database Zaten Mevcut veya Oluşturulamadı !",
								"Hata !", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnDB.setForeground(new Color(220, 220, 220));
		btnDB.setBackground(SystemColor.desktop);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnExit)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTopluSeferOluturma, GroupLayout.PREFERRED_SIZE,
																244, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(lblDateEnd,
																				GroupLayout.PREFERRED_SIZE, 147,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(txtEnd,
																				GroupLayout.PREFERRED_SIZE, 100,
																				GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(lblDateBegin,
																				GroupLayout.PREFERRED_SIZE, 147,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(txtBegin,
																				GroupLayout.PREFERRED_SIZE, 100,
																				GroupLayout.PREFERRED_SIZE))
																.addComponent(btnCreate)))
												.addGap(18)
												.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 10,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblDBCreation, GroupLayout.PREFERRED_SIZE, 244,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panel.createSequentialGroup()
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.TRAILING)
																		.addComponent(btnDB, GroupLayout.PREFERRED_SIZE,
																				78, GroupLayout.PREFERRED_SIZE)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addComponent(lblDBName,
																						GroupLayout.PREFERRED_SIZE, 117,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(txtDBName,
																						GroupLayout.PREFERRED_SIZE, 135,
																						GroupLayout.PREFERRED_SIZE)))
																.addGap(19)))))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(31)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
												.addGap(113))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTopluSeferOluturma, GroupLayout.PREFERRED_SIZE,
																47, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDBCreation, GroupLayout.PREFERRED_SIZE, 47,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtBegin, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDateBegin, GroupLayout.PREFERRED_SIZE, 28,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDBName, GroupLayout.PREFERRED_SIZE, 22,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtDBName, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addGroup(gl_panel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addGap(20)
																				.addComponent(lblDateEnd,
																						GroupLayout.PREFERRED_SIZE, 28,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_panel.createSequentialGroup()
																				.addGap(18)
																				.addComponent(txtEnd,
																						GroupLayout.PREFERRED_SIZE, 32,
																						GroupLayout.PREFERRED_SIZE)))
																.addGap(18)
																.addComponent(btnCreate)
																.addPreferredGap(ComponentPlacement.RELATED, 82,
																		Short.MAX_VALUE)
																.addComponent(btnExit))
														.addGroup(gl_panel.createSequentialGroup()
																.addGap(18)
																.addComponent(btnDB)))
												.addContainerGap()))));
		panel.setLayout(gl_panel);
	}
}