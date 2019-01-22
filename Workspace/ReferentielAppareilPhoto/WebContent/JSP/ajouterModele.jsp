<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un modèle</title>
<link rel="stylesheet" href="CSS/style.css" />
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<h1>Ajouter un modèle</h1>
	<div class="container">
	<html:form>
		<table>
			<tr>
				<td><div class="form-group">Marque</div></td>
				<td>
					<div class="form-group">					
						<html:select property="idMarque">
							<html:optionsCollection name="ModeleForm" property="marques" label="nom" value="id" />
						</html:select>
					</div>
				</td>
			</tr>
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