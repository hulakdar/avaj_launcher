package avaj;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather[] = { "RAIN", "FOG", "SUN", "SNOW" };
    private int steps = Math.abs(Math.round((float)Math.random() * 150.0f));

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public void step() {
        steps += Math.abs(Math.round(Math.random() * 10));
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int hash = coordinates.hashCode();
        return weather[(hash + steps) & 3];
    }
}
