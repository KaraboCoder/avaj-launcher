package kngwato.student.wethinkcode.avaj;

import kngwato.student.wethinkcode.avaj.Exceptions.InitPrinterException;
import kngwato.student.wethinkcode.avaj.Exceptions.InvalidAircraftTypeException;
import kngwato.student.wethinkcode.avaj.Exceptions.InvalidCoordinatesException;
import kngwato.student.wethinkcode.avaj.Exceptions.PrintMessagePrinterException;
import kngwato.student.wethinkcode.avaj.Vehicles.AircraftFactory;
import kngwato.student.wethinkcode.avaj.Vehicles.Flyable;
import kngwato.student.wethinkcode.avaj.Weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static WeatherTower weatherTower;
    public static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args){
        if (args.length == 0)
        {
            System.out.println("Please enter a valid scenario file name.");
            System.exit(1);
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();

                int simulations = Integer.parseInt(line);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count: " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null) {
                    if (line.split(" ").length != 5)
                    {
                        System.out.println("Invalid input from scenario file.");
                        System.exit(1);
                    }
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                    flyables.add(flyable);
                }

                for(Flyable flyable: flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 0; i < simulations; i++) {
                    weatherTower.callChangeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could find scenario file.");
        } catch (IOException e) {
            System.out.println("Could not read from scenario file.");
        } catch (InvalidAircraftTypeException e) {
            System.out.println(e.getMessage());
        } catch (PrintMessagePrinterException e) {
            System.out.println(e.getMessage());
        } catch (InvalidCoordinatesException e) {
            System.out.println(e.getMessage());
        } catch (InitPrinterException e) {
            System.out.println(e.getMessage());
        }catch (NumberFormatException e) {
            System.out.println("Scenario file contains invalid data formats.");
        }
    }
}
