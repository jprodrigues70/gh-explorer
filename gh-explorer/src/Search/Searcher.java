package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import GitHubEntity.Repo;
import GitHubEntity.User;
import GitHubOutput.GitHubOutput;
import Pattern.Observer;
import Pattern.Subject;
import Query.QueryInterface;

public class Searcher implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	private QueryInterface query;
	private String urlBase="https://api.github.com/search/";
	private GitHubOutput outputClass;
	private String results;
	
	public Searcher(GitHubOutput output, QueryInterface query)  {
		this.setOutputClass(output);
		this.setQuery(query);
	}
	
	public String getType() {
		return this.query.getType();
	}
	
	public void setQuery(QueryInterface query) {
		this.query = query;
	}
	
	public String getUrl( ) throws Exception {
		return this.urlBase + this.query.getQuery();
	}
	
	public void setResults(String results) {
		this.results = results;
		this.notifyObservers();
	}
	
	public String getResults() {
		return this.results;
	}
	
	public void find() throws Exception { 		
		URL url = new URL(this.getUrl());
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		BufferedReader in = new BufferedReader(
		  new InputStreamReader(con.getInputStream()));
		String inputLine;
		
		StringBuffer content = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		
		this.setResults(content.toString());
			
		con.disconnect();
		
//		if(content.equals("")) {
//			Repo repo = new Repo();
//			atualizar(repo);
//		}
//		if(content.equals("")) {
//			User user = new User();
//			atualizar(user);
//		}
		
		//Gson gson = new Gson();
//		return content;
		//return gson.fromJson(content.toString(), outputClass.getClass());
	}

	public GitHubOutput getOutputClass() {
		return outputClass;
	}

	public void setOutputClass(GitHubOutput outputClass) {
		this.outputClass = outputClass;
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if (i >= 0) {
			observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(this);
		}
		
	}
}
