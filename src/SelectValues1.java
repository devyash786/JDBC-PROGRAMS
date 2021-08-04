import java.sql.*;
public class SelectValues1 {

	public static void main(String[] args) throws SQLException {
		Connection con=DBInfo.con;
		String query="select * from login";
		PreparedStatement ps=con.prepareStatement(query);
		ResultSet res=ps.executeQuery();
		
		ResultSetMetaData rsmd=res.getMetaData();
		int count=rsmd.getColumnCount();
		System.out.println("Col count is "+count);
		for(int i=1;i<=count;i++)
		{
			System.out.println(rsmd.getColumnName(i)+"::"+rsmd.getColumnDisplaySize(i)+"::"+rsmd.getColumnTypeName(i));
		}
		System.out.println("-------------");
		
		while(res.next())
		{ 
			 String us=res.getString(2);
			 String pass=res.getString(3);
			 String ut=res.getString(4);
			 System.out.println(res.getInt("id")+"::"+us+"::"+pass+"::"+ut);
			 
			
		}
		res.close();ps.close();con.close();DBInfo.con.close();
		
		

	}

}
