package pl.sda.OrangeJavaPL2Spring.exceptions;

public class BreadNotFoundException extends RuntimeException {

    public BreadNotFoundException() {
    }
    public BreadNotFoundException(String message) {
        super(message);
    }
}
