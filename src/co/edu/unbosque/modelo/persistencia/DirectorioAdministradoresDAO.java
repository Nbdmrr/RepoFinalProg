package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Administrador;
import java.util.ArrayList;
import java.util.List;

public class DirectorioAdministradoresDAO implements InterfaceDAO<Administrador> {

    private List<Administrador> administradores;

    public DirectorioAdministradoresDAO() {
        this.administradores = new ArrayList<>();
    }

    @Override
    public boolean add(Administrador administrador) {
        if (administrador == null || administradores.contains(administrador)) {
            return false;
        }
        return administradores.add(administrador);
    }

    @Override
    public boolean delete(Administrador administrador) {
        return administradores.remove(administrador);
    }

    @Override
    public Administrador find(Administrador administrador) {
        for (Administrador a : administradores) {
            if (a.getUsuario().equals(administrador.getUsuario())) {
                return a;
            }
        }
        return null;
    }

    @Override
    public boolean update(Administrador administradorActual, Administrador administradorNuevo) {
        int index = administradores.indexOf(administradorActual);
        if (index != -1) {
            administradores.set(index, administradorNuevo);
            return true;
        }
        return false;
    }

    @Override
    public String getAll() {
        StringBuilder sb = new StringBuilder();
        for (Administrador administrador : administradores) {
            sb.append(administrador.getUsuario()).append(", ");
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "No hay administradores.";
    }
}
