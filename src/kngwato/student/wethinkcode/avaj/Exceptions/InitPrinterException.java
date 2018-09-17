package kngwato.student.wethinkcode.avaj.Exceptions;

public class InitPrinterException extends Exception {
    public InitPrinterException(String could_not_initialise_printer) {
        super(could_not_initialise_printer);
    }
}
