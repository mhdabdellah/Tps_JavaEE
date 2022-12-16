package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objetMetier.Operations;
import models.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Dao.DaoPerson;


/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	
	DaoPerson PersonController = new DaoPerson();
	
	
	private static final long serialVersionUID = 1L;
	Operations op;
	 public static final String ATT_ERREURS = "erreurs";
	 public static final String ATT_RESULTAT = "resultat"; 
	 Map<String, String> listPassword ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	
    	op = new Operations();
    	listPassword = new HashMap<String, String>();
    	
    }
    
  //hash function to get the md5 hash  
  	public static String getMd5Hash(String input)  
  	{  
  		try   
  		{  
  			//static getInstance() method is called with hashing MD5  
  			MessageDigest md = MessageDigest.getInstance("MD5");  
  			//calculating message digest of an input that return array of byte  
  			byte[] messageDigest = md.digest(input.getBytes());  
  			//converting byte array into signum representation  
  			BigInteger no = new BigInteger(1, messageDigest);  
  			//converting message digest into hex value  
  			String hashtext = no.toString(16);  
  			while (hashtext.length() < 32)   
  			{  
  				hashtext = "0" + hashtext;  
  			}  
  			return hashtext;  
  		}  
  		//for specifying wrong message digest algorithms  
  		catch (NoSuchAlgorithmException e)   
  		{  
  			throw new RuntimeException(e);  
  		}  
  	}  
    
    /**
    * Valide l'adresse mail saisie.
    */
   private void validationEmail( String email ) throws Exception {
    if ( email != null && email.trim().length() != 0 ) {
	    if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	    	throw new Exception( "Merci de saisir une adresse mail valide." );
	    }
    } else {
    	throw new Exception( "Merci de saisir une adresse mail." );
    }
   }
   /**
    * Valide les mots de passe saisis.
    */
   private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception{
    if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
	    if (!motDePasse.equals(confirmation)) {
	    	throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
	    } else if (motDePasse.trim().length() < 3) {
	    	throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
	    }
    } else {
    	throw new Exception("Merci de saisir et confirmer votre mot de passe.");
    }
   }
   /**
    * Valide le nom d'utilisateur saisi.
    */
   private void validationNom( String nom ) throws Exception {
    if ( nom != null && nom.trim().length() < 3 ) {
    	throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
    }
   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String hash = request.getParameter("hash");
		
//		PersonBeans pb = new PersonBeans();
//		pb.setListe(op.gettAll());
		List<Person> persons = new ArrayList();
		persons = PersonController.getall();
		String password = listPassword.get(hash);
//		request.setAttribute("personTable" , op);
		request.setAttribute("personTable" , persons);
		request.setAttribute("listOfPassword", listPassword);
		request.setAttribute("password", password);
		request.getRequestDispatcher("listpersons.jsp").forward(request, response);
		
		 /* Affichage de la page d'inscription */
//		 this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		boolean usersaved = false;
		
		String nom = request.getParameter("nom");
		String address = request.getParameter("address");
		String mot_de_pass = request.getParameter("mot_de_pass");
		String confirm_mot_de_pass = request.getParameter("confirm_mot_de_pass");
		
		
		 /* Validation du champ email. */
		 try {
			 validationEmail( address );
		 } catch ( Exception e ) {
			 erreurs.put( "address", e.getMessage() );
		 }
		 /* Validation des champs mot de passe et confirmation. */
		 try {
			 validationMotsDePasse( mot_de_pass, confirm_mot_de_pass );
		 } catch ( Exception e ) {
			 erreurs.put( "mot_de_pass", e.getMessage() );
		 }
		 /* Validation du champ nom. */
		 try {
			 validationNom( nom );
		 } catch ( Exception e ) {
			 erreurs.put( "nom", e.getMessage() );
		 }
		 /* Initialisation du résultat global de la validation. */
		 if ( erreurs.isEmpty() ) {
			 
			 Person p = new Person(1,nom,address,getMd5Hash(mot_de_pass));
			 listPassword.put(getMd5Hash(mot_de_pass), mot_de_pass );
			 op.add(p);
			 try {
				usersaved = PersonController.save(p);
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 }
			 if(usersaved) {
				 resultat = "Succès de l'inscription.";
			 }else {
				 resultat = "Échec de l'inscription.";
			 }
		 } else {
			 resultat = "Échec de l'inscription.";
		 }
		 
		 /* Stockage du résultat et des messages d'erreur dans l'objet request */
		 request.setAttribute( ATT_ERREURS, erreurs );
		 request.setAttribute( ATT_RESULTAT, resultat );
		
		 /* Transmission de la paire d'objets request/response à notre JSP */
		 this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
