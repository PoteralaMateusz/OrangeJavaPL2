package pl.sda.OrangeJavaPL2Spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BakeryGlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BreadNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String breadNotFoundExceptionHandler(BreadNotFoundException exception) {
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String addressNotFoundExceptionHandler(AddressNotFoundException exception){
        return exception.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BakeryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String bakeryNotFoundExceptionHandler(BakeryNotFoundException exception){
        return exception.getMessage();
    }

}
