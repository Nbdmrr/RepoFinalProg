package co.edu.unbosque.modelo.persistencia;

import java.util.HashMap;
import java.util.Map;

public class MapHandler<K, V> {
    private Map<K, V> map;

    public MapHandler() {
        this.map = new HashMap<>();
    }

    public boolean add(K key, V value) {
        if (key == null || value == null || map.containsKey(key)) {
            return false;
        }
        map.put(key, value);
        return true;
    }

    public boolean delete(K key) {
        if (key == null || !map.containsKey(key)) {
            return false;
        }
        map.remove(key);
        return true;
    }

    public V find(K key) {
        return map.get(key);
    }

    public boolean update(K key, V newValue) {
        if (key == null || newValue == null || !map.containsKey(key)) {
            return false;
        }
        map.put(key, newValue);
        return true;
    }

    public String getAll() {
        if (map.isEmpty()) {
            return "No hay elementos.";
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append("Clave: ").append(key).append(", Valor: ").append(value).append("\n"));
        return sb.toString();
    }

    public Map<K, V> getMap() {
        return map;
    }
}
