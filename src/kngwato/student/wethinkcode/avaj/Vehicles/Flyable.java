package kngwato.student.wethinkcode.avaj.Vehicles;

import kngwato.student.wethinkcode.avaj.Exceptions.InitPrinterException;
import kngwato.student.wethinkcode.avaj.Exceptions.PrintMessagePrinterException;
import kngwato.student.wethinkcode.avaj.Weather.WeatherTower;

public interface Flyable {
    public void updateConditions() throws InitPrinterException, PrintMessagePrinterException;
    public void registerTower(WeatherTower weatherTower) throws InitPrinterException, PrintMessagePrinterException;
}
