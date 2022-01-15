import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class CheckTicketSecondary extends JFrame {

	private JPanel contentPane;
	private Vector<String> columns;
	private JTextField txtTickedID;
	private JTextField txtName;
	private JTextField txtGender;
	private JTextField txtAge;
	private JTextField txtPhone;
	private JTextField txtBusID;
	private JTextField txtDeparture;
	private JTextField txtArrival;
	private JTextField txtDate;
	private JTextField txtPrice;

	public CheckTicketSecondary(Vector<String> vector) {
		setTitle("Ticket Info - Tetra Corporation");
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

		JLabel lblName = new JLabel("Ad Soyad");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblTickedID = new JLabel("Bilet No");
		lblTickedID.setHorizontalAlignment(SwingConstants.CENTER);
		lblTickedID.setForeground(Color.BLACK);
		lblTickedID.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblGender = new JLabel("Cinsiyet");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblAge = new JLabel("Yaş");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblPhone = new JLabel("Telefon");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("Calibri", Font.BOLD, 12));

		txtTickedID = new JTextField();
		txtTickedID.setFont(new Font("Calibri", Font.BOLD, 12));
		txtTickedID.setForeground(new Color(0, 0, 0));
		txtTickedID.setBackground(new Color(255, 255, 255));
		txtTickedID.setEditable(false);
		txtTickedID.setColumns(10);
		txtTickedID.setText(columns.get(0));

		JLabel lblBusID = new JLabel("Otobüs No");
		lblBusID.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusID.setForeground(Color.BLACK);
		lblBusID.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblDeparture = new JLabel("Kalkış");
		lblDeparture.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeparture.setForeground(Color.BLACK);
		lblDeparture.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblArrival = new JLabel("Varış");
		lblArrival.setHorizontalAlignment(SwingConstants.CENTER);
		lblArrival.setForeground(Color.BLACK);
		lblArrival.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblDate = new JLabel("Tarih");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblPrice = new JLabel("Fiyat");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Calibri", Font.BOLD, 12));

		JLabel lblHeader = new JLabel("Bilet Bilgisi");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setForeground(Color.BLACK);
		lblHeader.setFont(new Font("Calibri", Font.BOLD, 22));

		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setFont(new Font("Calibri", Font.BOLD, 12));
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBackground(Color.WHITE);
		txtName.setText(columns.get(1));

		txtGender = new JTextField();
		txtGender.setForeground(Color.BLACK);
		txtGender.setFont(new Font("Calibri", Font.BOLD, 12));
		txtGender.setEditable(false);
		txtGender.setColumns(10);
		txtGender.setBackground(Color.WHITE);
		if (columns.get(2).equalsIgnoreCase("E"))
			txtGender.setText("Erkek");
		else
			txtGender.setText("Kadın");

		txtAge = new JTextField();
		txtAge.setForeground(Color.BLACK);
		txtAge.setFont(new Font("Calibri", Font.BOLD, 12));
		txtAge.setEditable(false);
		txtAge.setColumns(10);
		txtAge.setBackground(Color.WHITE);
		txtAge.setText(columns.get(3));

		txtPhone = new JTextField();
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setFont(new Font("Calibri", Font.BOLD, 12));
		txtPhone.setEditable(false);
		txtPhone.setColumns(10);
		txtPhone.setBackground(Color.WHITE);
		txtPhone.setText(columns.get(4));

		txtBusID = new JTextField();
		txtBusID.setForeground(Color.BLACK);
		txtBusID.setFont(new Font("Calibri", Font.BOLD, 12));
		txtBusID.setEditable(false);
		txtBusID.setColumns(10);
		txtBusID.setBackground(Color.WHITE);
		txtBusID.setText(columns.get(5));

		txtDeparture = new JTextField();
		txtDeparture.setForeground(Color.BLACK);
		txtDeparture.setFont(new Font("Calibri", Font.BOLD, 12));
		txtDeparture.setEditable(false);
		txtDeparture.setColumns(10);
		txtDeparture.setBackground(Color.WHITE);
		txtDeparture.setText(columns.get(6));

		txtArrival = new JTextField();
		txtArrival.setForeground(Color.BLACK);
		txtArrival.setFont(new Font("Calibri", Font.BOLD, 12));
		txtArrival.setEditable(false);
		txtArrival.setColumns(10);
		txtArrival.setBackground(Color.WHITE);
		txtArrival.setText(columns.get(7));

		txtDate = new JTextField();
		txtDate.setForeground(Color.BLACK);
		txtDate.setFont(new Font("Calibri", Font.BOLD, 12));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBackground(Color.WHITE);
		txtDate.setText(columns.get(8));

		txtPrice = new JTextField();
		txtPrice.setForeground(Color.BLACK);
		txtPrice.setFont(new Font("Calibri", Font.BOLD, 12));
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBackground(Color.WHITE);
		txtPrice.setText(columns.get(9) + " TL");

		JButton btnBack = new JButton("Geri");
		btnBack.setBackground(new Color(28, 32, 40));
		btnBack.setForeground(new Color(220, 220, 220));
		btnBack.addActionListener(e -> {
			this.dispose();
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(23)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(567, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addGap(49)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 87,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 159,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 87,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 159,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblTickedID, GroupLayout.PREFERRED_SIZE,
																		87, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtTickedID, GroupLayout.PREFERRED_SIZE,
																		159, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 87,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtGender, GroupLayout.PREFERRED_SIZE,
																		159, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 87,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 159,
																		GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblBusID, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDeparture, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel.createSequentialGroup()
												.addGap(219)
												.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 265,
														GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE, 159,
														GroupLayout.PREFERRED_SIZE)
												.addGap(65))
										.addComponent(txtBusID, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE, 159,
												GroupLayout.PREFERRED_SIZE))
								.addGap(46)));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(57)
								.addComponent(lblHeader, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
								.addGap(37)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblTickedID, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtTickedID, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblGender, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtGender, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblAge, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPhone, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblBusID, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtBusID, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblDeparture, GroupLayout.PREFERRED_SIZE,
																		38, GroupLayout.PREFERRED_SIZE)
																.addGap(18)
																.addComponent(lblArrival, GroupLayout.PREFERRED_SIZE,
																		38, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(txtDeparture, GroupLayout.PREFERRED_SIZE,
																		32, GroupLayout.PREFERRED_SIZE)
																.addGap(24)
																.addComponent(txtArrival, GroupLayout.PREFERRED_SIZE,
																		32, GroupLayout.PREFERRED_SIZE)))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, 32,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 38,
																GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(20)));
		panel.setLayout(gl_panel);
	}
}
