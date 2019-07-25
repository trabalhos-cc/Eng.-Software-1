package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Connect {
	private static Connection conn = null;
	
	public static Connection toConnect() throws SQLException{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/identificarproduto", "root", "root");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm"); 
			if(conn != null) {
				
				//System.out.println("Banco de Dados conectado as " + sdf.format(new Date()));
			}
		}catch(Exception e) {
			System.out.println(e);
			//System.out.println( "N�o foi possivel conectar ao Banco de Dados!");
		}
		return conn;
	}
	
	public static Connection toDisconnect() throws SQLException{
		conn.close();
		return null;
	} 
}
