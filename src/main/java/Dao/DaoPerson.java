package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import connection.DBConnection;
import models.Person;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPerson implements Dao<Person>{
	private Connection connection;
	PreparedStatement ps;
    ResultSet rs;
    
	public DaoPerson(){
        DBConnection connector;
		try {
			connector = DBConnection.getInstance();
			this.connection = connector.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	@Override
	public Optional<Person> get(int id) {
		String requetSql = "select * from person where id = "+id+ "" ;
		Person person = null ;
        try{
            ps = connection.prepareStatement(requetSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int identification = rs.getInt(1);
                String nom = rs.getString(2);
                String address = rs.getString(3);
                String password = rs.getString(4);
                person = new Person(
                		identification,
                		nom,
                		address,
                		password);
                person.toString();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Optional.ofNullable(person);
	}

	@Override
	public List<Person> getall() {
	    List<Person> persons = new ArrayList();
        String requetSql = "select * from person";
        
     
        
        try {
            ps = connection.prepareStatement(requetSql);
            rs = ps.executeQuery();
            while (rs.next()) {
            	Person person = new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                
            	persons.add(person);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return persons;
	}

	@Override
	public boolean save(Person person) throws SQLException {
		try {
            String sql = "INSERT INTO person VALUES(null, ?, ?, ?)";

            boolean inseree = false;

            ps = connection.prepareStatement(sql);
            ps.setString(1, person.getNom());
            ps.setString(2, person.getAdress());
            ps.setString(3, person.getPassword());

            if (ps.executeUpdate() == 1) {
                inseree = true;
            }

            return inseree;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//        } finally {
//            ps.close();
//            connection.close();
        }
	}

	@Override
	public boolean update(Person person) throws SQLException {
		
		try {
            String sql = "UPDATE person SET nom = ?, adress = ?, password = ? WHERE id = ?";

            boolean respuesta = false;

            ps = connection.prepareStatement(sql);
            ps.setString(1, person.getNom());
            ps.setString(2, person.getAdress());
            ps.setString(3, person.getPassword());
            ps.setInt(4, person.getId());

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//        } finally {
//            ps.close();
//            connection.close();
        }
		
	}

	@Override
	public boolean delete(int id_person) throws SQLException {
		
		try {
            String sql = "DELETE FROM person WHERE id = " + id_person + "";

            boolean respuesta = false;

            
            ps = connection.prepareStatement(sql);

            if (ps.executeUpdate() == 1) {
                respuesta = true;
            }

            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, null, ex);
            return false;
//        } finally {
//            ps.close();
//            connection.close();
        }
	}

}
