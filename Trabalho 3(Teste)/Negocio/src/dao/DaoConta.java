package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoConta {

	public void insereConta(ArrayList<Conta> listaConta, Connection con, int idCliente) throws SQLException {

		String sql = "INSERT INTO Conta (saldo, dataAbertura, idCliente, idTipoConta, idAgencia) VALUES (?,?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Conta Conta : listaConta) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, Conta.getsaldo());
			create.setString(2, Conta.getdataAbertura());
			create.setInt(3, idCliente);
			create.setString(4, Conta.getTipoConta());
			create.setString(5, Conta.getAgencia());
			create.execute();
		}

	}
	public ArrayList<Conta> consultaConta(int idCliente, Connection con) throws SQLException {
		
		ArrayList<Conta> m = new ArrayList<Conta>();
		String sql = "SELECT * FROM Conta WHERE idCliente = ?;" ;
				
		PreparedStatement stt = con.prepareStatement(sql);
		stt.setInt(1, idCliente);
		ResultSet res = stt.executeQuery();
		int i=0;
		while (res.next()) {
			Conta Conta = new Conta();
			Conta.setsaldo(res.getFloat("saldo"));
			Conta.setdataAbertura(res.getString("DataAbertura"));
			Conta.setCliente(res.getInt("idCliente"));
			Conta.setTipoConta(res.getInt("idTipoConta"));
			Conta.setAgencia(res.getInt("idAgencia"));
			System.out.println(res.getString("Conta"));
			
			m.add(i,Conta);
			
			i++;	
		}
		return m;
	}
}
