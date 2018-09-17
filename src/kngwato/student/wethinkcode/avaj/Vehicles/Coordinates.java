package kngwato.student.wethinkcode.avaj.Vehicles;

import kngwato.student.wethinkcode.avaj.Exceptions.InvalidCoordinatesException;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) throws InvalidCoordinatesException {
        if (longitude > 0 && latitude > 0 && height > 0) {
            this.longitude = longitude;
            this.latitude = latitude;

            if (height <= 100)
                this.height = height;
            else
                throw new InvalidCoordinatesException("Height must be in the 0 - 100 range.");

        }else {
            throw new InvalidCoordinatesException("Coordinates must be positive numbers");
        }
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Coords: long = " + longitude + ", lat = " + latitude + ", height = " + height;
    }
}
