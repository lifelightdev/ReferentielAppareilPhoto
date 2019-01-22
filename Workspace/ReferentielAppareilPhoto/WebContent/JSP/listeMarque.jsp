<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="life.light.common.bean.Marque"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des marques</title>
<link rel="stylesheet" href="CSS/style.css" />
</head>
<body>	
	<jsp:include page="/menu.jsp" />
	<h1>Liste des marques</h1>
	<form name="MarqueForm" action="/ReferentielAppareilPhoto/marqueAction.do">
		<table class="table table-striped">
			<tr>
				<th>&nbsp;</th>
				<th>Nom</th>
			</tr>
			<%
				List<Marque> list = (ArrayList) request.getAttribute("listeMarque");
				Iterator itr = list.iterator();
				while (itr.hasNext()) {
					Marque marque = (Marque) itr.next();
			%>
			<tr>
				<td><input type="radio" name="idMarque" value='<%=marque.getId()%>' onclick="javascript:enableEditDelete();"></td>
				<td><%=marque.getNom()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="actionMethod" value="Ajouter" class="btn"/></td>
				<td><input type="submit" name="actionMethod" id="editbutton" value="Editer" disabled="true" class="btn"/></td>
				<td><input type="submit" name="actionMethod" id="deletebutton" value="Supprimer" disabled="true" onclick="return checkDelete();" class="btn"/></td>
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