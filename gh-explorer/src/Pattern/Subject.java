package Pattern;

public interface Subject {
	
	public void incluirObserver(Observer observer);
	public void removerObserver(Observer observer);
	public void notificarObservers();

}
