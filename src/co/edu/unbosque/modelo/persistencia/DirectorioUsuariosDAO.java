package co.edu.unbosque.modelo.persistencia;

import co.edu.unbosque.modelo.Usuario;


public class DirectorioUsuariosDAO implements InterfaceDAO<Usuario>{
	
	public boolean add(Usuario x) {
		
		
		return false;
	};
	
	public boolean delete(Usuario x) {return false;};
	
	public Usuario find(Usuario x) {return null;};
	
	
	public boolean update(Usuario x, Usuario y) {return false;};
	
	@Override
	public String getAll() {
		
		return null;
	}

}
