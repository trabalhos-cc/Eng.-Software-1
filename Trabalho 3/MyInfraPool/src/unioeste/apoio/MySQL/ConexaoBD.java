package unioeste.apoio.MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;


public class ConexaoBD {
		
//	public static DataSource bd;
	public static javax.naming.InitialContext ctx;
	public static javax.sql.DataSource ds;
//	public static java.sql.Connection conn;
	
	static {
//		JDBCPool pool = new JDBCPool();
//		bd.setDriverClassName("com.mysql.jdbc.Driver");
//		bd.setUrl("jdbc:mysql://localhost:3306/homebank?useTimezone=true&serverTimezone=UTC");
//		bd.setUsername("root");
//		bd.setPassword("root");
//		bd.setMinIdle(3);
//		bd.setMaxIdle(15);
//		bd.setMaxOpenPreparedStatements(150);
		
		
		try {
			ctx = new javax.naming.InitialContext();
			ds = (javax.sql.DataSource)ctx.lookup("jdbc/homebank");
//			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		
		return ds.getConnection();
	}
	
	public static void insereSQLComand(Connection conn, String query) throws Exception
	{
		try {
			
			PreparedStatement create = conn.prepareStatement(query);
			create.executeUpdate();
			
		}catch(Exception e) {System.out.println(e);}
	}
	
	public static ArrayList<String> getTabela(Connection conn, String query) throws Exception
	{
		try {
			
			PreparedStatement stat = conn.prepareStatement(query);
			
			ResultSet res = stat.executeQuery();
			ArrayList<String> cliente = new ArrayList<String>();
			
			ResultSetMetaData rsmd = res.getMetaData();
			int colunas = rsmd.getColumnCount();
			
			while(res.next()) {
				for(int i = 1; i <= colunas; i++){
					
					cliente.add(res.getString(i));
				}
			}
			
			return cliente;
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		return null;	
	}
	
	public static String getSelect(Connection conn, String query) throws Exception
	{
		try {
			
			PreparedStatement stat = conn.prepareStatement(query);
			
			ResultSet res = stat.executeQuery();
			String cliente;
			
			res.next();
			
			cliente = res.getString(1);
			
			return cliente;
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;	
	}
}
