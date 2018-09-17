package kngwato.student.wethinkcode.avaj.Weather;


import kngwato.student.wethinkcode.avaj.Exceptions.InitPrinterException;
import kngwato.student.wethinkcode.avaj.Exceptions.PrintMessagePrinterException;
import kngwato.student.wethinkcode.avaj.Printer.SimulationPrinter;
import kngwato.student.wethinkcode.avaj.Vehicles.Aircraft;
import kngwato.student.wethinkcode.avaj.Vehicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void registerFlyable(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregisterFlyable(Flyable flyable) throws InitPrinterException, PrintMessagePrinterException {
        observers.remove(flyable);
        SimulationPrinter.initPrinter();
        SimulationPrinter.printMessage(String.format("Tower says: %s#%s(%d) unregistered from weather tower.",((Aircraft)flyable).getClass().getSimpleName() ,((Aircraft)flyable).getName(), ((Aircraft)flyable).getId()));
    }

    protected void conditionsChanged() throws InitPrinterException, PrintMessagePrinterException {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }

}
