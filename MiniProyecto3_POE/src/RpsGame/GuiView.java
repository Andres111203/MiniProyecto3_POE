package RpsGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GuiView extends JFrame {
    private JButton piedraButton = new JButton("Piedra");
    private JButton papelButton = new JButton("Papel");
    private JButton tijeraButton = new JButton("Tijera");
    private JLabel resultLabel = new JLabel("");
    private JLabel userLivesLabel = new JLabel("❤️❤️❤️");
    private JLabel computerLivesLabel = new JLabel("❤️❤️❤️");

    public GuiView() {
        setTitle("Piedra, Papel o Tijera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear un subpanel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Añadir botones al subpanel
        piedraButton.setActionCommand("piedra");
        papelButton.setActionCommand("papel");
        tijeraButton.setActionCommand("tijera");
        buttonPanel.add(piedraButton);
        buttonPanel.add(papelButton);
        buttonPanel.add(tijeraButton);

        // Añadir el subpanel al panel principal
        add(buttonPanel, BorderLayout.SOUTH);

        // Añadir la etiqueta de resultado en el centro del panel principal
        add(resultLabel, BorderLayout.CENTER);

        // Añadir las etiquetas de vidas en la parte superior del panel principal
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("Tus vidas: "));
        topPanel.add(userLivesLabel);
        topPanel.add(new JLabel("Vidas de la computadora: "));
        topPanel.add(computerLivesLabel);
        add(topPanel, BorderLayout.NORTH);

        // Configurar el tamaño de la ventana
        setSize(400, 200);
        setVisible(true);
    }

    public void setResult(String result) {
        resultLabel.setText(result);
    }

    public void updateLives(int userLives, int computerLives) {
        StringBuilder userHearts = new StringBuilder();
        StringBuilder computerHearts = new StringBuilder();
        for (int i = 0; i < userLives; i++) {
            userHearts.append("❤️");
        }
        for (int i = 0; i < computerLives; i++) {
            computerHearts.append("❤️");
        }
        userLivesLabel.setText(userHearts.toString());
        computerLivesLabel.setText(computerHearts.toString());
    }

    public void addGameListener(ActionListener listener) {
        piedraButton.addActionListener(listener);
        papelButton.addActionListener(listener);
        tijeraButton.addActionListener(listener);
    }
}