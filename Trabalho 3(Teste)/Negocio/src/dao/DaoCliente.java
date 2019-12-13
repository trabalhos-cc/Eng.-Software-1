package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCliente {

	public void insereCliente(ArrayList<Cliente> listaCliente, Connection con, int idEndereco) throws SQLException {

		String sql = "INSERT INTO Cliente (nome, CPF, dtNascimento, sexo, CNPJ, nroLocal, Complemento, idEndereco) VALUES (?,?,?,?,?,?,?,?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (Cliente Cliente : listaCliente) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, Cliente.getnome());
			create.setString(2, Cliente.getCPF());
			create.setDate(3, Cliente.getdtNascimento());
			create.setString(4, Cliente.getsexo());
			create.setString(5, Cliente.getCNPJ());
			create.setInt(6, Cliente.getnroLocal());
			create.setString(7, Cliente.getcomplemento());
			create.setInt(8, idEndereco);
			create.execute();
		}

	}
	
	public ArrayList<Cliente> consultaCliente(Connection con) throws SQLException {
			
			ArrayList<Cliente> m = new ArrayList<Cliente>();
			String sql = "SELECT * FROM Cliente;" ;
					
			PreparedStatement stt = con.prepareStatement(sql);
			ResultSet res = stt.executeQuery();
			int i=0;
			while (res.next()) {
				Cliente Cliente = new Cliente();
				Cliente.setnome(res.getString("nome"));
				Cliente.setCPF(res.getString("CPF"));
				Cliente.setdtNascimento(res.getDate("dtNascimento"));
				Cliente.setsexo(res.getString("sexo"));
				Cliente.setCNPJ(res.getString("CNPJ"));
				Cliente.setnroLocal(res.getInt("nroLocal"));
				Cliente.setcomplemento(res.getString("complemento"));
				Cliente.setEndereco(res.getString("Endereco"));
				System.out.println(res.getString("Cliente"));
				
				m.add(i,Cliente);
				
				i++;	
			}
			return m;
	}
}
