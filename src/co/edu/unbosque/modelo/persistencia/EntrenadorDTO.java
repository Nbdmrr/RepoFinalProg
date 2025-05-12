package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Entrenador;

public class EntrenadorDTO extends UsuarioDTO {
    private String equipo;

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    // Método para convertir DTO a entidad Entrenador
    public Entrenador toEntity() {
        return new Entrenador(usuario, contraseña, nacionalidad, correo, equipo);
    }

    // Método para convertir entidad Entrenador a DTO
    public static EntrenadorDTO fromEntity(Entrenador entrenador) {
        EntrenadorDTO dto = new EntrenadorDTO();
        dto.setUsuario(entrenador.getUsuario());
        dto.setContraseña(entrenador.getContraseña());
        dto.setNacionalidad(entrenador.getNacionalidad());
        dto.setCorreo(entrenador.getCorreo());
        dto.setEquipo(entrenador.getEquipo());
        return dto;
    }
}
