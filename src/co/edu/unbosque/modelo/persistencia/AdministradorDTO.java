package co.edu.unbosque.modelo.persistencia;

public class AdministradorDTO extends UsuarioDTO {
	private static final long serialVersionUID = 1L;
    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
