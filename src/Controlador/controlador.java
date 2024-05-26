package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.PiedraPapelTijera;
import Modelo.Opciones;
//import vista. ; ----------------------------------------------------------


public class controlador implements ActionListener {

    PiedraPapelTijera Juego;
    //Vista ---------------------------------------------------------------

    public controlador(PiedraPapelTijera Juego) {

        this.Juego = Juego;
        //this.Vista = Vista; ----------------------------------------------------
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "PIEDRA":
                Juego.setOpcUser(Opciones.PIEDRA);
                break;
            case "PAPEL":
                Juego.setOpcUser(Opciones.PAPEL);
                break;
            case "TIJERA":
                Juego.setOpcUser(Opciones.TIJERA);
                break;
            case "JUGAR":
                Juego.setOpcMachine();
                Opciones opcUser = Juego.getOpcUser();
                Opciones opcMachine = Juego.getOpcMachine();
                String resultado = Juego.jugar(opcUser, opcMachine);
                //vista.mostrarResultado(opcUser, opcMachine, resultado); ---------------------------------------
                break;
            default:
                break;
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    
}
