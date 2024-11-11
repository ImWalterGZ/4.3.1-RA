package Ejercicios;
import Queue.QueueLinked;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Agenda {
    private QueueLinked<Tareas> activas;
    private QueueLinked<Tareas> pendientes;
    private BufferedReader reader;

    public Agenda() {
        activas = new QueueLinked<>();
        pendientes = new QueueLinked<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void insertarActividad(String nombre, String hora) {
        Tareas nueva = new Tareas(nombre, hora);
        activas.offer(nueva);
    }

    public Tareas eliminarActividad() {
        return activas.pull();
    }

    public void eliminarTodasActividades() {
        while (!activas.isEmpty()) {
            activas.pull();
        }
        while (!pendientes.isEmpty()) {
            pendientes.pull();
        }
    }

    public void cancelarActividad() {
        if (!activas.isEmpty()) {
            Tareas cancelada = activas.pull();
            cancelada.setStatus(false);
            pendientes.offer(cancelada);
        }
    }

    public void moverAlFinal() {
        if (!activas.isEmpty()) {
            Tareas actual = activas.pull();
            activas.offer(actual);
        }
    }

    public String verActivasActivas() {
        return activas.toString();
    }

    public String verPendientes() {
        return pendientes.toString();
    }

    public void test() {
        int opcion;
        do {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(reader.readLine());
                procesarOpcion(opcion);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                opcion = -1;
            }
        } while (opcion != 0);

        try {
            reader.close();
            // media hora buscando por que no funcionaba hasta que cerré el reader.
        } catch (Exception e) {
            System.out.println("Error al cerrar el reader: " + e.getMessage());
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== AGENDA DE ACTIVIDADES ===");
        System.out.println("1. Insertar actividad");
        System.out.println("2. Eliminar actividad");
        System.out.println("3. Eliminar todas las actividades");
        System.out.println("4. Cancelar actividad actual");
        System.out.println("5. Mover actividad actual al final");
        System.out.println("6. Ver actividades activas");
        System.out.println("7. Ver actividades pendientes");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void procesarOpcion(int opcion) throws Exception {
        switch (opcion) {
            case 1:
                System.out.print("Nombre de la actividad: ");
                String nombre = reader.readLine();
                System.out.print("Hora (HH:MM): ");
                String hora = reader.readLine();
                insertarActividad(nombre, hora);
                break;
            case 2:
                Tareas eliminada = eliminarActividad();
                if (eliminada != null) {
                    System.out.println("Actividad eliminada: " + eliminada);
                }
                break;
            case 3:
                eliminarTodasActividades();
                System.out.println("Todas las actividades han sido eliminadas");
                break;
            case 4:
                cancelarActividad();
                System.out.println("Actividad cancelada y movida a pendientes");
                break;
            case 5:
                moverAlFinal();
                System.out.println("Actividad movida al final");
                break;
            case 6:
                System.out.println("Actividades activas:\n" + verActivasActivas());
                break;
            case 7:
                System.out.println("Actividades pendientes:\n" + verPendientes());
                break;
            case 0:
                System.out.println("Au revoir");
                break;
            default:
                System.out.println("No soy mago para entender ese input");
        }
    }
}
