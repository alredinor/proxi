<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/styleArt.css">
<title>Art-Proxi</title>
</head>

<body>
	<div id="logo">
		<img src="img/logo.png">
	</div>

	<div id="banniere" class="row">
		<div class="col-10 col-lg-11"></div>
		<div class="col-2 col-lg-1">
			<ul>
				<li>abbbb</li>
			</ul>
		</div>
	</div>

	<div id="content" class="row">
		<div class="col-12 col-lg-1">
			<form name="Formulaire" action="login">

				<fieldset>
					<legend>Informations personnelles</legend>
					<table>

						<tr>
							<td>Identifiant</td>
							<td><input id="identifiant" name="identifiant" required placeholder="identifiant"></td>
						</tr>

						<tr>
							<td>Mot de passe</td>
							<td><input id="mdp" name="mdp" type="password" placeholder="*********"></td>
						</tr>
						<tr>
							<td><input type="submit" value="Valider"></td>
						</tr>
							
					</table>
				</fieldset>
			</form>
			
			
		</div>
	</div>

	<div class="row">
		<div id="footer" class="col-12">© Copyright Art-Proxi SOPRA
			STERIA - 2020-2021</div>
	</div>
</body>
</html>