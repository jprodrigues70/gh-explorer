package Pattern;
import java.io.IOException;

import Search.Searcher;

public interface Observer {
	public void update(Searcher search) throws IOException;
}
