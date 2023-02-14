package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 8633415090390966715L;
	
	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
    @GenericGenerator(strategy = "auto", name = "id")
	
    long id;
//    public void setId(long c) {id = c;}
    public long getId() {return id ;}

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
