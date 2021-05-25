package GitHubEntity;

import Pattern.Observer;
import Search.Searcher;

public class Repo implements Observer {
	private String name;
	private String owner_name;
	private String owner_id;
	private String url;
	private String stars;
	private String forks;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getForks() {
		return forks;
	}
	public void setForks(String forks) {
		this.forks = forks;
	}

	@Override
	public void update(Searcher search) {
		// TODO Auto-generated method stub
		
	}
	
	
}
