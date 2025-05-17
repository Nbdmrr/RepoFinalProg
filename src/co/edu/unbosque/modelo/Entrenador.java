package co.edu.unbosque.modelo;

/**
 * Clase que representa a un entrenador en el sistema, heredando de la clase Usuario.
 * Contiene información específica sobre el equipo al que está asignado el entrenador.
 */
public class Entrenador extends Usuario {
    
    /** Nombre del equipo al que pertenece el entrenador. */
    private String equipo;

    /**
     * Constructor de la clase Entrenador.
     * @param usuario Nombre de usuario del entrenador.
     * @param contraseña Contraseña del entrenador.
     * @param nacionalidad Nacionalidad del entrenador.
     * @param correo Correo electrónico del entrenador.
     * @param equipo Nombre del equipo al que está asignado.
     */
    public Entrenador(String usuario, String contraseña, String nacionalidad, String correo, String equipo) {
        super(usuario, contraseña, nacionalidad, correo);
        this.setEquipo(equipo);
        tipo = "Entrenador";
    }

    /**
     * Obtiene el nombre del equipo al que pertenece el entrenador.
     * @return Nombre del equipo.
     */
    public String getEquipo() {
        return equipo;
    }

    /**
     * Establece el nombre del equipo al que pertenece el entrenador.
     * @param equipo Nombre del equipo.
     */
    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}