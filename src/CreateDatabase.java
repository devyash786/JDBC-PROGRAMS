import java.sql.*;

import javax.swing.JOptionPane;
public class CreateDatabase {

	public static void main(String[] args) throws SQLException {
		Connection con=DBInfo.con;
		
		String query="create table emp(id int(10),name varchar(10))";
		PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
		System.out.print("Created");
		con.close();DBInfo.con.close();
		
	}

}
