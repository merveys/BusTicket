import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Vector;

import javax.swing.ListSelectionModel;

@SuppressWarnings("unused")
public class BuyTicketSecondary extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DBConnector db;
	private JTextField txtName;
	private JTextField txtBirth;
	private JTextField txtPhone;
	DefaultTableModel tableModel;
	Vector<Vector<String>> queryResult;
	Vector<String> header;

	public BuyTicketSecondary(Vector<String> busList) {
		this.queryResult = this.seperateColumns(busList);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ticket Buying Screen - Tetra Corporation");
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		db = new DBConnector();
		db.connect(DBConnector.defaultDB);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(0, 0, 1264, 729);
		contentPane.add(panel);
		panel.setLayout(null);
		header = new Vector<String>(Arrays.asList(new String[] { "Otobüs Kodu", "Kalkış Yeri", "Varış Yeri",
				"Kalkış Tarihi", "Kalkış Saati", "Bulunan Yolcu", "Bilet Fiyatı (TL)" }));
		table = new JTable(queryResult, header) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.getTableHeader().setReorderingAllowed(false);
		table.setBackground(new Color(255, 255, 204));
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(42, 30, 1180, 272);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ListSelectionModel model = table.getSelectionModel();
		table.setShowGrid(true);

		panel.add(pane);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(24, 356, 1218, 297);
		panel.add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		panel_2.setBounds(2, 2, 1214, 293);
		panel_1.add(panel_2);

		JLabel lblName = new JLabel("Ad Soyad (Min. 5 Karakter)");
		lblName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblName.setFont(new Font("Calibri", Font.BOLD, 13));
		lblName.setForeground(new Color(0, 0, 0));

		JLabel lblPhone = new JLabel("Telefon No (0 olmadan 10 Karakter)");
		lblPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Calibri", Font.BOLD, 13));

		JLabel lblBirth = new JLabel("Do\u011Fum Tarihi (YYYY-MM-DD Formatında)");
		lblBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBirth.setForeground(Color.BLACK);
		lblBirth.setFont(new Font("Calibri", Font.BOLD, 13));

		txtName = new JTextField();
		txtName.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtName.setForeground(Color.BLACK);
		txtName.setBackground(Color.WHITE);
		txtName.setColumns(10);

		txtBirth = new JTextField();
		txtBirth.setForeground(Color.BLACK);
		txtBirth.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtBirth.setColumns(10);
		txtBirth.setBackground(Color.WHITE);

		txtPhone = new JTextField();
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBackground(Color.WHITE);

		JLabel lblGender = new JLabel("Cinsiyet");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Calibri", Font.BOLD, 13));

		ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton rdbtnKadn = new JRadioButton("Kad\u0131n");
		rdbtnKadn.setForeground(new Color(0, 0, 0));
		rdbtnKadn.setBackground(new Color(204, 204, 204));

		JRadioButton rdbtnErkek = new JRadioButton("Erkek");
		rdbtnErkek.setForeground(new Color(0, 0, 0));
		rdbtnErkek.setBackground(new Color(204, 204, 204));

		buttonGroup.add(rdbtnKadn);
		buttonGroup.add(rdbtnErkek);

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGap(211)
												.addComponent(lblName, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_panel_2.createSequentialGroup()
												.addContainerGap()
												.addComponent(lblPhone, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGap(51)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 163,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 163,
												GroupLayout.PREFERRED_SIZE))
								.addGap(92)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 212,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBirth, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE))
								.addGap(35)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(txtBirth, GroupLayout.PREFERRED_SIZE, 163,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGap(17)
												.addComponent(rdbtnKadn)
												.addGap(18)
												.addComponent(rdbtnErkek)))
								.addGap(154)));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(66)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 58,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBirth, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
										.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtBirth, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
												.addGap(6)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 48,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(rdbtnKadn)
														.addComponent(rdbtnErkek)))
										.addGroup(gl_panel_2.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
														.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 69,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(89, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);

		JButton btnConfirm = new JButton("Tamamla");
		btnConfirm.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = { "Evet", "Hayır" };

				if (!(table.getSelectedRow() >= 0)) {
					JOptionPane.showMessageDialog(null, "Otobüs Seçin !",
							"Otobüs Seçilmedi !", JOptionPane.ERROR_MESSAGE);
				} else if (Integer.parseInt(queryResult.get(table.getSelectedRow()).get(5)) >= 10) {
					JOptionPane.showMessageDialog(null, "Boş Alan Yok",
							"Otobüs Dolu !", JOptionPane.ERROR_MESSAGE);
				} else if (!rdbtnKadn.isSelected() && !rdbtnErkek.isSelected() || txtName.getText().length() == 0
						|| txtBirth.getText().length() == 0 || txtPhone.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Eksik Bilgi Girdiniz !", "Hatalı Girdi !",
							JOptionPane.ERROR_MESSAGE);
				} else if (txtName.getText().length() < 5) {
					JOptionPane.showMessageDialog(null, "Ad Soyad Kısmı En Az 5 Karakter Olmalı !",
							"Hatalı Girdi !", JOptionPane.ERROR_MESSAGE);

				} else if (!(txtPhone.getText().length() == 10) || !txtPhone.getText().matches("[0-9]+")) {
					JOptionPane.showMessageDialog(null, "Telefon Başında 0 Olmadan Yalnızca 10 Haneli Rakam Olmalı !",
							"Hatalı Girdi !", JOptionPane.ERROR_MESSAGE);

				} else if (!validDateFormat(txtBirth.getText())) {
					JOptionPane.showMessageDialog(null, "YYYY-MM-DD Formatında Doğum Tarihi Girin !",
							"Hatalı Girdi !", JOptionPane.ERROR_MESSAGE);
				} else if (rdbtnKadn.isSelected()) {
					int n = JOptionPane.showOptionDialog(null,
							"Satın Almayı Onaylıyor Musunuz ?",
							"Onay Ekranı",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, options, options[1]);
					if (n == 0) {
						db.createPassenger(txtName.getText(), "K", txtBirth.getText(), txtPhone.getText(),
								Integer.parseInt(queryResult.get(table.getSelectedRow()).get(0)));
						JOptionPane.showMessageDialog(null,
								"Bilet Satın Alındı ! \nBilet ID: " + db.getLastPassenger().get(0));
						db.disconnect();
						dispose();
					}

				} else if (rdbtnErkek.isSelected()) {
					int n = JOptionPane.showOptionDialog(null,
							"Satın Almayı Onaylıyor Musunuz ?",
							"Onay Ekranı",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, options, options[1]);
					if (n == 0) {
						db.createPassenger(txtName.getText(), "E", txtBirth.getText(), txtPhone.getText(),
								Integer.parseInt(queryResult.get(table.getSelectedRow()).get(0)));
						JOptionPane.showMessageDialog(null,
								"Bilet Satın Alındı ! \nBilet ID: " + db.getLastPassenger().get(0));
						db.disconnect();
						dispose();
					}
				}

			}
		});
		btnConfirm.setBackground(new Color(28, 32, 40));
		btnConfirm.setForeground(new Color(220, 220, 220));
		btnConfirm.setBounds(1133, 664, 89, 23);
		panel.add(btnConfirm);

		JButton btnBack = new JButton("\u0130ptal");
		btnBack.addActionListener(e -> {
			this.db.disconnect();
			this.dispose();
		});

		btnBack.setForeground(new Color(220, 220, 220));
		btnBack.setBackground(new Color(28, 32, 40));
		btnBack.setBounds(42, 664, 89, 23);
		panel.add(btnBack);
	}

	private boolean validDateFormat(String date) {
		if (date == null)
			return false;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			Date d = format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	private Vector<Vector<String>> seperateColumns(Vector<String> busList) {
		Vector<Vector<String>> seperated = new Vector<Vector<String>>();
		for (int row = 0; row != busList.size(); ++row) {
			seperated.add(row, new Vector<String>());
			Collections.addAll(seperated.get(row), busList.get(row).split(" "));
		}
		return seperated;
	}
}
