package avaj;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
    	WeatherProvider provider = WeatherProvider.getProvider();
    	return provider.getCurrentWeather(coordinates);
    }
    public void changeWeather() {
        conditionsChanged();
    }
}
