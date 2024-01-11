package org.iesvdm;

import java.io.*;
import java.util.Scanner;

public class version2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1- Retirar fondos");
            System.out.println("2- Ingresar fondos");
            System.out.println("3- Consulta de movimientos");
            System.out.println("0- Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("Saldo insuficiente. Saldo actual: " + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("Retiro exitoso. Saldo actual: " + saldo);
                        registrarMovimiento("Retiro", retiro);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a ingresar: ");
                    double ingreso = scanner.nextDouble();
                    saldo += ingreso;
                    System.out.println("Ingreso exitoso. Saldo actual: " + saldo);
                    registrarMovimiento("Ingreso", ingreso);
                    break;
                case 3:
                    System.out.println("Consulta de movimientos:");
                    consultarMovimientos();
                    break;
                case 0:
                    System.out.println("Gracias por usar el cajero. Saldo final: " + saldo);
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void registrarMovimiento(String tipo, double cantidad) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("movimientos.txt", true))) {
            writer.println(tipo + ": " + cantidad);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de movimientos.");
        }
    }

    private static void consultarMovimientos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("movimientos.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de movimientos.");
        }
    }
}
