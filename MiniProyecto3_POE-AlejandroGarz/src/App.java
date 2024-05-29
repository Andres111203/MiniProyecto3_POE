import Modelo.Opciones;
import Modelo.PiedraPapelTijera;
import Controlador.controlador;
import Vistas.Visual;

import javax.swing.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cómo desea ejecutar el programa?");
        System.out.println("1. Interfaz Gráfica");
        System.out.println("2. Terminal");
        int choice = scanner.nextInt();

        if (choice == 1) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Visual visual = new Visual();
                    visual.setVisible(true);
                }
            });
        } else if (choice == 2) {
            PiedraPapelTijera juego = new PiedraPapelTijera();
            controlador ctrl = new controlador(juego);

            while (true) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. PIEDRA");
                System.out.println("2. PAPEL");
                System.out.println("3. TIJERA");
                System.out.println("4. JUGAR");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        juego.setOpcUser(Opciones.PIEDRA);
                        break;
                    case 2:
                        juego.setOpcUser(Opciones.PAPEL);
                        break;
                    case 3:
                        juego.setOpcUser(Opciones.TIJERA);
                        break;
                    case 4:
                        juego.setOpcMachine();
                        Opciones opcUser = juego.getOpcUser();
                        Opciones opcMachine = juego.getOpcMachine();
                        String resultado = juego.jugar(opcUser, opcMachine);
                        System.out.println("Jugador: " + opcUser + ", Máquina: " + opcMachine + ". Resultado: " + resultado);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            }
        } else {
            System.out.println("Opción no válida.");
        }

        scanner.close();
    }
}