package GitHubOutput;

import java.util.ArrayList;

import GitHubEntity.GitHubEntity;

public interface GitHubOutput {
	public int getTotalCount();

	@SuppressWarnings("rawtypes")
	public ArrayList getItems();
	
	public GitHubEntity getType();
}
