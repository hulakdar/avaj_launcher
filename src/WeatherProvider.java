import java.util.ArrayList;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static ArrayList<String> weather;

    private WeatherProvider() {}
    public static WeatherProvider getProvider()
    {
		return weatherProvider;
    }
    public String getCurrentWeather(Coordinates coordinates)
    {
    	return "not implemented";
    }
}
