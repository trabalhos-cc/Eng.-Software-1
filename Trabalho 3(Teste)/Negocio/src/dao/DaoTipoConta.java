package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTipoConta {

	public void insereTipoConta(ArrayList<TipoConta> listaTipoConta, Connection con) throws SQLException {

		String sql = "INSERT INTO Movimentação (nomeTipoConta) VALUES (?)";

		// PreparedStatement create = con.prepareStatement(sql);

		for (TipoConta TipoConta : listaTipoConta) {
			PreparedStatement create = con.prepareStatement(sql);
			create.setString(1, TipoConta.getnomeTipoConta());
			create.execute();
		}

	}
	
	public ArrayList<TipoConta> consultaTipoConta(Connection con) throws SQLException {
			
			ArrayList<TipoConta> m = new ArrayList<TipoConta>();
			String sql = "SELECT * FROM TipoConta;" ;
					
			PreparedStatement stt = con.prepareStatement(sql);
			ResultSet res = stt.executeQuery();
			
			int i=0;
			while (res.next()) {
				TipoConta TipoConta = new TipoConta();
				TipoConta.setnomeTipoConta(res.getString("nomeTipoConta"));
				System.out.println(res.getString("TipoConta"));
				
				m.add(i,TipoConta);
				
				i++;	
			}
			return m;
	}
}
