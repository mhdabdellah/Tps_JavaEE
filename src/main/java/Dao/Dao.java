package Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<Model> {
	
	Optional<Model> get(int id);
    
    List<Model> getall();
    
    boolean save(Model model) throws SQLException;
    boolean update(Model model) throws SQLException;
    boolean delete(int id_person)throws SQLException;

}
