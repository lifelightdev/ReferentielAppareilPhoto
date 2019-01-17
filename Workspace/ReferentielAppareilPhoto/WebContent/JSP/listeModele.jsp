<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="life.light.common.bean.Modele"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des modeles</title>
</head>
<body>	
	<form name="AppareilForm" action="/ReferentielAppareilPhoto/modeleAction.do">
		<table>
			<tr>
				<th>&nbsp;</th>
				<th>Marque</th>
				<th>Nom</th>
			</tr>
			<%
				List<Modele> list = (ArrayList) request.getAttribute("listeModele");
				Iterator itr = list.iterator();
				while (itr.hasNext()) {
					Modele modele = (Modele) itr.next();
			%>
			<tr>
				<td><input type="radio" name="idModele" value='<%=modele.getId()%>' onclick="javascript:enableEditDelete();"></td>
				<td><%=modele.getMarque().getNom()%></td>
				<td><%=modele.getNom()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="actionMethod" value="Ajouter"/></td>
				<td><input type="submit" name="actionMethod" id="editbutton" value="Editer" disabled="true" /></td>
				<td><input type="submit" name="actionMethod" id="deletebutton" value="Supprimer" disabled="true" onclick="return checkDelete();" /></td>
			</tr>
		</table>
	</form>
	<script>
		function checkDelete() {
			return confirm("Êtes-vous sûr de vouloir supprimer cette marque ?");
		}
		function enableEditDelete() {
			document.getElementById('editbutton').disabled = false;
			document.getElementById('deletebutton').disabled = false;
		}
	</script>
</body>
</html>