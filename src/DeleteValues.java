import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 Connection cn=DBInfo.con	;
	 String str="delete from login where username=?;";
	 Scanner sc=new Scanner(System.in);
	 System.out.print("Enter Username");
	 String s1=sc.nextLine();
	 PreparedStatement ps=cn.prepareStatement(str);
	 ps.setString(1, s1);
	 int i=ps.executeUpdate();
	 System.out.print(i+"  record deleted");
	 cn.close();
	 ps.close();
	 DBInfo.con.close();
	 
	 
	 
	 

	}

}
