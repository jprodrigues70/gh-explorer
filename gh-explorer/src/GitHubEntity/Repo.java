package GitHubEntity;

import java.util.ArrayList;

import Pattern.Observer;
import Pattern.Subject;

public class Repo implements Subject{
	private String name;
	private String owner_name;
	private String owner_id;
	private String url;
	private String stars;
	private String forks;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
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
		this.notificarObservers();
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
	public void incluirObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removerObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if(i >= 0 ) {
			observers.remove(i);
		}
		
	}

	@Override
	public void notificarObservers() {
		for(int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.atualizar(this);
		}
	}
	
	
}
