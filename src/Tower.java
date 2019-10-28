package avaj;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        Logger logger = Logger.get();
        logger.log("Tower says: registered " + flyable.toString() + ".");
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        Logger logger = Logger.get();
        logger.log("Tower says: unregistered " + flyable.toString() + ".");
        observers.remove(flyable);
    }
    
    protected void conditionsChanged()
	{
        Logger logger = Logger.get();
        ArrayList<Flyable> toRemove = new ArrayList<>();
        for (Flyable observer : observers)
        {
            observer.updateConditions();
            if (!observer.validCoordinates())
                toRemove.add(observer);
        }

        for (Flyable observer : toRemove)
        {
            logger.log(observer.toString() + " is landing.");
            observer.unregisterTower();
        }
        observers.removeAll(toRemove);
	}
}
