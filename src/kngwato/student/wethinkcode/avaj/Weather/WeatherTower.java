package kngwato.student.wethinkcode.avaj.Weather;

import kngwato.student.wethinkcode.avaj.Exceptions.InitPrinterException;
import kngwato.student.wethinkcode.avaj.Exceptions.PrintMessagePrinterException;
import kngwato.student.wethinkcode.avaj.Vehicles.Coordinates;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() throws InitPrinterException, PrintMessagePrinterException {
        conditionsChanged();
    }

    public void callChangeWeather() throws InitPrinterException, PrintMessagePrinterException {
        changeWeather();
    }
}
