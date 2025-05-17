package co.edu.unbosque.modelo.persistencia;

import java.io.Serializable;



public class EntrenadorDTO extends UsuarioDTO {
	
	
    private String equipo;

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

   
    
}
