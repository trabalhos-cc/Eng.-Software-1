package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTipoInvestimento {

	public void insereTipoInvestimento (ArrayList<TipoInvestimento > listaTipoInvestimento , Connection con) throws SQLException {

		String sql = "INSERT INTO TipoInvestimento (nomeTipoInvestimento ) VALUES (?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (TipoInvestimento TipoInvestimento : listaTipoInvestimento) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, TipoInvestimento.getnomeTipoInvestimento());
			create.execute();
		}
	}
	
	public ArrayList<TipoInvestimento> consultaTipoInvestimento(Connection con) throws SQLException {
		
		ArrayList<TipoInvestimento> m = new ArrayList<TipoInvestimento>();
		String sql = "SELECT * FROM TipoInvestimento;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			TipoInvestimento TipoInvestimento = new TipoInvestimento();
			TipoInvestimento.setnomeTipoInvestimento(res.getString("nomeTipoInvestimento"));
			System.out.println(res.getString("Movimentação"));
			
			m.add(i,TipoInvestimento);
			
			i++;	
		}
		return m;
}
