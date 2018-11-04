
public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    private long nextId() {


		return id;
    }
}
