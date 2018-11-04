
public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        Aircraft(name, coordinates);
    }
    public void updateConditions();
}