import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

class customer extends JFrame{
		JLabel l1,l2,l3,l4,l5,l6,l7;
		JTextField t1,t2,t3,t4,t5,t6;
		JButton b1,b2;
		int cid = 0;
		customer(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("Customer");
			l1.setFont(f);
			l7=new JLabel("CustomerID");
			t6=new JTextField();
			l2=new JLabel("CustomerName");
			t1=new JTextField();
			l3=new JLabel("CustomerPhno");
			t2=new JTextField();
			l4=new JLabel("CustomerEmail");
			t3=new JTextField();
			l5=new JLabel("No of Days");
			t4=new JTextField();
			l6=new JLabel("HotelLocation");
			t5=new JTextField();
			b1=new JButton("OK");
			b2=new JButton("Back");
			l1.setBounds(70,40,200,40);
			l7.setBounds(70,100,100,20);//UserName Label
			t6.setBounds(70,120,200,30);//TextField 
			l2.setBounds(70,170,100,20);
			t1.setBounds(70,190,200,30);
			l3.setBounds(70,240,100,20);
			t2.setBounds(70,260,200,30);
			l4.setBounds(70,310,100,20);
			t3.setBounds(70,330,200,30);
			l5.setBounds(70,380,100,20);
			t4.setBounds(70,400,200,30);
			l6.setBounds(70,450,100,20);
			t5.setBounds(70,470,200,30);
			b1.setBounds(180,520,100,30);
			b2.setBounds(60,520,100,30);
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
			add(l7);
			add(t6);
			setLayout(null);
			setVisible(true);
			setSize(400,700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					// System.out.println(t1.getText());
					try
					{
						int rowsUpdated;
						Class.forName("oracle.jdbc.OracleDriver"); 
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + DatabaseInfo.SID, User.name, User.password); 
						Statement stmt = con.createStatement();
						try
						{
							try
							{
								// PreparedStatement prepStmt = con.prepareStatement("INSERT INTO Employee (UserName, Pwd) VALUES (?, ?)");
								PreparedStatement prepStmt = con.prepareStatement("INSERT INTO customer (cid,cname,cphno,cemail,chid) VALUES (?,?,?,?,?)");
								prepStmt.setString(1, t6.getText()); 
								prepStmt.setString(2, t1.getText());
								prepStmt.setString(3, t2.getText());
								prepStmt.setString(4, t3.getText());
								String loc = t5.getText();
								if(loc.equals("BANGALORE") || loc.equals("bangalore") || loc.equals("Bangalore")){
									// System.out.println("bangalore");
									prepStmt.setString(5, "101");
								}
								else if(loc.equals("CHENNAI") || loc.equals("chennai") || loc.equals("Chennai")){
									prepStmt.setString(5, "201");
								}
								else if(loc.equals("DELHI") || loc.equals("delhi") || loc.equals("delhi")){
									prepStmt.setString(5, "301");
								}
								// prepStmt.setString(3, "neha"); 
								rowsUpdated = prepStmt.executeUpdate();
								if(rowsUpdated > 0)
									System.out.println("Successfully inserted " + rowsUpdated + " row(s)");
								else
									System.out.println("Failed to insert to table");
			
								prepStmt.close();
							}
							catch(SQLException sqle)
							{
								System.out.println(sqle);
								System.out.println("Failed to perform Insert using prepared statement");
							}

							ResultSet resSet = stmt.executeQuery("SELECT * FROM Employee");
							System.out.println("Details of Employees are:");
							// while(resSet.next())
							// {
							// 	System.out.println("Username: " + resSet.getString("UserName")); // Can specify column number instead of name. Numbering starts from 1
							// 	System.out.println("Password: " + resSet.getString("Pwd"));
							// }	
						}
						catch (SQLException sqle)
						{
							System.out.println(sqle);
							System.out.println("Failed to execute SELECT * query");
						}
						stmt.close();
						con.close();
					}
					catch(ClassNotFoundException cnfe)
					{
						System.out.println(cnfe);
						System.out.println("Failed to load driver");
					}
					catch(SQLException sqle)
					{
						System.out.println(sqle);
					}
				}
			});
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					operationcus op = new operationcus();
					op.setVisible(true);
					dispose();
				}
			});
		}
	public static void main(String[] args){
		customer cus = new customer();
	}
}