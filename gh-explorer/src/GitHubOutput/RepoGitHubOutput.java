package GitHubOutput;

import java.util.ArrayList;

import GitHubEntity.GitHubEntity;
import GitHubEntity.Repo;

public class RepoGitHubOutput  implements GitHubOutput{
	public ArrayList<Repo> items;
	public int total_count;
	public boolean incomplete_results;
	
	public ArrayList<Repo> getItems() {
		return this.items;
	}

	@Override
	public int getTotalCount() {
		return this.total_count;
	}

	@Override
	public GitHubEntity getType() {
		return new Repo();
	}	
}