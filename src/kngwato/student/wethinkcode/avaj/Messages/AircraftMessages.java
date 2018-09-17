package kngwato.student.wethinkcode.avaj.Messages;

import java.util.HashMap;

public class AircraftMessages {
    private static AircraftMessages aircraftMessages = null;
    private static HashMap<String, String> messages = new HashMap<>();

    static {
        messages.put("Baloon_SUN", "Nice day for a picnic!");
        messages.put("Baloon_RAIN", "The splash just ruined my day!");
        messages.put("Baloon_FOG", "Where am I, I can't see!");
        messages.put("Baloon_SNOW", "Nice, it's time to build a snow man.");

        messages.put("Helicopter_SUN", "Ahh let's chop the bees and the birds!");
        messages.put("Helicopter_RAIN", "Good for my veggies!");
        messages.put("Helicopter_FOG", "Are we in ghost town?!");
        messages.put("Helicopter_SNOW", "Is't Christmas? No?!!!!");

        messages.put("JetPlane_SUN", "Nice day to go supersonic!");
        messages.put("JetPlane_RAIN", "Damn, you're cooling my engines!");
        messages.put("JetPlane_FOG", "I'll just fly above you, lol!");
        messages.put("JetPlane_SNOW", "Snow wont stop me either!");
    }

    private AircraftMessages(){}

    public static AircraftMessages getAircraftMessages() {
        if (aircraftMessages == null)
            aircraftMessages = new AircraftMessages();
        return aircraftMessages;
    }

    public String getMessage(String airCraftTypeAndWeatherType) {
        return messages.get(airCraftTypeAndWeatherType);
    }
}
