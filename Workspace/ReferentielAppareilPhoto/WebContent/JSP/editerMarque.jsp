<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification d'une marque</title>
<link rel="stylesheet" href="CSS/style.css" />
</head>
<body>
	<html:form>
		<table>
			<tr>
				<td>Nom</td>
				<td>
					<html:text property="nom"/>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="actionMethod" value="Sauvegarder" /></td>
				<td><input type="submit" name="actionMethod" value="Retour" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>