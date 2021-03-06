import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

class customerupd extends JFrame {
	JLabel l1, l2, l3, l4, l5, l6;
	JTextField t1, t2, t3, t4, t5;
	JButton b1, b2;

	customerupd() {
		Font f = new Font("Arial", Font.BOLD, 24);
		l1 = new JLabel("CustomerUpdate");
		l1.setFont(f);
		l2 = new JLabel("CustomerID");
		t1 = new JTextField();
		l3 = new JLabel("CustomerName");
		t2 = new JTextField();
		l4 = new JLabel("Customerphno");
		t3 = new JTextField();
		l5 = new JLabel("Customeremail");
		t4 = new JTextField();
		l6 = new JLabel("CustomerHID");
		t5 = new JTextField();
		b1 = new JButton("OK");
		b2 = new JButton("Back");
		l1.setBounds(70, 40, 200, 40);
		l2.setBounds(70, 100, 100, 20);// UserName Label
		t1.setBounds(70, 120, 200, 30);// TextField
		l3.setBounds(70, 170, 100, 20);
		t2.setBounds(70, 190, 200, 30);
		l4.setBounds(70, 240, 100, 20);
		t3.setBounds(70, 260, 200, 30);
		l5.setBounds(70, 310, 100, 20);
		t4.setBounds(70, 330, 200, 30);
		l6.setBounds(70, 380, 100, 20);
		t5.setBounds(70, 400, 200, 30);
		b1.setBounds(180, 450, 100, 30);
		b2.setBounds(60, 450, 100, 30);
		add(l1);
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		add(l4);
		add(t3);
		add(l5);
		add(t4);
		add(l6);
		add(t5);
		add(b1);
		add(b2);
		setLayout(null);
		setVisible(true);
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					int rowsUpdated;
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + DatabaseInfo.SID,
							User.name, User.password);
					try {
						PreparedStatement prepStmt = con.prepareStatement("UPDATE customer SET chid = ? WHERE cid = ?");
						prepStmt.setString(1, t5.getText());
						prepStmt.setString(2, t1.getText());
						rowsUpdated = prepStmt.executeUpdate();
						if (rowsUpdated > 0)
							System.out.println("Successfully updated " + rowsUpdated + " row(s)");
						else
							System.out.println("Failed to update table");
						prepStmt.close();
					} catch (SQLException sqle) {
						System.out.println(sqle);
						System.out.println("Failed to perform update");
					}
				} catch (ClassNotFoundException cnfe) {
					System.out.println(cnfe);
					System.out.println("Failed to load driver");
				} catch (SQLException sqle) {
					System.out.println(sqle);
				}
				JOptionPane.showMessageDialog(t5, "The updated row is \nCID = "+t1.getText()+"\nCname = "+t2.getText()+
													"\nCphno = "+t3.getText()+"\nCemail = "+t4.getText()+"\nCHID = "+t5.getText());
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				operationcus op = new operationcus();
				op.setVisible(true);
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		customerupd cusupd = new customerupd();
	}
}