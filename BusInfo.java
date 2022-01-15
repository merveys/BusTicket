package DatabaseProject;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class BusInfo extends JFrame {

	private JPanel contentPane;
	private Vector<String> columns;
	private JTextField txtBusID;
	private JTextField txtDeparture;
	private JTextField txtArrival;
	private JTextField txtProfit;
	private JTextField txtPrice;
	private JTextField txtPassenger;
	private JTextField txtDate;

	public BusInfo(Vector<String> vector) {
		setTitle("Bus Info - Tetra Corporation");
		this.columns = vector;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 709, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 204));
		panel.setBounds(0, 0, 693, 568);
		contentPane.add(panel);

		JLabel departure = new JLabel("Kalkış");
		departure.setHorizontalAlignment(SwingConstants.CENTER);
		departure.setForeground(new Color(0, 0, 0));
		departure.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblBusID = new JLabel("Otobüs No");
		lblBusID.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusID.setForeground(Color.BLACK);
		lblBusID.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblArrival = new JLabel("Varış");
		lblArrival.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrival.setForeground(Color.BLACK);
		lblArrival.setFont(new Font("Calibri", Font.BOLD, 12));

		txtBusID = new JTextField();
		txtBusID.setFont(new Font("Calibri", Font.BOLD, 12));
		txtBusID.setForeground(new Color(0, 0, 0));
		txtBusID.setBackground(new Color(255, 255, 255));
		txtBusID.setEditable(false);
		txtBusID.setColumns(10);
		txtBusID.setText(columns.get(0));

		JLabel lblDate = new JLabel("Tarih");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblCustomer = new JLabel("Bulunan Yolcu");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setForeground(Color.BLACK);
		lblCustomer.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblPrice = new JLabel("Bilet Fiyatı");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblProfit = new JLabel("Kazanç");
		lblProfit.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfit.setForeground(Color.BLACK);
		lblProfit.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblAdSoyad_1_2 = new JLabel("Otobüs Bilgisi");
		lblAdSoyad_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdSoyad_1_2.setForeground(Color.BLACK);
		lblAdSoyad_1_2.setFont(new Font("Calibri", Font.BOLD, 22));

		txtDeparture = new JTextField();
		txtDeparture.setForeground(Color.BLACK);
		txtDeparture.setFont(new Font("Calibri", Font.BOLD, 12));
		txtDeparture.setEditable(false);
		txtDeparture.setColumns(10);
		txtDeparture.setBackground(Color.WHITE);
		txtDeparture.setText(columns.get(1));

		txtArrival = new JTextField();
		txtArrival.setForeground(Color.BLACK);
		txtArrival.setFont(new Font("Calibri", Font.BOLD, 12));
		txtArrival.setEditable(false);
		txtArrival.setColumns(10);
		txtArrival.setBackground(Color.WHITE);
		txtArrival.setText(columns.get(2));

		txtProfit = new JTextField();
		txtProfit.setForeground(Color.BLACK);
		txtProfit.setFont(new Font("Calibri", Font.BOLD, 12));
		txtProfit.setEditable(false);
		txtProfit.setColumns(10);
		txtProfit.setBackground(Color.WHITE);
		txtProfit.setText(columns.get(6) + " TL");

		txtPrice = new JTextField();
		txtPrice.setForeground(Color.BLACK);
		txtPrice.setFont(new Font("Calibri", Font.BOLD, 12));
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBackground(Color.WHITE);
		txtPrice.setText(columns.get(5) + " TL");

		txtPassenger = new JTextField();
		txtPassenger.setForeground(Color.BLACK);
		txtPassenger.setFont(new Font("Calibri", Font.BOLD, 12));
		txtPassenger.setEditable(false);
		txtPassenger.setColumns(10);
		txtPassenger.setBackground(Color.WHITE);
		txtPassenger.setText(columns.get(4));

		txtDate = new JTextField();
		txtDate.setForeground(Color.BLACK);
		txtDate.setFont(new Font("Calibri", Font.BOLD, 12));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBackground(Color.WHITE);
		txtDate.setText(columns.get(3));

		JButton btnGeri = new JButton("Geri");
		btnGeri.setBackground(new Color(28, 32, 40));
		btnGeri.setForeground(new Color(220, 220, 220));
		btnGeri.addActionListener(e -> {
			this.dispose();
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(219)
								.addComponent(lblAdSoyad_1_2, GroupLayout.PREFERRED_SIZE, 265,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(209, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(23)
								.addComponent(btnGeri, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(567, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGap(192)
								.addComponent(lblProfit, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtProfit, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(251, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGap(35)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblBusID, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtBusID, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(departure, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(lblCustomer, GroupLayout.PREFERRED_SIZE, 87,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtPassenger, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(79)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(57)
								.addComponent(lblAdSoyad_1_2, GroupLayout.PREFERRED_SIZE, 76,
										GroupLayout.PREFERRED_SIZE)
								.addGap(36)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBusID, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtBusID, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPassenger, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCustomer, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(departure, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE))
								.addGap(48)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGap(45)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtProfit, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblProfit, GroupLayout.PREFERRED_SIZE, 38,
												GroupLayout.PREFERRED_SIZE))
								.addGap(49)
								.addComponent(btnGeri, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(20)));
		panel.setLayout(gl_panel);
	}

}
