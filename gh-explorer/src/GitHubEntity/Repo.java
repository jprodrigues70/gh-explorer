package GitHubEntity;

public class Repo implements GitHubEntity {
	private String name;
	private String url;
	private String stargazers_count;
	private String watchers;
	private String forks;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getForks() {
		return forks;
	}
	public void setForks(String forks) {
		this.forks = forks;
	}
	public String getWatchers() {
		return watchers;
	}
	public void setWatchers(String watchers) {
		this.watchers = watchers;
	}
	public String getStargazers_count() {
		return stargazers_count;
	}
	public void setStargazers_count(String stargazers_count) {
		this.stargazers_count = stargazers_count;
	}	
}
