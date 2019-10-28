package avaj;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        Logger logger = Logger.get();
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) // ◦ SUN - Longitude increases with 10, Height increases with 2
        {
            logger.log(toString() + ": Sun is shining, weather is sweet.");
            coordinates.addLatitude(10);
            coordinates.addHeight(2);
        }
        else if (weather.equals("RAIN"))// ◦ RAIN - Longitude increases with 5
        {
            logger.log(toString() + ": Heavy rain.");
            coordinates.addLatitude(5);
        }
        else if (weather.equals("FOG"))// ◦ FOG - Longitude increases with 1
        {
            logger.log(toString() + ": It's like Silent Hill in here.");
            coordinates.addLatitude(1);
        }
        else if (weather.equals("SNOW"))// ◦ SNOW - Height decreases with 12
        {
            logger.log(toString() + ": Let it snow, let it snow, let it snow.");
            coordinates.addHeight(-12);
        }
    }
    public void registerTower(WeatherTower weatherTower) {
    	weatherTower.register(this);
        this.weatherTower = weatherTower;
    }
    public void unregisterTower() {
    	weatherTower.unregister(this);
        this.weatherTower = null;
    }
    public String toString() { return "Helicopter#" + super.toString(); };
    public boolean validCoordinates() { return checkHeight(); };
}
