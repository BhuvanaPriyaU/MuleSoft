import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class Movies_QueryingData {
	public static void main(String[] args)
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			Class.forName("org.sqlite.JDBC"); 
			java.sql.Connection con=DriverManager.getConnection("jdbc:sqlite:product.db"); 
			if(con!=null)
			{ 
				//retrieving all data from the Movies table
				Statement stmt=con.createStatement();
				PreparedStatement pstmt=con.prepareStatement("select* from Movies");
				ResultSet rs=pstmt.executeQuery(); 
				System.out.println("name\tactor\tactress\t\tdirector\trelease");
				System.out.println("_______________________________________________________"); 
				while(rs.next()) 
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+
							"\t\t"+rs.getString(4)+"\t"+rs.getInt(5));
				}
				
				//updating data in the Movies table
				//String sql="update Movies set name='Jersey' where actor='Nani'";
				//int n=stmt.executeUpdate(sql);
				//System.out.println(n+"Records Updated");
				
				String sql="update Movies set actor='Surya' where name='Brothers'";
				int n=stmt.executeUpdate(sql);
				System.out.println(n+"Records Updated");
				
				PreparedStatement pstmt1=con.prepareStatement("select name from Movies where actor='Prabhas'");
				ResultSet rs1=pstmt1.executeQuery(); 
				System.out.println("List of movies in which actor is Prabhas:");
				System.out.println("name");
				System.out.println("____"); 
				while(rs1.next()) 
				{
					System.out.println(rs1.getString(1));
				}
				
			} 
		} 
		catch(Exception e)
		{
			System.out.println(e); 
		}
	}
}
