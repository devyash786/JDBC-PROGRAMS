import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertValues {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	 Connection cn=DBInfo1.getConn()	;
	 String str="insert into login(username,password,usertype) values(?,?,?);";
	 Scanner sc=new Scanner(System.in);
	 System.out.print("Enter Username");
	 String s1=sc.nextLine();
	 System.out.print("Enter Passsword");
	 String s2=sc.nextLine();
	 System.out.print("Enter Usertype");
	 String s3=sc.nextLine();
	 PreparedStatement ps=cn.prepareStatement(str);
	 ps.setString(1, s1);
	 ps.setString(2, s2);
	 ps.setString(3, s3);
	 int i=ps.executeUpdate();
	 System.out.print(i+"  record inserted");
	 cn.close();
	 ps.close();
	 
	 
	 

	}

}
