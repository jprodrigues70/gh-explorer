package GitHubEntity;

import java.util.ArrayList;

import Pattern.Observer;
import Pattern.Subject;

public class User implements GitHubEntity, Subject {
	private String name;
	private String login;
	private String url;
	private String id;
	private String location;
	private String email;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setName(String name) {
		this.name = name;
		this.notificarObservers();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLogin() {
		return this.login;
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
