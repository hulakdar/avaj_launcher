package avaj;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    public void updateConditions() 
    {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) //◦ SUN - Latitude increases with 10, Height increases with 2
        {
            Logger.log(toString() + ": Well it's sunny so we can get some height.");
            coordinates.addLatitude(10);
            coordinates.addHeight(2);
        }
        else if (weather.equals("RAIN"))// ◦ RAIN - Latitude increases with 5
        {
            Logger.log(toString() + ": It's raining out here. Changing position.");
            coordinates.addLatitude(5);
        }
        else if (weather.equals("FOG"))// ◦ FOG - Latitude increases with 1
        {
            Logger.log(toString() + ": Can't see anything, changing position.");
            coordinates.addLatitude(1);
        }
        else if (weather.equals("SNOW"))// ◦ SNOW - Height decreases with 7
        {
            Logger.log(toString() + ": You know nothing.");
            coordinates.addHeight(-7);
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
    public String toString() { return "JetPlane#" + super.toString(); };
    public boolean validCoordinates() { return checkHeight(); };
}
