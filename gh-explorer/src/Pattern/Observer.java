package Pattern;
import GitHubEntity.Repo;
import GitHubEntity.User;

public interface Observer {

	public void atualizar(Repo repo);
	public void atualizar(User user);
	
}
