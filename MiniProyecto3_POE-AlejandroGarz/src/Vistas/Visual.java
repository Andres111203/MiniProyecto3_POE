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
}