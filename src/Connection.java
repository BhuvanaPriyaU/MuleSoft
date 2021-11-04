import java.sql.*;

public class Connection {
	public static void main(String[] args)
	{
		try
		{
			Class.forName("org.sqlite.JDBC"); 
			java.sql.Connection con=DriverManager.getConnection("jdbc:sqlite:product.db"); 
			if(con!=null)
			{ 
				System.out.println("noteConnected to the SQLite database successfully"); 
			} 
		} 
		catch(Exception e)
		{
			System.out.println(e); 
		}
	}
}