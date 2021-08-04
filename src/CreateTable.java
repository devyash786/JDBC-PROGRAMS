import java.sql.*;

import javax.swing.JOptionPane;
public class CreateTable {

	public static void main(String[] args) throws SQLException {
		Connection con=DBInfo.con;
		String db=JOptionPane.showInputDialog("Enter database name");
		String query="create database "+db;
		PreparedStatement ps=con.prepareStatement(query);
		ps.executeUpdate();
		System.out.print("Created");
		con.close();DBInfo.con.close();
		
	}

}
