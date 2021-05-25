package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import GitHubOutput.GitHubOutput;
import Pattern.Observer;
import Pattern.Subject;
import Query.QueryInterface;

public class Searcher implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	private QueryInterface query;
	private GitHubOutput outputClass;
	private String results;
	private Boolean finished = false;
	
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
	
	public QueryInterface getQuery() {
		return this.query;
	}
	
	public String getUrl( ) throws Exception {
		return this.query.getQuery();
	}
	
	public void setResults(String results) throws IOException {
		this.results = results;
		this.notifyObservers();
	}
	
	public String getResults() {
		return this.results;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) throws IOException {
		this.finished = finished;
		this.notifyObservers();
	}
	
	public String go(HttpURLConnection con) throws IOException {
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		
		String token = this.query.getToken();
		if (!token.isBlank()) {			
			con.setRequestProperty("Authorization", "token " + this.query.getToken());
		}
		
		BufferedReader in = new BufferedReader(
		  new InputStreamReader(con.getInputStream()));
		String inputLine;
		
		StringBuffer content = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
		    content.append(inputLine);
		}
		return content.toString();
	}
	
	public void find() throws Exception { 		

		URL url = new URL(this.getUrl());
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		String content = this.go(con);
		this.setResults(content);

		String header = con.getHeaderField("link");         

		if (!this.getUrl().contains("page=10") && header != null && header.contains("rel=\"next\"")) {
	    	String[] links = header.split("[,]", 0);
	    	
	    	for (int i = 0; i < links.length; i++) {
	    		if (links[i].contains("rel=\"next\"")) {
	    			String str = links[i];
	    			String query = str.substring(0 , str.indexOf('>')).replace("<", "");
	    			
	    			if (!this.getUrl().contentEquals(query) && !query.contains("page=11")) {
	    				this.query.setQuery(query);				
	    				this.find();
	    				break;
	    			} else {
	    				this.setFinished(true);
	    				break;
	    			}
	    		}
	    	}
		} else {			
			this.setFinished(true);
		}
		
			
		con.disconnect();
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
	public void notifyObservers() throws IOException {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(this);
		}
		
	}
}
