package co.edu.unbosque.modelo;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario {
    
    /** Nombre de usuario. */
    protected String usuario;
    
    /** Contraseña del usuario. */
    protected String contraseña;
    
    /** Nacionalidad del usuario. */
    protected String nacionalidad;
    
    /** Tipo de usuario. */
    protected String tipo;
    
    /** Correo electrónico del usuario. */
    protected String correo;

    /**
     * Constructor de la clase Usuario.
     * @param usuario Nombre de usuario.
     * @param contraseña Contraseña del usuario.
     * @param nacionalidad Nacionalidad del usuario.
     * @param correo Correo electrónico del usuario.
     */
    public Usuario(String usuario, String contraseña, String nacionalidad, String correo) {
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.nacionalidad = nacionalidad;
        this.correo = correo;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contraseña Contraseña del usuario.
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return Nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     * @param usuario Nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la nacionalidad del usuario.
     * @return Nacionalidad del usuario.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * Establece la nacionalidad del usuario.
     * @param nacionalidad Nacionalidad del usuario.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return Correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo Correo electrónico del usuario.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
