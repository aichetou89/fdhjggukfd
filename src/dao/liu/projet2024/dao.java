package dao.liu.projet2024;

import java.util.List;

public interface dao<T> {
	
	T get(String id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t, String[] params);
    
    void delete(T t);

}
