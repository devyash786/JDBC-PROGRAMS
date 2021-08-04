import java.sql.*;

import javax.swing.JOptionPane;
public class DropDatabase {

	public static void main(String[] args) throws SQLException {
		Connection con=DBInfo.con;
		String db=JOptionPane.showInputDialog("Enter database name");
		String query="drop database "+db;
		PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
		System.out.print("dropped");
		con.close();DBInfo.con.close();
		
	}

}
