package Outputer;

import Pattern.Observer;
import Query.UserQuery;
import Search.Searcher;

public class User implements Observer {
	@Override
	public void update(Searcher search) {
		if (search.getType().contentEquals(UserQuery.type)) {
			System.out.println("It's a user search");
		}
	}
}
