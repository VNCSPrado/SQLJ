package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		/* Statement = procurar departamentos no banco de dados
		   ResultSet = guardar o resultado*/
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection(); /*Conectar no Banco de Dados*/
			
			st = conn.createStatement();
			
			rs = st.executeQuery("select * from pessoas"); /*selecionar o banco de dados*/
			
			while(rs.next()) { /*enquanto nao for o ultimo, continua percorrendo o while*/
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		}
		catch (SQLException e) { /*mensagem de erro*/
			e.printStackTrace();
		
		}
		/*finalizar recursos externos*/
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}	
}
