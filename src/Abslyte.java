import java.sql.*;
public class Abslyte {

	public static void main(String[] args) throws SQLException {
		Connection con=DBInfo.con;
		String query="select * from login";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		
		res.absolute(3);
		
		
			 
			 String ut=res.getString(2);
			 System.out.println(res.getString(1)+"::"+ut+"::"+res.getString(3)+"::"+res.getString(4));
			 
			
		
		res.close();ps.close();con.close();DBInfo.con.close();
		
		

	}

}
