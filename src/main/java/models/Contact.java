package models;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "contacts")
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 8633415090390966715L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150)
    private String email;

    @Column(length = 60)
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Contact() {
        super();
    }

    public Contact(Long id, String email, String telephone, Person person) {
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonBackReference
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}

