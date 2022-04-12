import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

class hotel extends JFrame{
		JLabel l1,l2,l3,l4,l5;
		JTextField t1,t2,t3,t4;
		JButton b1;
		hotel(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("Hotel");
			l1.setFont(f);
			l2=new JLabel("HID");
			t1=new JTextField();
			l3=new JLabel("Hname");
			t2=new JTextField();
			l4=new JLabel("Hemail");
			t3=new JTextField();
			l5=new JLabel("Hphno");
			t4=new JTextField();
			b1=new JButton("OK");
			l1.setBounds(70,40,200,40);
			l2.setBounds(70,100,100,20);//UserName Label
			t1.setBounds(70,120,200,30);//TextField 
			l3.setBounds(70,170,100,20);
			t2.setBounds(70,190,200,30);
			l4.setBounds(70,240,100,20);
			t3.setBounds(70,260,200,30);
			l5.setBounds(70,310,100,20);
			t4.setBounds(70,330,200,30);
			b1.setBounds(170,380,100,30);
			add(l1);
			add(l2);
			add(t1);
			add(l3);
			add(t2);
			add(l4);
			add(t3);
            add(l5);
			add(t4);
			add(b1);
			setLayout(null);
			setVisible(true);
			setSize(400,700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					JOptionPane.showMessageDialog(t4, "The inserted row is \nHID = "+t1.getText()+"\nHname = "+t2.getText()+
													"\nHemail = "+t3.getText()+"\nHphno= "+t4.getText());
					try {
						int rowsUpdated;
						Class.forName("oracle.jdbc.OracleDriver");
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + DatabaseInfo.SID,
								User.name, User.password);
						try {
							PreparedStatement prepStmt = con.prepareStatement(
									"INSERT INTO hotel (hid,hname,hemail,hphno) VALUES (?,?,?,?)");
							prepStmt.setString(1, t1.getText());
							prepStmt.setString(2, t2.getText());
							prepStmt.setString(3, t3.getText());
							prepStmt.setString(4, t4.getText());
							rowsUpdated = prepStmt.executeUpdate();
							if (rowsUpdated > 0)
								System.out.println("Successfully inserted " + rowsUpdated + " row(s)");
							else
								System.out.println("Failed to insert to table");
	
							prepStmt.close();
						} catch (SQLException sqle) {
							System.out.println(sqle);
							System.out.println("Failed to perform Insert using prepared statement");
						}
	
					} catch (ClassNotFoundException cnfe) {
						System.out.println(cnfe);
						System.out.println("Failed to load driver");
					} catch (SQLException sqle) {
						System.out.println(sqle);
					}
				
				}
			});
		}
	public static void main(String[] args){
		hotel h=new hotel();
	}
}