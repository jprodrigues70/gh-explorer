package GitHubOutput;

import java.util.ArrayList;

import GitHubEntity.GitHubEntity;

public interface GitHubOutput {
	public int getTotalCount();

	public ArrayList getItems();
	
	public GitHubEntity getType();
}
