package org.iesvdm;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

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
        // todo
    }

    private static void consultarMovimientos() {
        // todo
    }
}