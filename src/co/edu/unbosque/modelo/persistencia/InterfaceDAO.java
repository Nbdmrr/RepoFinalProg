package co.edu.unbosque.modelo.persistencia;

public interface InterfaceDAO<T> {
    boolean add(T x);
    boolean delete(T x);
    T find(T x);
    boolean update(T x, T y);
    String getAll();
}
