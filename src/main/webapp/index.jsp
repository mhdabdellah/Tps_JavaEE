<%@page  import="models.Person" %>
<%@page  import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		  <title>TP3 sur JAVA EE </title>
		  <meta charset="utf-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1">
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <link type="text/css" rel="stylesheet" href="staticfile/style.css" />
	</head>
	<body>
	<%@ include file="menu.jsp" %>
	<div class="container text-center">
	  <h2>Formulaire d'inscription</h2>
	  <p>Vous pouvez vous insicrir via ce formulaire :</p>
	</div>
	
	<fieldset>
 			<legend>Inscription</legend>
	
			<form method="post" action="Inscription">
			
				<h3> Vous pouvez vous insicrir via ce formulaire : </h3>
				<br/><br/>
				<div class="text-center">
				
					<div>
						<label align="left">Nom d'utilisateur : </label>
						<input align="left" type="text" name="nom" value=""  size="20" maxlength="20"/>
						<span class="erreur">${erreurs['nom']}</span>
					</div>
					<br>
					<div>
						<label align="left">Email : <span class="requis">*</span></label>
						<input align="left" type="text" name="email" value="" size="20" maxlength="60"/>
						<span class="erreur">${erreurs['email']}</span>
					</div>
					<br/>
					<div>
						<label align="left"> Telephone : <span class="requis">*</span></label>
						<input align="left" type="text" name="telephone" value="" size="20" maxlength="60"/>
					</div>
					<br/>
					<div>
						<label align="left">Addresse : <span class="requis">*</span></label>
						<input align="left" type="text" name="address" value="" size="20" maxlength="60"/>
					</div>
					<br/>
					<div>
						<label align="left">Mot de pass : <span class="requis">*</span></label>
						<input align="left" type="text" name="mot_de_pass" value=""  height="20" size="20" maxlength="20"/>
						<span class="erreur">${erreurs['mot_de_pass']}</span>
					</div>
					<br/>
					<div>
						<label align="left"> Confirmation du mot de pass : </label>
						<input align="left" type="text" name="confirm_mot_de_pass" value="" size="20" maxlength="20"/>
						<span class="erreur">${erreurs['confirm_mot_de_pass']}</span>
					</div>
					<br/><br/><br/>
					
					 <div class="col text-center">
				      <button class="btn  ">Inscription</button>
				    </div>
				</div>
				
				<div>
						<p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
				</div>
			</form>
		</fieldset>
	</body>
</html>