package co.edu.unbosque.modelo.persistencia;


import co.edu.unbosque.modelo.Torneo;

public class DirectorioTorneosDAO implements InterfaceDAO<Torneo>{
	
	
	public boolean add(Torneo x) {
		
		
		return false;
	};
	
	public boolean delete(Torneo x) {return false;};
	
	public Torneo find(Torneo x) {return null;};
	
	
	public boolean update(Torneo x, Torneo y) {return false;};
	
	@Override
	public String getAll() {
		
		return null;
	}

}
