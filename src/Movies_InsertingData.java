import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;

public class Movies_InsertingData {
	public static void main(String[] args)
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("org.sqlite.JDBC"); 
			java.sql.Connection con=DriverManager.getConnection("jdbc:sqlite:product.db"); 
			if(con!=null)
			{ 
				//inserting data into Movies table statistically 
				//Statement stmt=con.createStatement();
				//int n=stmt.executeUpdate("INSERT INTO Movies VALUES('Ishq','Nithin','Nithya Menon','Vikram Kumar',2012)");
				//System.out.println(n);
				
				//inserting data into Movies table dynamically
				PreparedStatement pstmt=con.prepareStatement("insert into Movies values(?,?,?,?,?)");
				System.out.println("Enter the movie name:");
				String name=sc.next();
				
				System.out.println("Enter the actor name:");
				String actor=sc.next();
				
				System.out.println("Enter the actress name:");
				String actress=sc.next();
				
				System.out.println("Enter the director name:");
				String director=sc.next();
				
				System.out.println("Enter the year of release of movie:");
				int year_of_release=sc.nextInt();
				
				pstmt.setString(1, name);
				pstmt.setString(2, actor);
				pstmt.setString(3, actress);
				pstmt.setString(4, director);
				pstmt.setInt(5, year_of_release);
				
				int n=pstmt.executeUpdate();
				System.out.println(n);
			} 
		} 
		catch(Exception e)
		{
			System.out.println(e); 
		}
	}
}