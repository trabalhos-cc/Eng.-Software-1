package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTelefone {

	public void insereTelefone(ArrayList<Telefone> listaTelefones, Connection con, int idCliente) throws SQLException {

		String sql = "INSERT INTO Fone (numero, idDDD, idDDI, idCliente) VALUES (?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Telefone Telefone : listaTelefones) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, Telefone.getTelefone());
			create.setString(2, Telefone.getDDD());
			create.setString(3, Telefone.getDDI());
			create.setInt(4, idCliente);
			create.execute();
		}

	}

	public ArrayList<Telefone> consultaTelefone(int idCliente, Connection con) throws SQLException {
		
		ArrayList<Telefone> m = new ArrayList<Telefone>();
		String sql = "SELECT * FROM telefone WHERE idCliente = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, idPaciente);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Telefone telefone = new Telefone();
			telefone.setDDD(res.getString("DDD"));
			telefone.setDDI(res.getString("DDI"));
			telefone.setTelefone(res.getString("Telefone"));
			telefone.setIdTelefone(res.getInt("idTelefone"));
			System.out.println(res.getString("Telefone"));
			
			m.add(i,telefone);
			
			i++;	
		}
		return m;
	}
}
