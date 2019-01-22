<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="CSS/style.css" />
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="/ReferentielAppareilPhoto/index.jsp">Accueil</a>
		</div>
		<ul class="nav navbar-nav">
			<li><html:link page="/listeMarque.do">Liste des marques</html:link></li>
			<li><html:link page="/listeModele.do">Liste des modèles</html:link></li>
			<li><html:link page="/listeAppareil.do">Liste des appareils</html:link></li>
		</ul>
	</div>
</nav>