
public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) // ◦ SUN - Longitude increases with 10, Height increases with 2
        {
            coordinates.addLatitude(10);
            coordinates.addHeight(2);
        }
        else if (weather.equals("RAIN"))// ◦ RAIN - Longitude increases with 5
        {
            coordinates.addLatitude(5);
        }
        else if (weather.equals("FOG"))// ◦ FOG - Longitude increases with 1
        {
            coordinates.addLatitude(1);
        }
        else if (weather.equals("SNOW"))// ◦ SNOW - Height decreases with 12
        {
            coordinates.addHeight(-12);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    	weatherTower.register(this);
    }
    public String toString() { return "Helicopter#" + super.toString(); };
}
