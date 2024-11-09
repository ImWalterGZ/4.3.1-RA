package Excepciones;

public class FullException extends Exception {

    public FullException (){
        super("Está lleno");

    }
    public FullException(String msg){
        super(msg);
    }
    public FullException(Throwable cause){
        super(cause);
    }

}
