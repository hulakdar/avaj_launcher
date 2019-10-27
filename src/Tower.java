package org.avaj.simulation;

import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        System.out.println("Tower says: registered " + flyable.toString() + ".");
        observers.add(flyable);
    }
    public void unregister(Flyable flyable) {
        System.out.println("Tower says: unregistered " + flyable.toString() + ".");
        observers.remove(flyable);
    }
    
    protected void conditionsChanged()
	{
        for (Flyable observer : observers)
            observer.updateConditions();
	}
}
