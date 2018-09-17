package kngwato.student.wethinkcode.avaj.Vehicles;

import kngwato.student.wethinkcode.avaj.Exceptions.InvalidAircraftTypeException;
import kngwato.student.wethinkcode.avaj.Exceptions.InvalidCoordinatesException;

public abstract class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws InvalidAircraftTypeException, InvalidCoordinatesException {
        if (name.trim().isEmpty())
        {
            System.out.println("Invalid Aircraft name.");
            System.exit(1);
        }
        switch (type) {
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            case "JetPlane":
                return  new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            default:
                throw new InvalidAircraftTypeException("Invalid Aircraft Type");
        }
    }
}
