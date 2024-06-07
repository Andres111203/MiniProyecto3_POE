package RpsGame;

import java.util.Random;

public class GameModel {
    private String userChoice;
    private String computerChoice;
    private final String[] options = {"piedra", "papel", "tijera"};
    private Random random = new Random();
    private int userLives = 3;
    private int computerLives = 3;

    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    public void generateComputerChoice() {
        computerChoice = options[random.nextInt(options.length)];
    }

    public String determineWinner() {
        if (userChoice.equals(computerChoice)) {
            return "Empate";
        } else if ((userChoice.equals("piedra") && computerChoice.equals("tijera")) ||
                   (userChoice.equals("papel") && computerChoice.equals("piedra")) ||
                   (userChoice.equals("tijera") && computerChoice.equals("papel"))) {
            return "Ganaste";
        } else {
            return "Perdiste";
        }
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getUserLives() {
        return userLives;
    }

    public int getComputerLives() {
        return computerLives;
    }

    public void decreaseUserLives() {
        if (userLives > 0) {
            userLives--;
        }
    }

    public void decreaseComputerLives() {
        if (computerLives > 0) {
            computerLives--;
        }
    }

    public boolean isGameOver() {
        return userLives <= 0 || computerLives <= 0;
    }
}