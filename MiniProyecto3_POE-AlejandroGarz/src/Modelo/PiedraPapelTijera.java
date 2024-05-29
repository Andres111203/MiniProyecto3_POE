package Modelo;

import java.util.Random;

public class PiedraPapelTijera {

    private Opciones opcUser;
    private Opciones opcMachine;


    public Opciones getOpcUser() {
        return opcUser;
    }
    public void setOpcUser(Opciones opcUser) {
        this.opcUser = opcUser;
    }
    public Opciones getOpcMachine() {
        return opcMachine;
    }

    public void setOpcMachine() {
        Opciones[] opc = Opciones.values();
        int opcAleatoria = new java.util.Random().nextInt(opc.length);
        this.opcMachine = opc[opcAleatoria];
    }

    public String jugar(Opciones opcUser, Opciones opcMachine){
        if (opcUser == opcMachine) {
            return "Empate";
        }

        switch (opcUser) {

            case PIEDRA:
                return (opcMachine == Opciones.TIJERA) ? "Jugador gana" : "Computadora gana";
            case PAPEL:
                return (opcMachine == Opciones.PIEDRA) ? "Jugador gana" : "Computadora gana";
            case TIJERA:
                return (opcMachine == Opciones.PAPEL) ? "Jugador gana" : "Computadora gana";
        }

        return "Error";
    
    }
    
}
