package Outputer;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

import GitHubOutput.UserGitHubOutput;
import Output.Csv;
import Pattern.Observer;
import Query.UserQuery;
import Search.Searcher;

public class User implements Observer {
	@Override
	public void update(Searcher search) throws IOException {
		if (search.getType().contentEquals(UserQuery.type)) {
			Csv csv = Csv.getInstance();
			
			if (search.getFinished()) {
				String header = "username,url\n";
				if (!search.getQuery().getToken().isBlank()) {
					header = "Email,username,name,url\n";
				}
				csv.close(header);
				return;
			}

			Gson gson = new Gson();
			
			UserGitHubOutput output = gson.fromJson(search.getResults(), UserGitHubOutput.class);
			ArrayList<GitHubEntity.User> items = output.getItems();
			ArrayList<String> map = new ArrayList<String>();

			
//			Check if user inputs token
			if (!search.getQuery().getToken().isBlank()) {
				for (int i = 0; i < items.size(); i++) {
						GitHubEntity.User user = items.get(i);
					
						URL url = new URL(user.getUrl());
						HttpURLConnection con = (HttpURLConnection) url.openConnection();
						String content = search.go(con);
						GitHubEntity.User mailable = gson.fromJson(content, GitHubEntity.User.class);
						
	//					Register github user that has email
						if (mailable.hasEmail()) {
							String line = mailable.getEmail() + "," + mailable.getLogin() + "," + mailable.getName() + "," + mailable.getUrl() + "\n";
							map.add(line);
							System.out.print("!");						
						} else {
							System.out.print(".");
	//						Do something here with user that hasn't email
						}
				}
			} else {
				for (int i = 0; i < items.size(); i++) {
					GitHubEntity.User user = items.get(i);
					String line = user.getLogin() + "," + user.getUrl() + "\n";
					map.add(line);
					System.out.print("*");
				}
			}
			
			csv.print(map);
			System.out.print("\n");
		}
	}
}
