package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoMovimentação {

	public void insereMovimentação(ArrayList<Movimentação> listaMovimentação, Connection con, int idConta) throws SQLException {

		String sql = "INSERT INTO Movimentação (data, valor, TipoMovimentação, idConta) VALUES (?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Movimentação Movimentação : listaMovimentação) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, Movimentação.getdata());
			create.setString(2, Movimentação.getvalor());
			create.setString(3, Movimentação.getTipoMovimentação());
			create.setInt(4, idConta);
			create.execute();
		}

	}
	
	public ArrayList<Movimentação> consultaMovimentação(int idConta, Connection con) throws SQLException {
			
			ArrayList<Movimentação> m = new ArrayList<Movimentação>();
			String sql = "SELECT * FROM Movimentacao WHERE idConta = ?;" ;
					
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setInt(1, idConta);
			ResultSet res = stt.executeQuery();
			int i=0;
			while (res.next()) {
				Movimentação Movimentação = new Movimentação();
				Movimentação.setdata(res.getString("data"));
				Movimentação.setvalor(res.getFloat("valor"));
				Movimentação.setTipoMovimentação(res.getString("TipoMovimentação"));
				Movimentação.setIdConta(res.getInt("idConta"));
				System.out.println(res.getString("Movimentação"));
				
				m.add(i,Movimentação);
				
				i++;	
			}
			return m;
	}
}
