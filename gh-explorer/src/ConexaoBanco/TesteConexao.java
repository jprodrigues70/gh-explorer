package ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteConexao {
	java.sql.Statement stm = null;
	String sqlRepo = "insert into Repo (name, owner_name, url, stars, forks)" +" values (?,?,?,?,?,?)";
	String sqlUser = "insert into User (name, login, url, location, email)" + " values (?,?,?,?,?)";

	public void TestaConexao() throws ClassNotFoundException, SQLException {
		stm = Conexao.getInstacia().getConector().createStatement();
		Connection c = Conexao.getInstacia().getConector();
	//	insertRepo();
		stm.executeUpdate(sqlRepo);
		stm.executeUpdate(sqlUser);
		
		//stmt.execute();
        //stmt.close();
	}
	
//	insertRepo(){
//		
//		PreparedStatement stmt = c.prepareStatement(sqlRepo);
//		stmt.setString(1, x);
//		stmt.setString(2, x);
//		stmt.setString(3, x);
//		stmt.setString(4, x);
//		stmt.setString(5, x);
//		stmt.setString(6, x);
//	}
}
