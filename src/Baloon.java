package avaj;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() {
        Logger logger = Logger.get();
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) // ◦ SUN - Longitude increases with 2, Height increases with 4
        {
            logger.log(toString() + ": Sunny.");
            coordinates.addLongitude(2);
            coordinates.addHeight(4);
        }
        else if (weather.equals("RAIN"))// ◦ RAIN - Height decreases with 5
        {
            logger.log(toString() + ": Rainy, kinda.");
            coordinates.addLatitude(-5);
        }
        else if (weather.equals("FOG"))// ◦ FOG - Height decreases with 3
        {
            logger.log(toString() + ": Foggy.");
            coordinates.addLatitude(-3);
        }
        else if (weather.equals("SNOW"))// ◦ SNOW - Height decreases with 15
        {
            logger.log(toString() + ": Snowy.");
            coordinates.addHeight(-15);
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
    public String toString() { return "Baloon#" + super.toString(); };
    public boolean validCoordinates() { return checkHeight(); };
}
