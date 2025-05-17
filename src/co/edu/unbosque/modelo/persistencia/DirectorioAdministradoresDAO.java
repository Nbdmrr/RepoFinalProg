package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Administrador;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectorioAdministradoresDAO implements InterfaceDAO<Administrador> {

    private ArrayList<Administrador> administradores;
    private Archivo archivo;

    public DirectorioAdministradoresDAO() {
        this.administradores = new ArrayList<>();
        archivo = new Archivo();
        
    }
    
    public void actualizarAdministradores() {
    	
    	administradores = archivo.leerArchivoAdministradores();
    	
    	
    }
    
    @Override
    public boolean add(Administrador x) {
    	if(find(x) == null) {
			administradores.add(x);
			archivo.escribirArchivoAdministradores(administradores);
			return true;
		}
    	return false;
    }
    @Override
    public boolean delete(Administrador x) {
    	Administrador y = find(x);
        if (y != null) {
            try {
                administradores.remove(y);
                archivo.getUbicacionArchivoAdministradores().delete();
                archivo.getUbicacionArchivoAdministradores().createNewFile();
                archivo.escribirArchivoAdministradores(administradores);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    	return false;
    }
    @Override
    public Administrador find(Administrador x) {
    	
    	for (Administrador p : administradores) {
            if (p.getUsuario().equals(x.getUsuario())) {
                return p;
            }
        
    	}// TODO Auto-generated method stub
    	return null;
    }
    
    
    	
     @Override
    public ArrayList<Administrador> getAll() {
    	// TODO Auto-generated method stub
    	return administradores;
    }
    @Override
    public boolean update(Administrador x, Administrador y) {
    	Administrador p = find(x);
        if (p != null) {
            try {
            	administradores.remove(p);
                p.setUsuario(y.getUsuario());
                p.setContraseña(y.getContraseña());
                p.setCargo(y.getCargo());
                p.setCorreo(y.getCorreo());
                p.setNacionalidad(y.getNacionalidad());
                archivo.getUbicacionArchivoAdministradores().delete();
                archivo.getUbicacionArchivoAdministradores().createNewFile();
                archivo.escribirArchivoAdministradores(administradores);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    	return false;
    }

    
}
