
public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
		if (type == "Baloon")
			return new Baloon(name, new Coordinates(longitude, latitude, height));
		else if (type == "Helicopter")
			return new Helicopter(name, new Coordinates(longitude, latitude, height));
		else if (type == "JetPlane")
			return new JetPlane(name, new Coordinates(longitude, latitude, height));
		throw new Exception("Unknown Aircraft type");
	}
}