import GitHubOutput.GitHubOutput;
import Query.QueryInterface;
import Query.QueryTypesEnum;
import Query.RepoQuery;
import Query.UserQuery;

public class Factory {
	public static QueryInterface createQuery(int type) throws Exception {
		if (type == QueryTypesEnum.USER.getType()) {
			return new UserQuery();
		} else if (type ==  QueryTypesEnum.REPO.getType()) {
			return new RepoQuery();
		}
		throw new Exception("Voc� n�o selecionou um tipo v�lido.");
	}
	
	public static Searcher createSearcher(GitHubOutput type, QueryInterface query) throws Exception {
		return new Searcher(type, query);
	}
}
