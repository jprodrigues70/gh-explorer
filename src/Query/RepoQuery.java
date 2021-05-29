package Query;

import java.util.Scanner;

import GitHubOutput.GitHubOutput;
import GitHubOutput.RepoGitHubOutput;

public class RepoQuery implements QueryInterface {
	private String language = "";
	private String search;
	private Scanner str = new Scanner(System.in);
	public static String type = "Repositories";
	private String urlBase="https://api.github.com/search/";
	private String token = "";
	private String query = "";
	
	public String getType() {
		return RepoQuery.type;
	}
	@Override
	public String getSearch() {
		return search;
	}
	
	@Override
	public void setSearch(String search) {
		this.search = search;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public void readSearch() {
		System.out.println("Qual termo você quer encontrar?");
		String search = str.nextLine();
		this.setSearch(search);
	}
	
	private void readLanguage() {
		System.out.println("Em qual linguagem? ('N' para não especificar)");
		String language = str.nextLine();
		
		if (!language.equals("N")) {			
			this.setLanguage(language);
		}
	}
	
	@Override
	public void askAndMount() {
		this.readSearch();	
		this.readLanguage();		
	}

	@Override
	public String getQuery() throws Exception {
		if (!this.query.isBlank()) {
			return this.query;
		}

		String query = "";
		if (this.language.isEmpty()) {
			query = "repositories?q=" + this.search + "&type=Repositories&sort=stars&order=desc";
		} else {
			query = "repositories?q=" + this.search + "+language:" + this.language + "&type=Repositories&sort=stars&order=desc";
		}
		
		return  this.urlBase + query;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean hasToken() {
		return this.token.isEmpty();
	}
	
	@Override
	public void setQuery(String query) {
		this.query = query;
	}
	@Override
	public GitHubOutput getExpectedOutput() {
		return new RepoGitHubOutput();
	}
}
