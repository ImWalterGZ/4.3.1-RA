import Stack.StackLinked;
import Ejercicios.Agenda;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Test Agenda");
            System.out.println("2. Test Establo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(reader.readLine());
                switch (opcion) {
                    case 1:
                        Agenda agenda = new Agenda();
                        agenda.test();
                        break;
                    case 2:
                        EstabloTest();
                        break;
                    case 0:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                opcion = -1;
            }
        } while (opcion != 0);

        reader.close();
    }
    
    public static void EstabloTest() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StackLinked<Double> establo = new StackLinked<Double>();

        System.out.println("Ingrese el peso de 10 hipopótamos:");

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.print("Peso del hipopótamo " + i + ": ");
                Double peso = Double.parseDouble(reader.readLine());
                establo.push(peso);
            }
            
            System.out.println("Establo original: " + establo);
            StackLinked<Double> establoOrdenado = establo.sort();
            System.out.println("Establo ordenado: " + establoOrdenado.toString());
            
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor ingrese un número válido");
        }
    }
}

