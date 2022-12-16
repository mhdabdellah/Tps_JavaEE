<%@page  import="models.Person" %>
<%@page  import="objetMetier.Operations" %>
<%@page  import="java.util.Iterator" %>
<%@page  import ="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		  <title>la liste des persons </title>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		  <link type="text/css" rel="stylesheet" href="staticfile/style.css" />
	</head>
	<body>
	
		<%@ include file="menu.jsp" %>
		<div class="container">
		  <h2>la liste des persons</h2>
		  <p>Vous pouvez voire tous les persons qui sont enregistree dans une liste des persons :</p>
		</div>
		
		<% 
			
			ArrayList<Person> persons = new ArrayList<Person>();
			persons = (ArrayList<Person>) request.getAttribute("personTable");
		        	
		        %>
		        
	<br><br>
	<div class="collapse navbar-collapse text-center" id="navbarSupportedContent">  
		        
		<form class="form-inline my-2 my-lg-0" method="get" action="Inscription">
			<h3> Vous pouvez obtenir le mot de passe correspondant au hash ici : </h3>
	      <input class="form-control mr-sm-2" name="hash" type="search" placeholder="siasir hash" aria-label="Search">
	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">retrouver le mot de pass</button>
	      
	      <div>
						<p class="succes">${empty password ? password :  "la mot de passe correspondant c'est : ".concat(password)}</p>
						
		  </div>
	    </form>
	</div>
	<br><br>
	<div class="text-center ">
	  	<table border="1" class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Id</th>
			      <th scope="col">Nom</th>
			      <th scope="col">Adress</th>
			      <th scope="col">Password</th>
			    </tr>
			  </thead>
			  
			   <% 
		        	Iterator<Person> list = persons.iterator();
		        	int index = 0;
		        	while(list.hasNext()){
		        		Person p = list.next();
		        	
		        %>
		        <tbody>
		            <tr>
		                <td scope="row"><%= index%></td>
		                <td><%= p.getNom() %></td>
		                <td><%= p.getAdress() %></td>
		                <td><%= p.getPassword() %></td>
		                
		            </tr>
		            
		        </tbody>
		        <%
		         index++;
		        	}
		        %>
		</table>
	  
	</div>
	
	</body>
</html>