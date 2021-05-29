package Pattern;

import java.io.IOException;

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers() throws IOException;
}
