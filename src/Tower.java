import java.util.ArrayList;

public class Tower {
    private int seed = 1;
    private ArrayList<Flyable> observers = new ArrayList<>();

    protected int getSeed() {return seed;}

    public void register(Flyable flyable) {
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }
    
    protected void conditionsChanged()
	{
        seed = Utils.hash(seed);
	}
}
