package avaj;

public interface Flyable {
    public void updateConditions();
    public boolean validCoordinates();
    public void registerTower(WeatherTower tower);
    public void unregisterTower();
}