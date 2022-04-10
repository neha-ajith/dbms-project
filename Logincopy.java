import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

class User
{
    public static final String name = "username"; // SQL+ username
    public static final String password = "test"; // SQL+ password
}

class DatabaseInfo
{
    public static final String SID = "orcl"; // "orcl" by default
}

class Login extends JFrame{
		JLabel l1,l2,l3;
		JTextField t1;
		JPasswordField t2;
		JButton b1;
		Login(){
			Font f=new Font("Arial",Font.BOLD,24);
			l1=new JLabel("Login Page");
			l1.setFont(f);
			l2=new JLabel("UserName");
			t1=new JTextField();
			l3=new JLabel("Password");
			t2=new JPasswordField();
			b1=new JButton("Login");
			l1.setBounds(70,40,200,40);
			l2.setBounds(70,100,100,20);//UserName Label
			t1.setBounds(70,120,200,30);//TextField 
			l3.setBounds(70,170,100,20);
			t2.setBounds(70,190,200,30);
			b1.setBounds(170,240,100,30);
			add(l1);
			add(l2);
			add(t1);
			add(l3);
			add(t2);
			add(b1);
			setLayout(null);
			setVisible(true);
			setSize(400,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try
					{
						int rowsUpdated;
						Class.forName("oracle.jdbc.OracleDriver"); // Specify the driver to be used
						Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:" + DatabaseInfo.SID, User.name, User.password); // Same username and password used in SQL+
															//  URL = jdbc:oracle:<driver_type>:[<username>/<password>]@<database_specifier>:<port_number>:<SID>
															// <database_specifier> is the SID of the
			
						Statement stmt = con.createStatement();
			
						try
						{
							//Performing a Query on Employee table
							// ResultSet resSet = stmt.executeQuery("SELECT * FROM Employee");
			
							// System.out.println("Details of Employees are:");
							// while(resSet.next())
							// {
							// 	System.out.println("ID: " + resSet.getInt("ID")); // Can specify column number instead of name. Numbering starts from 1
							// 	System.out.println("Name: " + resSet.getString("Name"));
							// }
			
							//Inserting values to Employee using Statement
							/*try
							{
								rowsUpdated = stmt.executeUpdate("INSERT INTO Employee (ID, Name, Salary, DepNo, BDate) VALUES (4, 'Daphne', 12000, 3, TO_DATE('13/07/1992', 'DD/MM/YYYY'))");
								if(rowsUpdated > 0)
									System.out.println("Successfully inserted " + rowsUpdated + " row(s)");
								else
									System.out.println("Failed to insert to table");
							}
							catch(SQLException sqle)
							{
								System.out.println(sqle);
								System.out.println("Failed to perform Insert using statement");
							}*/
							
							//Inserting values into Employee using PreparedStatement
							try
							{
								PreparedStatement prepStmt = con.prepareStatement("INSERT INTO Employee (UserName, Pwd) VALUES (?, ?)");
								prepStmt.setString(1, t1.getText()); // Sets ID
								prepStmt.setString(2, t2.getText()); // Sets Name
								// prepStmt.setBigDecimal(3, new BigDecimal("12000.00")); // Sets Salary
								// prepStmt.setInt(4, 2); // Sets DepNo
								// prepStmt.setString(5, "13/07/1992");
								//prepStmt.setDate(5, Date.valueOf("1992-07-13"));
			
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
							while(resSet.next())
							{
								System.out.println("Username: " + resSet.getString("UserName")); // Can specify column number instead of name. Numbering starts from 1
								System.out.println("Password: " + resSet.getString("Pwd"));
							}
			
							//Updating the newly added row
							// try
							// {
							// 	rowsUpdated = stmt.executeUpdate("UPDATE Employee SET DepNo = 3 WHERE ID = 4");
							// 	if(rowsUpdated > 0)
							// 		System.out.println("Successfully updated " + rowsUpdated + " row(s)");
							// 	else
							// 		System.out.println("Failed to update table");
							// }
							// catch(SQLException sqle)
							// {
							// 	System.out.println(sqle);
							// 	System.out.println("Failed to perform Delete");
							// }
			
							//Deleting the newly added row
							// try
							// {
							// 	rowsUpdated = stmt.executeUpdate("DELETE FROM Employee WHERE ID = 4");
							// 	if(rowsUpdated > 0)
							// 		System.out.println("Successfully deleted " + rowsUpdated + " row(s)");
							// 	else
							// 		System.out.println("Failed to delete from table");
							// }
							// catch(SQLException sqle)
							// {
							// 	System.out.println(sqle);
							// 	System.out.println("Failed to perform Delete");
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
			};
		
	public static void main(String[] args){
		Login login=new Login();
	}
}