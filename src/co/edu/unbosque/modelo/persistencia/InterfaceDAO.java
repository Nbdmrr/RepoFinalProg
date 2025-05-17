package co.edu.unbosque.modelo.persistencia;

import java.util.ArrayList;

public interface InterfaceDAO<T> {
    boolean add(T x);
    boolean delete(T x);
    T find(T x);
    boolean update(T x, T y);
    ArrayList<T> getAll();
}
