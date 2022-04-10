import java.sql.*;
import java.math.BigDecimal;

/*
Find the required driver file based on the database software used.
In the case of Oracle SQL, the file to be found is the ojdbc jar file.

For Oracle 12c, the file path is:
<Install directory>\Oracle12c\product\12.1.0\dbhome_1\jdbc\lib\ojdbc7.jar


When executing the java file using java command, specify the driver file using classpath
javac <filename>.java
java -cp .;<driver_file_path> <class_file_with_main>

eg:
javac JDBC.java
java -cp.;D:app\Oracle12c\product\12.1.0\dbhome_1\jdbc\lib\ojdbc7.jar Main


The driver file can be copied to the directory containing the .class file so that the entire file path of the driver file need not be specified.
javac <filename>.java
java -cp .;<driver_file> <class_file_with_main>

eg:
javac JDBC.java
java -cp.;ojdbc7.jar Main
*/

// class User
// {
//     public static final String name = "username"; // SQL+ username
//     public static final String password = "password"; // SQL+ password
// }

// class DatabaseInfo
// {
//     public static final String SID = "orcl"; // "orcl" by default
// }

class Main
{
    public static void main(String[] args)
    {
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
                ResultSet resSet = stmt.executeQuery("SELECT * FROM Employee");

                System.out.println("Details of Employees are:");
                while(resSet.next())
                {
                    System.out.println("ID: " + resSet.getInt("ID")); // Can specify column number instead of name. Numbering starts from 1
                    System.out.println("Name: " + resSet.getString("Name"));
                    System.out.println("Salary: " + resSet.getBigDecimal("Salary"));
                    System.out.println("Department number: " + resSet.getInt("DepNo"));
                    System.out.println("Birth Date: " + resSet.getDate("BDate") + "\n");
                    // *********
                }

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
                    PreparedStatement prepStmt = con.prepareStatement("INSERT INTO Employee (ID, Name, Salary, DepNo, BDate) VALUES (?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))");
                    prepStmt.setInt(1, 4); // Sets ID
                    prepStmt.setString(2, "Daphne"); // Sets Name
                    prepStmt.setBigDecimal(3, new BigDecimal("12000.00")); // Sets Salary
                    prepStmt.setInt(4, 2); // Sets DepNo
                    prepStmt.setString(5, "13/07/1992");
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

                //Updating the newly added row
                try
                {
                    rowsUpdated = stmt.executeUpdate("UPDATE Employee SET DepNo = 3 WHERE ID = 4");
                    
                    if(rowsUpdated > 0)
                        System.out.println("Successfully updated " + rowsUpdated + " row(s)");
                    else
                        System.out.println("Failed to update table");
                }
                catch(SQLException sqle)
                {
                    System.out.println(sqle);
                    System.out.println("Failed to perform Delete");
                }

                //Deleting the newly added row
                try
                {
                    rowsUpdated = stmt.executeUpdate("DELETE FROM Employee WHERE ID = 4");
                    if(rowsUpdated > 0)
                        System.out.println("Successfully deleted " + rowsUpdated + " row(s)");
                    else
                        System.out.println("Failed to delete from table");
                }
                catch(SQLException sqle)
                {
                    System.out.println(sqle);
                    System.out.println("Failed to perform Delete");
                }
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
}