package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTipoMovimentação {

	public void insereTipoMovimentação(ArrayList<TipoMovimentação> listaTipoMovimentação, Connection con, int idCliente) throws SQLException {

		String sql = "INSERT INTO TipoMovimentação (nome) VALUES (?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (TipoMovimentação TipoMovimentação : listaTipoMovimentação) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, TipoMovimentação.getnome());
			create.execute();
		}
	}
	
	public ArrayList<TipoMovimentação> consultaTipoMovimentação(Connection con) throws SQLException {
			
			ArrayList<TipoMovimentação> m = new ArrayList<TipoMovimentação>();
			String sql = "SELECT * FROM TipoMovimentação;" ;
					
			PreparedStatement stt = con.prepareStatement(sql);
			ResultSet res = stt.executeQuery();
			int i=0;
			while (res.next()) {
				TipoMovimentação TipoMovimentação = new TipoMovimentação();
				TipoMovimentação.setnome(res.getString("nome"));
				System.out.println(res.getString("TipoMovimentação"));
				
				m.add(i,TipoMovimentação);
				i++;	
			}
			return m;
		}
}
