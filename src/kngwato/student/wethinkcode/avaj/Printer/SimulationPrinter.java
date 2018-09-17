package kngwato.student.wethinkcode.avaj.Printer;

import kngwato.student.wethinkcode.avaj.Exceptions.InitPrinterException;
import kngwato.student.wethinkcode.avaj.Exceptions.PrintMessagePrinterException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationPrinter {
    private static BufferedWriter writer = null;

    public static void initPrinter() throws InitPrinterException {
        if (writer == null)
            try {
                writer = new BufferedWriter(new FileWriter("simulations.txt"));
            } catch (IOException e) {
                throw new InitPrinterException("Could not initialise printer");
            }
    }

    public static void printMessage(String message) throws PrintMessagePrinterException {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            throw new PrintMessagePrinterException("Could not print message to file.");
        }
    }
}
