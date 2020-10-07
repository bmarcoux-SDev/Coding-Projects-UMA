/*
This Java application will create a database, within the database create a table,
insert two records in the table, and then query the table.
It uses the Apache Derby tools.
Compile and run this code from within C:\Apache\db-derby-10.15.2.0-bin
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
public class CreateDBDemo
{
	public static void main(String[] args)
	{
		// connect to or create a database named booksdb
		// for more about the syntax of the connection command, see the document JDBC Notes
		String databaseURL = "jdbc:derby:booksdb;create=true";
		try (Connection conn = DriverManager.getConnection(databaseURL))
		{
			// create a SQL instruction that the connection object will execute
			Statement statement = conn.createStatement();
			
			// if the book table does not exist, execute the code in the if block
			if (!doesTableExists("book", conn))
			{
				// create a table named book
				// search on-line for a list of common SQL data types
				String sql = "CREATE TABLE book (book_id int primary key, title varchar(128))";
				statement.execute(sql);
				System.out.println("Created table book.");
				// insert two rows of data into the book table
				sql = "INSERT INTO book VALUES (1, 'Effective Java'), (2, 'Core Java')";
				statement.execute(sql);
				System.out.println("Inserted 2 rows.");
			}
			
			// create and execute a query that will select all records from the book table. '*' is a wildcard.
			String sql = "SELECT * FROM book";
			ResultSet result = statement.executeQuery(sql);
			while (result.next())
			{
				// while there is another record remaining in the book table, print the title to the screen
				System.out.println(result.getString("title"));
			}
			// shut down all databases and the derby engine.
			// You might also notice that it tests for a SQL exception.
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		}// end of try block
		catch (SQLException ex)
		{
			// A clean shutdown always throws SQL exception XJ015, which can be ignored.
			if (ex.getSQLState().equals("XJ015"))
			{
				System.out.println("Derby shutdown normally");
			}
			else
			{
				ex.printStackTrace();
			}
		}// end of catch block
	} // end of main method
	private static boolean doesTableExists(String tableName, Connection conn)
	throws SQLException
	{
		DatabaseMetaData meta = conn.getMetaData();
		ResultSet result = meta.getTables(null, null, tableName.toUpperCase(), null);
		return result.next();
	}
} // end of class