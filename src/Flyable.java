package org.avaj.simulation;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower tower);
    public void unregisterTower();
}