<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification d'un appareil</title>
<link rel="stylesheet" href="CSS/style.css" />
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<h1>Modification d'un appareil</h1>
	<div class="container">
	<html:form method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td><div class="form-group">Modèle</div></td>
				<td>
					<div class="form-group">					
						<html:select property="idModele">
							<html:optionsCollection name="AppareilForm" property="modeles" label="nom" value="id" />
						</html:select>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">Type</div></td>
				<td>
					<div class="form-group">
						<html:select property="idType">
							<html:optionsCollection name="AppareilForm" property="types" label="nom" value="id" />
						</html:select>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">Photo</div></td>
				<td>
					<div class="form-group">
						<html:file property="photo"/>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">Mode d'emploie</div></td>
				<td>
					<div class="form-group">
						<html:file property="modeEmploie"/>
					</div>
				</td>
			</tr>			
		</table>
		<table>
			<tr>
				<td><input type="submit" name="actionMethod" value="Sauvegarder" class="btn"/></td>
				<td><input type="submit" name="actionMethod" value="Retour" class="btn"/></td>
			</tr>
		</table>
	</html:form>
	</div>
</body>
</html>