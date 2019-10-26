
public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    private long nextId() { return idCounter++; }

    public long getId() { return id; }
    public String getName() { return name; }
    public String toString() { return name + "(" + Long.toString(id) + ")"; };
}
