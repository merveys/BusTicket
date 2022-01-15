import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class RouteStatistics extends JFrame {

	private JPanel contentPane;
	private JTextField totalPassenger;
	private JTextField profit;
	private JLabel lblPassenger;
	private JLabel lblProfit;
	private DBConnector db;
	private Vector<String> routeInfo;

	public RouteStatistics() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 450);
		setTitle("Terminal Info - Tetra Corporation");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		db = new DBConnector();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 56, 64));
		panel.setBounds(0, 0, 444, 421);
		contentPane.add(panel);

		JLabel lblRoute = new JLabel("G\u00FCzergah Se\u00E7in");
		lblRoute.setForeground(Color.WHITE);
		lblRoute.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoute.setBorder(null);

		lblPassenger = new JLabel("Yolcu Say\u0131s\u0131");
		lblPassenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassenger.setForeground(Color.WHITE);
		lblPassenger.setBorder(null);
		lblPassenger.setVisible(false);

		lblProfit = new JLabel("Kazan\u00E7");
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfit.setForeground(Color.WHITE);
		lblProfit.setBorder(null);
		lblProfit.setVisible(false);

		totalPassenger = new JTextField();
		profit = new JTextField();
		db.connect(DBConnector.defaultDB);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 0) {
					profit.setText("");
					totalPassenger.setText("");
					lblPassenger.setVisible(false);
					lblProfit.setVisible(false);
					profit.setVisible(false);
					totalPassenger.setVisible(false);
				} else if (comboBox.getSelectedIndex() == 1) {
					routeInfo = db.getRouteInfo("İSTANBUL", "ERZURUM");
					lblPassenger.setVisible(true);
					lblProfit.setVisible(true);
					totalPassenger.setText(routeInfo.get(0));
					profit.setText(routeInfo.get(1) + " TL");
					profit.setVisible(true);
					totalPassenger.setVisible(true);

				} else if (comboBox.getSelectedIndex() == 2) {
					routeInfo = db.getRouteInfo("İSTANBUL", "ÇORUM");
					lblPassenger.setVisible(true);
					lblProfit.setVisible(true);
					totalPassenger.setText(routeInfo.get(0));
					profit.setText(routeInfo.get(1) + " TL");
					profit.setVisible(true);
					totalPassenger.setVisible(true);
				} else if (comboBox.getSelectedIndex() == 3) {
					routeInfo = db.getRouteInfo("ERZURUM", "ÇORUM");
					lblPassenger.setVisible(true);
					lblProfit.setVisible(true);
					totalPassenger.setText(routeInfo.get(0));
					profit.setText(routeInfo.get(1) + " TL");
					profit.setVisible(true);
					totalPassenger.setVisible(true);
				} else if (comboBox.getSelectedIndex() == 4) {
					routeInfo = db.getRouteInfo("ERZURUM", "İSTANBUL");
					lblPassenger.setVisible(true);
					lblProfit.setVisible(true);
					totalPassenger.setText(routeInfo.get(0));
					profit.setText(routeInfo.get(1) + " TL");
					profit.setVisible(true);
					totalPassenger.setVisible(true);
				} else if (comboBox.getSelectedIndex() == 5) {
					routeInfo = db.getRouteInfo("ÇORUM", "ERZURUM");
					lblPassenger.setVisible(true);
					lblProfit.setVisible(true);
					totalPassenger.setText(routeInfo.get(0));
					profit.setText(routeInfo.get(1) + " TL");
					profit.setVisible(true);
					totalPassenger.setVisible(true);
				} else if (comboBox.getSelectedIndex() == 6) {
					routeInfo = db.getRouteInfo("ÇORUM", "İSTANBUL");
					lblPassenger.setVisible(true);
					lblProfit.setVisible(true);
					totalPassenger.setText(routeInfo.get(0));
					profit.setText(routeInfo.get(1) + " TL");
					profit.setVisible(true);
					totalPassenger.setVisible(true);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "\u0130stanbul - Erzurum", "\u0130stanbul - \u00C7orum", "Erzurum - \u00C7orum",
						"Erzurum - \u0130stanbul", "\u00C7orum - Erzurum", "\u00C7orum - \u0130stanbul" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBackground(new Color(28, 32, 40));
		comboBox.setForeground(new Color(220, 220, 220));

		JLabel lblHeader = new JLabel("G\u00FCzergah \u0130statistikleri");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setBorder(null);

		totalPassenger = new JTextField();
		totalPassenger.setForeground(Color.BLACK);
		totalPassenger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		totalPassenger.setBackground(Color.WHITE);
		totalPassenger.setEditable(false);
		totalPassenger.setColumns(10);
		totalPassenger.setVisible(false);

		profit = new JTextField();
		profit.setForeground(Color.BLACK);
		profit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		profit.setEditable(false);
		profit.setColumns(10);
		profit.setBackground(Color.WHITE);
		profit.setVisible(false);

		JButton btnBack = new JButton("Geri");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				db.disconnect();
				dispose();
			}
		});
		btnBack.setBackground(new Color(28, 32, 40));
		btnBack.setForeground(new Color(220, 220, 220));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap(82, Short.MAX_VALUE)
								.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addGap(86))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(38)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblRoute, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPassenger, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProfit, GroupLayout.PREFERRED_SIZE, 114,
												GroupLayout.PREFERRED_SIZE))
								.addGap(34)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(profit, GroupLayout.PREFERRED_SIZE, 193,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(totalPassenger, 193, 193, 193)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 193,
												GroupLayout.PREFERRED_SIZE))
								.addGap(65))
						.addGroup(gl_panel.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(331, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(40)
								.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblRoute, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(65)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(totalPassenger, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPassenger, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGap(45)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblProfit, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(profit, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		panel.setLayout(gl_panel);
	}
}
