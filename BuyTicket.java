import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.SpringLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Vector;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelListener;
import java.text.SimpleDateFormat;
import java.awt.event.MouseWheelEvent;

@SuppressWarnings("unused")
public class BuyTicket extends JFrame {

	private static final long serialVersionUID = -6309682188013089803L;
	private JPanel contentPane;
	private BuyTicketSecondary secondaryWindow;
	private DBConnector db;

	public BuyTicket() {
		setTitle("Search Seat - Tetra Corporation");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.db = new DBConnector();
		secondaryWindow = null;

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 534, 511);
		panel.setBackground(new Color(153, 153, 204));
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 535, 144);
		panel_1.setBackground(new Color(102, 102, 153));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		Label label = new Label("Koltuk Bul");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Cambria Math", Font.BOLD, 24));
		label.setAlignment(Label.CENTER);
		panel_1.add(label, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 102, 153));
		panel_2.setBounds(10, 155, 515, 345);
		panel.add(panel_2);

		JLabel lblDate = new JLabel("Tarih");
		lblDate.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDate.setFont(new Font("Cambria Math", Font.BOLD, 12));
		lblDate.setForeground(new Color(0, 0, 0));

		JLabel lblRoute = new JLabel("G\u00FCzegah");
		lblRoute.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRoute.setForeground(Color.BLACK);
		lblRoute.setFont(new Font("Cambria Math", Font.BOLD, 12));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 102, 153));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(60)
								.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRoute, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(109, Short.MAX_VALUE)));
		gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
								.addGap(78)
								.addComponent(lblDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(114)
								.addComponent(lblRoute, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
								.addGap(123))
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE));

		SpinnerDateModel model = new SpinnerDateModel();
		JSpinner spinner = new JSpinner(model);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy.MM.dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setMaximumRowCount(7);
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "\u0130stanbul - Erzurum", "\u0130stanbul - \u00C7orum", "Erzurum - \u00C7orum",
						"Erzurum - \u0130stanbul", "\u00C7orum - Erzurum", "\u00C7orum - \u0130stanbul" }));
		comboBox.setSelectedIndex(0);

		JButton btnNext = new JButton("Tamam");
		btnNext.setForeground(new Color(220, 220, 220));
		btnNext.setBackground(new Color(28, 32, 40));
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String spinVal = formatter.format(spinner.getValue());
				int year = Integer.parseInt(spinVal.substring(0, 4));
				if (year < 1900 || year >= 2079) {
					JOptionPane.showMessageDialog(null, "Geçerli Bir Tarih Girin !",
							"Hatalı Girdi !", JOptionPane.ERROR_MESSAGE);
				} else if (comboBox.getSelectedIndex() != 0) {

					db.connect(DBConnector.defaultDB);
					String dest = "", arrival = "", date = "";
					if (comboBox.getSelectedIndex() == 1) {
						dest = "İstanbul";
						arrival = "Erzurum";
						// actions for database
					} else if (comboBox.getSelectedIndex() == 2) {
						dest = "İstanbul";
						arrival = "Çorum";
						// actions for database
					} else if (comboBox.getSelectedIndex() == 3) {
						dest = "Erzurum";
						arrival = "Çorum";
						// actions for database
					} else if (comboBox.getSelectedIndex() == 4) {
						dest = "Erzurum";
						arrival = "İstanbul";

					} else if (comboBox.getSelectedIndex() == 5) {
						dest = "Çorum";
						arrival = "Erzurum";
					} else if (comboBox.getSelectedIndex() == 6) {
						dest = "Çorum";
						arrival = "İstanbul";
					}
					Vector<String> busList = db.getBusList(dest, arrival, spinVal);
					if (busList.size() != 0) {
						db.disconnect();
						if (secondaryWindow == null || !secondaryWindow.isVisible()) {
							secondaryWindow = new BuyTicketSecondary(busList);
							secondaryWindow.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Belirtilen Tarihlerde Otobüs Bulunamadı !",
								"Kayıt Bulunamadı !", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		JButton btnBack = new JButton("\u0130ptal");
		btnBack.setForeground(new Color(220, 220, 220));
		btnBack.setBackground(new Color(28, 32, 40));
		btnBack.addActionListener(e -> {
			this.dispose();
		});

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_panel_4.createSequentialGroup()
												.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 79,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(spinner, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														132, Short.MAX_VALUE)))
								.addContainerGap(35, Short.MAX_VALUE)));
		gl_panel_4.setVerticalGroup(
				gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
								.addGap(69)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(113)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addGap(36)));
		panel_4.setLayout(gl_panel_4);
		panel_2.setLayout(gl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(72, 61, 139));
		panel_3.setBounds(7, 152, 521, 351);
		panel.add(panel_3);

	}
}
