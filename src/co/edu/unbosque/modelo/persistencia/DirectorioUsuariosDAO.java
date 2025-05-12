package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Usuario;
import java.util.List;

public class DirectorioUsuariosDAO implements InterfaceDAO<Usuario> {

    private Archivo<Usuario> archivo;
    private List<Usuario> usuarios;

    public DirectorioUsuariosDAO(String rutaArchivo) {
        this.archivo = new Archivo<>(rutaArchivo);
        this.usuarios = archivo.cargar();
    }

    @Override
    public boolean add(Usuario usuario) {
        if (usuario == null || usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
            return false;
        }
        for (Usuario u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
                return false;
            }
        }
        boolean added = usuarios.add(usuario);
        if (added) {
            archivo.guardar(usuarios);
        }
        return added;
    }

    @Override
    public boolean delete(Usuario usuario) {
        boolean removed = usuarios.remove(usuario);
        if (removed) {
            archivo.guardar(usuarios);
        }
        return removed;
    }

    @Override
    public Usuario find(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean update(Usuario usuarioActual, Usuario usuarioNuevo) {
        int index = usuarios.indexOf(usuarioActual);
        if (index != -1) {
            usuarios.set(index, usuarioNuevo);
            archivo.guardar(usuarios);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        if (usuarios.isEmpty()) {
            return "No hay usuarios registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (Usuario usuario : usuarios) {
            sb.append("Usuario: ").append(usuario.getUsuario()).append("\n");
        }
        return sb.toString();
    }
}
