import Stack.StackLinked;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        EstabloTest();
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

            reader.close();
            
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

