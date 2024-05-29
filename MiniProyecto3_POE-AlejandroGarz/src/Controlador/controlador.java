package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.PiedraPapelTijera;
import Modelo.Opciones;

public class controlador implements ActionListener {
    PiedraPapelTijera juego;

    public controlador(PiedraPapelTijera juego) {
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "PIEDRA":
                juego.setOpcUser(Opciones.PIEDRA);
                break;
            case "PAPEL":
                juego.setOpcUser(Opciones.PAPEL);
                break;
            case "TIJERA":
                juego.setOpcUser(Opciones.TIJERA);
                break;
            case "JUGAR":
                juego.setOpcMachine();
                Opciones opcUser = juego.getOpcUser();
                Opciones opcMachine = juego.getOpcMachine();
                String resultado = juego.jugar(opcUser, opcMachine);
                break;
            default:
                break;
        }
    }
}