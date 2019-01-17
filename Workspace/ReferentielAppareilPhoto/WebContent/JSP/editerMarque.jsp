<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marque</title>
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
				<td><input type="submit" name="actionMethod" value="MiseAJour" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>