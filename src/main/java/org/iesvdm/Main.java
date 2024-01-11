package org.iesvdm;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String ARCHIVO_MOVIMIENTOS = "movimientos.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1- Retirar fondos");
            System.out.println("2- Ingresar fondos");
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
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a ingresar: ");
                    double ingreso = scanner.nextDouble();
                    saldo += ingreso;
                    System.out.println("Ingreso exitoso. Saldo actual: " + saldo);
                    break;
                case 3:
                    // Esta opción será implementada en la versión "cajero v2"
                    System.out.println("Esta opción estará disponible en la versión 'cajero v2'");
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
        String mensaje = tipo + ": " + cantidad;
        try {
            Files.writeString(Path.of(ARCHIVO_MOVIMIENTOS), mensaje + System.lineSeparator(), StandardOpenOption.APPEND);
            System.out.println("Movimiento registrado: " + mensaje);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo de movimientos.");
        }
    }

    private static void consultarMovimientos() {
        try {
            List<String> lineas = Files.readAllLines(Path.of(ARCHIVO_MOVIMIENTOS));
            System.out.println("Historial de movimientos:");
            for (String linea : lineas) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de movimientos.");
        }
    }

}