package models;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

@Entity
//@Table(name = "person")
public class Person {
	
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 6867242891615493437L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//	private int id;	
//    @Column(name = "nom")
//	private String nom;
//    @Column(name = "adress")
//	private String adress;
//    @Column(name = "password")
//	private String password;
//	
//	public Person() {
//		super();
//	}
//	
//	public Person(int id, String nom, String adress, String password) {
//		super();
//		this.id = id;
//		this.nom = nom;
//		this.adress = adress;
//		this.password = password;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getNom() {
//		return nom;
//	}
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getAdress() {
//		return adress;
//	}
//	public void setAdress(String adress) {
//		this.adress = adress;
//	}
//
//	@Override
//	public String toString() {
//		return "Person [id=" + id + ", nom=" + nom + ", adress=" + adress + ", password=" + password + "]";
//	}
	
	@Id
    int id;
    public void setId(int c) {id = c;}
    public int getId() {return id ;}

    @Column
    String nom;
    public void setNom(String n) {nom = n;}
    public String getNom() {return nom;}

    @Column
    String adress;
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	@Column
    String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
