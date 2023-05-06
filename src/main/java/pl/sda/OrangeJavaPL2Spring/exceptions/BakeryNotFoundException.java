package pl.sda.OrangeJavaPL2Spring.exceptions;

public class BakeryNotFoundException extends RuntimeException{

    public BakeryNotFoundException() {
    }

    public BakeryNotFoundException(String message) {
        super(message);
    }
}
