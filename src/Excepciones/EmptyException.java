package Excepciones;

public class EmptyException extends Exception {
    public EmptyException(String message) {
        super("Está vacío");
    }
}
