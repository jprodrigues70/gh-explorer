import GitHubOutput.GitHubOutput;
import Outputer.Repo;
import Outputer.User;
import Query.QueryInterface;
import Query.QueryTypesEnum;
import Query.RepoQuery;
import Query.UserQuery;
import Search.Searcher;

public class Factory {
	public static QueryInterface createQuery(int type) throws Exception {
		if (type == QueryTypesEnum.USER.getType()) {
			return new UserQuery();
		} else if (type ==  QueryTypesEnum.REPO.getType()) {
			return new RepoQuery();
		}
		throw new Exception("Você não selecionou um tipo válido.");
	}
	
	public static Searcher createSearcher(GitHubOutput type, QueryInterface query) throws Exception {
		Searcher searcher = new Searcher(type, query);
		User user = new User();
		Repo repo = new Repo();
		
		searcher.addObserver(user);
		searcher.addObserver(repo);
		
		return searcher;
	}
}
