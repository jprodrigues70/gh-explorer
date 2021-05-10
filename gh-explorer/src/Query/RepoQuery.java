package Query;

import java.util.Scanner;

import GitHubOutput.GitHubOutput;
import GitHubOutput.UserGitHubOutput;

public class RepoQuery implements QueryInterface {
	private String language;
	private String search;
	private Scanner str = new Scanner(System.in);
	
	@Override
	public String getType() {
		return "Repositories";
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
		System.out.println("Qual termo voc� quer encontrar?");
		String search = str.nextLine();
		this.setSearch(search);
	}
	
	@Override
	public void askAndMount() {
		this.readSearch();		
	}
	
	@Override
	public String getQuery() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public GitHubOutput getExpectedOutput() {
		return null;
	}

}