package pl.sda.OrangeJavaPL2Spring.exceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException() {
    }

    public AddressNotFoundException(String message) {
        super(message);
    }
}
