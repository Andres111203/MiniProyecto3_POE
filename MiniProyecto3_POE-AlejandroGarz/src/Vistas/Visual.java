package Vistas;

import Controlador.controlador;
import Modelo.PiedraPapelTijera;
import Modelo.Opciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visual extends JFrame {
    private PiedraPapelTijera juego;
    private controlador ctrl;
    private JButton btnPiedra;
    private JButton btnPapel;
    private JButton btnTijera;
    private JButton btnJugar;
    private JLabel lblResultado;
    public Visual() {
        juego = new PiedraPapelTijera();
        ctrl = new controlador(juego);

        setTitle("Piedra, Papel o Tijera");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnPiedra = new JButton("PIEDRA");
        btnPapel = new JButton("PAPEL");
        btnTijera = new JButton("TIJERA");
        btnJugar = new JButton("JUGAR");
        lblResultado = new JLabel("");

        btnPiedra.addActionListener(ctrl);
        btnPapel.addActionListener(ctrl);
        btnTijera.addActionListener(ctrl);
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.setOpcMachine();
                Opciones opcUser = juego.getOpcUser();
                Opciones opcMachine = juego.getOpcMachine();
                String resultado = juego.jugar(opcUser, opcMachine);
                lblResultado.setText("Jugador: " + opcUser + ", Máquina: " + opcMachine + ". Resultado: " + resultado);
            }
        });

        add(btnPiedra);
        add(btnPapel);
        add(btnTijera);
        add(btnJugar);
        add(lblResultado);
    }
}