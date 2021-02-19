package ObserverMode.observerDemo;

public interface Subject  {
    public void register(Observer observer);

    public void remove(Observer observer);

    public void notifyTarget();
}
