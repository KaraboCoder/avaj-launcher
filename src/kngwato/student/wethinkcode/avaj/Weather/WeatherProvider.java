package kngwato.student.wethinkcode.avaj.Weather;

import kngwato.student.wethinkcode.avaj.Vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String weather[] = {"RAIN", "FOG", "SNOW", "SUN"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int total = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() + weather.length;
        int index = total % weather.length;
        return (weather[index]);
    }
}
