package RpsGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class GameController {
    private GameModel model;
    private ConsoleView consoleView;
    private GuiView guiView;

    public GameController(GameModel model) {
        this.model = model;
    }

    public void setConsoleView(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }

    public void setGuiView(GuiView guiView) {
        this.guiView = guiView;
        this.guiView.addGameListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userChoice = e.getActionCommand();
                playGame(userChoice);
            }
        });
    }

    public void playGame(String userChoice) {
        try {
            model.setUserChoice(userChoice);
            model.generateComputerChoice();
            String result = model.determineWinner();

            if (result.equals("Perdiste")) {
                model.decreaseUserLives();
            } else if (result.equals("Ganaste")) {
                model.decreaseComputerLives();
            }

            if (consoleView != null) {
                consoleView.displayResult(result, userChoice, model.getComputerChoice(), model.getUserLives(), model.getComputerLives());
            }
            if (guiView != null) {
                guiView.setResult("Tú elegiste: " + userChoice + ", La computadora eligió: " + model.getComputerChoice() + ", Resultado: " + result);
                guiView.updateLives(model.getUserLives(), model.getComputerLives());
            }

            if (model.isGameOver()) {
                String finalResult = model.getUserLives() > 0 ? "¡Ganaste el juego!" : "¡Perdiste el juego!";
                if (guiView != null) {
                    JOptionPane.showMessageDialog(guiView, "Juego terminado. " + finalResult);
                    System.exit(0); // Terminar el programa
                }
                if (consoleView != null) {
                    System.out.println("Juego terminado. " + finalResult);
                    System.exit(0); // Terminar el programa
                }
            }
        } catch (IllegalArgumentException e) {
            if (consoleView != null) {
                consoleView.displayError(e.getMessage());
            }
        }
    }
}