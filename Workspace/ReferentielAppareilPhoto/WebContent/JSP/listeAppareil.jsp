<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="life.light.common.bean.Appareil"%>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.FileUtils" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des modeles</title>
</head>
<body>	
	<form name="AppareilForm" action="/ReferentielAppareilPhoto/appareilAction.do">
		<table>
			<tr>
				<th>&nbsp;</th>
				<th>Modele</th>
				<th>Type</th>
				<th>Photo</th>
				<th>Mode d'emploie</th>
			</tr>
			<%
				List<Appareil> list = (ArrayList) request.getAttribute("listeAppareil");
				Iterator itr = list.iterator();
				while (itr.hasNext()) {
					Appareil appareil = (Appareil) itr.next();
			%>
			<tr>
				<td><input type="radio" name="idAppareil" value='<%=appareil.getId()%>' onclick="javascript:enableEditDelete();"></td>
				<td><%=appareil.getModele().getMarque().getNom()%> - <%=appareil.getModele().getNom()%></td>
				<td><%=appareil.getType().getNom()%></td>
				<td><img width="50" height="50"src="<%=appareil.getUrlPhoto()%>"></td>
				<td>
					<a href="<%=appareil.getUrlModeEmploie()%>"><%=appareil.getNomFichierModeEmploie()%></a>	
				</td>
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
			return confirm("Êtes-vous sûr de vouloir supprimer cet appareil ?");
		}
		function enableEditDelete() {
			document.getElementById('editbutton').disabled = false;
			document.getElementById('deletebutton').disabled = false;
		}
	</script>
</body>
</html>