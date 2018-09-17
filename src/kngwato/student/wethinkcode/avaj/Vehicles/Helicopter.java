package kngwato.student.wethinkcode.avaj.Vehicles;

import kngwato.student.wethinkcode.avaj.Messages.AircraftMessages;
import kngwato.student.wethinkcode.avaj.Exceptions.InitPrinterException;
import kngwato.student.wethinkcode.avaj.Exceptions.PrintMessagePrinterException;
import kngwato.student.wethinkcode.avaj.Printer.SimulationPrinter;
import kngwato.student.wethinkcode.avaj.Weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void updateConditions() throws InitPrinterException, PrintMessagePrinterException {
        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                updateHeight(+2, weather);
                break;
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                updateHeight(-12, weather);
                break;
        }
    }

    @SuppressWarnings("Duplicates")
    private void updateHeight(int heightInc, String weather) throws PrintMessagePrinterException, InitPrinterException {
        SimulationPrinter.initPrinter();
        int height;
        if ((height = this.coordinates.getHeight() + heightInc) < 0)
        {
            this.coordinates.setHeight(0);
            SimulationPrinter.printMessage(String.format("Helicopter#%s(%d): landing. %s", this.name, this.id, this.coordinates.toString()));
            this.weatherTower.unregisterFlyable(this);
        }else if((height = this.coordinates.getHeight() + heightInc) < 100){
            this.coordinates.setHeight(height);
            SimulationPrinter.printMessage(String.format("Helicopter#%s(%d): %s", this.name, this.id,AircraftMessages.getAircraftMessages().getMessage("Helicopter_"+weather)));
        }else {
            this.coordinates.setHeight(100);
            SimulationPrinter.printMessage(String.format("Helicopter#%s(%d): %s", this.name, this.id,AircraftMessages.getAircraftMessages().getMessage("Helicopter_"+weather)));
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) throws PrintMessagePrinterException, InitPrinterException {
        this.weatherTower = weatherTower;
        weatherTower.registerFlyable(this);
        SimulationPrinter.initPrinter();
        SimulationPrinter.printMessage(String.format("Tower says: Helicopter#%s(%d) registered to weather tower.", this.name, this.id));
    }
}
