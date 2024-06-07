package RpsGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameModel model = new GameModel();
        GameController controller = new GameController(model);

        // Permitir al usuario elegir entre consola y GUI
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige el modo de juego: 1 para consola, 2 para interfaz gráfica (GUI)");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (choice == 1) {
            // Para la consola
            ConsoleView consoleView = new ConsoleView();
            controller.setConsoleView(consoleView);
            while (!model.isGameOver()) {
                try {
                    String userChoice = consoleView.getUserChoice();
                    controller.playGame(userChoice);
                } catch (IllegalArgumentException e) {
                    consoleView.displayError(e.getMessage());
                }
            }
        } else if (choice == 2) {
            // Para la interfaz gráfica
            GuiView guiView = new GuiView();
            controller.setGuiView(guiView);
        } else {
            System.out.println("Opción no válida");
        }
        scanner.close();
    }
}
