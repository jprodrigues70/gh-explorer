package ConexaoBanco;

import java.sql.SQLException;

public class TesteConexao {
	java.sql.Statement stm = null;
	String sql = "INSERT INTO Categoria VALUES (null,'Teste');";

	public void TestaConexao() throws ClassNotFoundException, SQLException {
		stm = Conexao.getInstacia().getConector().createStatement();
		stm.executeUpdate(sql);
	}

}
