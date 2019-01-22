<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter une marque</title>
<link rel="stylesheet" href="CSS/style.css" />
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<h1>Ajouter une marque</h1>
	<div class="container">
	<html:form>
		<table>
			<tr>
				<td><div class="form-group">Nom</div></td>
				<td>
					<div class="form-group">
						<html:text property="nom"/>
					</div>
				</td>
			</tr>			
		</table>
		<table>
			<tr>
				<td><input type="submit" name="actionMethod" value="Enregistrer" class="btn"/></td>
				<td><input type="submit" name="actionMethod" value="Retour" class="btn"/></td>
			</tr>
		</table>
	</html:form>
	</div>
</body>
</html>