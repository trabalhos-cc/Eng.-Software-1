package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTipoMovimenta��o {

	public void insereTipoMovimenta��o(ArrayList<TipoMovimenta��o> listaTipoMovimenta��o, Connection con, int idCliente) throws SQLException {

		String sql = "INSERT INTO TipoMovimenta��o (nome) VALUES (?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (TipoMovimenta��o TipoMovimenta��o : listaTipoMovimenta��o) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, TipoMovimenta��o.getnome());
			create.execute();
		}
	}
	
	public ArrayList<TipoMovimenta��o> consultaTipoMovimenta��o(Connection con) throws SQLException {
			
			ArrayList<TipoMovimenta��o> m = new ArrayList<TipoMovimenta��o>();
			String sql = "SELECT * FROM TipoMovimenta��o;" ;
					
			PreparedStatement stt = con.prepareStatement(sql);
			ResultSet res = stt.executeQuery();
			int i=0;
			while (res.next()) {
				TipoMovimenta��o TipoMovimenta��o = new TipoMovimenta��o();
				TipoMovimenta��o.setnome(res.getString("nome"));
				System.out.println(res.getString("TipoMovimenta��o"));
				
				m.add(i,TipoMovimenta��o);
				i++;	
			}
			return m;
		}
}
