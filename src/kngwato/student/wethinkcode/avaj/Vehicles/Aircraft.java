package kngwato.student.wethinkcode.avaj.Vehicles;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCouter = 0;
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        id = nextId();
    }

    private long nextId() {
        return ++idCouter;
    }

    public String getName() {
        return name;
    }


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + ", " + coordinates.toString();
    }
}
