package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoMovimenta��o {

	public void insereMovimenta��o(ArrayList<Movimenta��o> listaMovimenta��o, Connection con, int idConta) throws SQLException {

		String sql = "INSERT INTO Movimenta��o (data, valor, TipoMovimenta��o, idConta) VALUES (?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Movimenta��o Movimenta��o : listaMovimenta��o) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, Movimenta��o.getdata());
			create.setString(2, Movimenta��o.getvalor());
			create.setString(3, Movimenta��o.getTipoMovimenta��o());
			create.setInt(4, idConta);
			create.execute();
		}

	}
	
	public ArrayList<Movimenta��o> consultaMovimenta��o(int idConta, Connection con) throws SQLException {
			
			ArrayList<Movimenta��o> m = new ArrayList<Movimenta��o>();
			String sql = "SELECT * FROM Movimentacao WHERE idConta = ?;" ;
					
			PreparedStatement stt = con.prepareStatement(sql);
			stt.setInt(1, idConta);
			ResultSet res = stt.executeQuery();
			int i=0;
			while (res.next()) {
				Movimenta��o Movimenta��o = new Movimenta��o();
				Movimenta��o.setdata(res.getString("data"));
				Movimenta��o.setvalor(res.getFloat("valor"));
				Movimenta��o.setTipoMovimenta��o(res.getString("TipoMovimenta��o"));
				Movimenta��o.setIdConta(res.getInt("idConta"));
				System.out.println(res.getString("Movimenta��o"));
				
				m.add(i,Movimenta��o);
				
				i++;	
			}
			return m;
	}
}
