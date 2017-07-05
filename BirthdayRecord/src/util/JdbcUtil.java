package util;
import java.sql.*;
public class JdbcUtil {
	static{
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
		   }catch(ClassNotFoundException e){
			   e.printStackTrace();
		   }
		}
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			String url="jdbc:mysql://localhost/Birthday?user=root&password=123456&useUnicode=true&characterEncoding=utf8&useSSL=false";
			
			conn = DriverManager.getConnection(url);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
		
		public static void close(Statement stmt,Connection conn)throws SQLException{
		     stmt.close();
			 conn.close();
		}

		public static void close(ResultSet rs,Statement stmt,Connection conn)throws SQLException{
		     rs.close();
			 close(stmt,conn);
		}
}
