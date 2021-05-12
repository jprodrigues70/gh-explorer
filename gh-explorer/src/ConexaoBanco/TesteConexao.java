package ConexaoBanco;

import java.sql.SQLException;

import GitHubEntity.Repo;
import GitHubEntity.User;

public class TesteConexao {
	java.sql.Statement stm = null;

	

	public void TestaConexao(Repo repo, User user) throws ClassNotFoundException, SQLException {
		stm = Conexao.getInstacia().getConector().createStatement();

		stm.executeUpdate("INSERT INTO Repo (name, owner_name, url, stars, forks) values ("+", "+repo.getName()+", "+ repo.getOwner_name()+", "+ repo.getUrl()+", "+ repo.getStars()+", "+ repo.getForks());
		stm.executeUpdate("INSERT INTO User (name, login, url, location, email)" + " values ("+", "+user.getName()+ ", " + user.getLogin() +", " + 	user.getUrl() +", "+ user.getLocation() +", " +user.getEmail());
	
	}

}
