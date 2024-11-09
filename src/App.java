import Stack.StackArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StackArray<Double> establo = new StackArray<Double>();

        System.out.println("Ingrese el peso de 10 hipopótamos:");

        try {
            for (int i = 1; i <= 10; i++) {
                System.out.print("Peso del hipopótamo " + i + ": ");
                Double peso = Double.parseDouble(reader.readLine());
                establo.push(peso);
            }


            reader.close();
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Por favor ingrese un número válido");
        }


        System.out.println("Establo origintal: " + establo);
        StackArray<Double> establoOrdenado = establo.sort();
        System.out.println("Establo ordenado: " + establoOrdenado.toString());
    }
}
