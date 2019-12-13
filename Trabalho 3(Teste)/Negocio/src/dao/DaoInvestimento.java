package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoInvestimento {

	public void insereInvestimento(ArrayList<Investimento> listaInvestimento, Connection con, int idConta) throws SQLException {

		String sql = "INSERT INTO Investimento (valor, data, idConta, idTipoInvestimento) VALUES (?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Investimento Investimento : listaInvestimento) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, Investimento.getvalor());
			create.setString(2, Investimento.getdata());
			create.setInt(3, idConta);
			create.setInt(4, Investimento.getidTipoInvestimento());
			create.execute();
		}

	}
	
	public ArrayList<Investimento> consultaInvestimento(int idConta, Connection con) throws SQLException {
		
		ArrayList<Investimento> m = new ArrayList<Investimento>();
		String sql = "SELECT * FROM Investimento WHERE idConta = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, idConta);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Investimento Investimento = new Investimento();
			Investimento.setdata(res.getString("data"));
			Investimento.setvalor(res.getFloat("valor"));
			Investimento.setTipoInvestimento(res.getString("TipoInvestimento"));
			Investimento.setIdConta(res.getInt("idConta"));
			System.out.println(res.getString("Movimentação"));
			
			m.add(i,Investimento);
			
			i++;	
		}
		return m;
	}
}
