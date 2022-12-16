package models;

public class Person {
	private int id;	
	private String nom;
	private String adress;
	private String password;
	
	public Person() {
		super();
	}
	
	public Person(int id, String nom, String adress, String password) {
		super();
		this.id = id;
		this.nom = nom;
		this.adress = adress;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", nom=" + nom + ", adress=" + adress + ", password=" + password + "]";
	}
	
	
	

}