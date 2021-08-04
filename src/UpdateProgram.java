import java.sql.*;


import javax.swing.JOptionPane;

public class UpdateProgram {

	public static void main(String[] args) throws SQLException {
        Connection con=DBInfo.con;
        String query="update login set password=?,usertype=? where username=?";
        String username=JOptionPane.showInputDialog("Enter username");
        String newpass=JOptionPane.showInputDialog("Enter new password");
        String newUsr=JOptionPane.showInputDialog("Enter new usertype");
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1, newpass);
        ps.setString(2, newUsr);
        ps.setString(3, username);
        int i=ps.executeUpdate();
        System.out.print(i+" Record uodates");
        ps.close();
        con.close();
        DBInfo.con.close();
        
        
        

	}

}
