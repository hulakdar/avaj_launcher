
public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {

        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) // ◦ SUN - Longitude increases with 2, Height increases with 4
        {
            coordinates.addLongitude(2);
            coordinates.addHeight(4);
        }
        else if (weather.equals("RAIN"))// ◦ RAIN - Height decreases with 5
        {
            coordinates.addLatitude(-5);
        }
        else if (weather.equals("FOG"))// ◦ FOG - Height decreases with 3
        {
            coordinates.addLatitude(-3);
        }
        else if (weather.equals("SNOW"))// ◦ SNOW - Height decreases with 15
        {
            coordinates.addHeight(-15);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    	weatherTower.register(this);
    }
    public String toString() { return "Baloon#" + super.toString(); };
}
