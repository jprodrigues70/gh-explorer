package GitHubOutput;

import java.util.ArrayList;

import GitHubEntity.GitHubEntity;
import GitHubEntity.User;

public class UserGitHubOutput implements GitHubOutput{
	public ArrayList<User> items;
	public int total_count;
	public boolean incomplete_results;
	
	public ArrayList<User> getItems() {
		return this.items;
	}

	@Override
	public int getTotalCount() {
		return this.total_count;
	}

	@Override
	public GitHubEntity getType() {
		return new User();
	}	
}
