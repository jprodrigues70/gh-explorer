package Outputer;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import GitHubOutput.RepoGitHubOutput;
import Output.Csv;
import Pattern.Observer;
import Query.RepoQuery;
import Search.Searcher;

public class Repo implements Observer {
	@Override
	public void update(Searcher search) throws IOException {
		if (search.getType().contentEquals(RepoQuery.type)) {
			Csv csv = Csv.getInstance();
			
			if (search.getFinished()) {
				String header = "name,stars,forks,watchers,url\n";
				csv.close(header);
				return;
			}

			Gson gson = new Gson();
			
			RepoGitHubOutput output = gson.fromJson(search.getResults(), RepoGitHubOutput.class);
			
			ArrayList<GitHubEntity.Repo> items = output.getItems();
			ArrayList<String> map = new ArrayList<String>();
			
			for (int i = 0; i < items.size(); i++) {
				GitHubEntity.Repo repo = items.get(i);
				String line = repo.getName()  + "," + repo.getStargazers_count()  + "," + repo.getForks()  + "," + repo.getWatchers()  + "," + repo.getUrl() + "\n";
				map.add(line);
				System.out.print("*");
			}
			
			csv.print(map);
			System.out.print("\n");
		}
	}
}
