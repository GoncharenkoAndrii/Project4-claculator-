package Exceptions;

public class WrongInputFormat extends RuntimeException{

    public WrongInputFormat(String message) {
        super(message);
    }
}
