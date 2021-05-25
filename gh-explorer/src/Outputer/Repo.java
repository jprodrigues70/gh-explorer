package Outputer;

import Pattern.Observer;
import Query.RepoQuery;
import Search.Searcher;

public class Repo implements Observer {
	@Override
	public void update(Searcher search) {
		if (search.getType().contentEquals(RepoQuery.type)) {
			System.out.println("It's a repo search");
		}
	}
}
