package GitHubEntity;

public class User implements GitHubEntity {
	private String name;
	private String login;
	private String url;
	private int id;
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLogin() {
		return this.login;
	}
}
