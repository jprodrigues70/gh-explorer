
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

import GitHubOutput.GitHubOutput;
import Query.QueryInterface;

public class Searcher {
	private QueryInterface query;
	private String urlBase="https://api.github.com/search/";
	private GitHubOutput outputClass;
	
	Searcher(GitHubOutput output, QueryInterface query)  {
		this.setOutputClass(output);
		this.setQuery(query);
	}
	
	public void setQuery(QueryInterface query) {
		this.query = query;
	}
	
	public String getUrl( ) throws Exception {
		return this.urlBase + this.query.getQuery();
	}
	
	public GitHubOutput find() throws Exception { 		
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
		
		con.disconnect();
		
		Gson gson = new Gson();
		
		return gson.fromJson(content.toString(), outputClass.getClass());
	}

	public GitHubOutput getOutputClass() {
		return outputClass;
	}

	public void setOutputClass(GitHubOutput outputClass) {
		this.outputClass = outputClass;
	}
}
