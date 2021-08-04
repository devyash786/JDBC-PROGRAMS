import java.sql.*;
public class SelectValues {

	public static void main(String[] args) throws SQLException {
		Connection con=DBInfo.con;
		String query="select username,password from login";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		
		
		
		while(res.next())
		{ 
			 
			 String ut=res.getString(2);
			 System.out.println(res.getString(1)+"::"+ut);
			 
			
		}
		res.close();ps.close();con.close();DBInfo.con.close();
		
		

	}

}
