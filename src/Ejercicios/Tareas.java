package Ejercicios;

public class Tareas {
    private static int idCounter = 0;
    private int numero;
    private String nombre;
    private String hora;
    private Boolean status;

    public Tareas(String nombre, String hora, String status){
        this.numero = idCounter++;
        this.nombre = nombre;
        this.hora = hora;
        this.status = true;
    }

    public Tareas(String nombre, String hora){
        this(nombre, hora, "pendiente");
    }
    public static int getIdCounter() {
        return idCounter;
    }
    public static void setIdCounter(int idCounter) {
        Tareas.idCounter = idCounter;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String statusText = status ? "Activa" : "Pendiente";
        return String.format("\n📝 Tarea #%d:\n  %s \n  Hora: %s \n  Estado: %s\n---------------------\n", 
            numero, nombre, hora, statusText);
    }
    
}
