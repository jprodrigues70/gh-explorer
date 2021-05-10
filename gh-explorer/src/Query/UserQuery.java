package Query;

import java.util.Scanner;

import GitHubOutput.GitHubOutput;
import GitHubOutput.UserGitHubOutput;

public class UserQuery implements QueryInterface {
	private String location = "";
	private String language = "";
	private String search = "";
	private Scanner str = new Scanner(System.in);
	private String token = "";
	
	@Override
	public String getType() {
		return "Users";
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String getSearch() {
		return this.search;
	}

	@Override
	public void setSearch(String search) {
		this.search = search;
	}
	
	private void readLocation() {
		System.out.println("Voc� quer usu�rios de qual localiza��o? ('N' para n�o especificar)");
		String location = str.nextLine();
		
		if (!location.equals("N")) {
			this.setLocation(location);
		}
	}
	
	private void readLanguage() {
		System.out.println("Voc� quer usu�rios que programem em qual linguagem? ('N' para n�o especificar)");
		String language = str.nextLine();
		
		if (!language.equals("N")) {			
			this.setLanguage(language);
		}
	}
	
	public void readToken() {
		System.out.println("Se quiser ter acesso ao nome e filtrar os usu�rios por email, informe seu token do GitHub. ('N' para n�o especificar)");
		String token = str.nextLine();
		
		if (!token.equals("N")) {
			this.setToken(token);
		}
	}

	@Override
	public void askAndMount() {
		this.readLocation();
		this.readLanguage();
		this.readToken();
		return;
	}

	@Override
	public String getQuery() throws Exception {
		if (this.language.isBlank() && this.location.isBlank()) {
			throw new Exception("Voc� precisa informar uma linguagem ou localiza��o.");
		} else if (this.language.isBlank()) {
			return "users?q=location%3A" + this.location + "&type=" + this.getType() + "&ref=advsearch";
		} else if (this.location.isBlank()) {
			return "users?q=language%3A" + this.language + "&type=" + this.getType() + "&ref=advsearch&l=" + this.language;
		}
		
		return "users?q=location%3A" + this.location + "+language%3A" + this.language + "&type=" + this.getType() + "&ref=advsearch&l=" + this.language;
	}
	
	public GitHubOutput getExpectedOutput() {
		return new UserGitHubOutput();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public boolean hasToken() {
		return this.token.isBlank();
	}
}