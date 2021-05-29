package Query;

import GitHubOutput.GitHubOutput;

/**
 * @author jprod
 *
 */
public interface QueryInterface {
	public String getType();
	public String getToken();
	public String getSearch();
	public void setSearch(String search);
	public void askAndMount();
	public String getQuery() throws Exception;
	public GitHubOutput getExpectedOutput();
	public void setQuery(String query);
}
