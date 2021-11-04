import java.sql.DriverManager;
import java.sql.*;

public class Movies_TableCreation {
	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.sqlite.JDBC"); 
			java.sql.Connection con=DriverManager.getConnection("jdbc:sqlite:product.db"); 
			if(con!=null)
			{ 
				System.out.println("Connected to the SQLite database successfully"); 
				Statement stmt=con.createStatement();
				int n=stmt.executeUpdate("CREATE TABLE Movies(name TEXT PRIMARY KEY,actor TEXT NOT NULL,"
						+ "actress TEXT NOT NULL,director TEXT NOT NULL,year_of_release INT NOT NULL)");
				System.out.println("Table Created");
			} 
		} 
		catch(Exception e)
		{
			System.out.println(e); 
		}
	}
}