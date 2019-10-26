

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;
    public int getLongitude() { return longitude; }
    public int getLatitude() { return latitude; }
    public int getHeight() { return height; }
    public void addLongitude(int offset) { longitude += offset; }
    public void addLatitude(int offset) { latitude += offset; }
    public void addHeight(int offset) { height += offset; }

    public Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int hashCode()
    {
      return Utils.hash(longitude) + Utils.hash(latitude) + Utils.hash(height);
    }
}