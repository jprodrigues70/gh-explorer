package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection conexao = null;
	private static Conexao self = null;

	protected Connection getConector() throws ClassNotFoundException, SQLException {
		if (conexao == null) {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/topicoEngenharia?serverTimezone=UTC", "root", "1234");
		}
		return conexao;
	}

	public static synchronized Conexao getInstacia() {
		if (self == null)
			return new Conexao();
		else
			return self;
	}

	@Override
	protected void finalize() throws Throwable {
		if (self != null) {
			desconectar();
		}
	}

	public void desconectar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
