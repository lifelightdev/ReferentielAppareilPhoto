<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<body>
	<html:form>
		<table>
			<tr>
				<td>Marque</td>
				<td>					
					<html:select property="idModele">
						<html:optionsCollection name="AppareilForm" property="modeles" label="nom" value="id" />
					</html:select>
				</td>
			</tr>
			<tr>
				<td>Type</td>
				<td>
					<html:select property="idType">
						<html:optionsCollection name="AppareilForm" property="types" label="nom" value="id" />
					</html:select>
				</td>
			</tr>			
		</table>
		<table>
			<tr>
				<td><input type="submit" name="actionMethod" value="Enregistre" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>