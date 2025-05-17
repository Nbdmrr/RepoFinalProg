package co.edu.unbosque.modelo.persistencia;

import java.io.Serializable;

import co.edu.unbosque.modelo.Usuario;

public class UsuarioDTO implements Serializable{

    protected static final long serialVersionUID = 1L;
    protected String usuario;
    protected String contraseña;
    protected String nacionalidad;
    protected String tipo;
    protected String correo;

    // Getters y setters
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

   
}