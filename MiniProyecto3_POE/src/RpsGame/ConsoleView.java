package RpsGame;

import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public String getUserChoice() {
        System.out.println("Elige una opción: piedra, papel, tijera");
        String choice = scanner.nextLine().toLowerCase();
        if (!choice.equals("piedra") && !choice.equals("papel") && !choice.equals("tijera")) {
            throw new IllegalArgumentException("Opción no válida: " + choice);
        }
        return choice;
    }

    public void displayResult(String result, String userChoice, String computerChoice, int userLives, int computerLives) {
        System.out.println("Tú elegiste: " + userChoice);
        System.out.println("La computadora eligió: " + computerChoice);
        System.out.println("Resultado: " + result);
        System.out.println("Tus vidas: " + userLives);
        System.out.println("Vidas de la computadora: " + computerLives);
    }

    public void displayError(String message) {
        System.out.println(message);
    }
}