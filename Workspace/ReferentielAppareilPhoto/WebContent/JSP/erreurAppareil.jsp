<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/style.css" />
<title>Erreur</title>
</head>
<body>
	<h1>
		<bean:message key="label.common.title" />
	</h1>

	<html:messages id="err_name" property="common.file.err.image">
		<div>
			<p class="error">
				<bean:write name="err_name" />
			</p>
		</div>
	</html:messages>
	<html:messages id="err_name" property="common.file.err.pdf">
		<div>
			<p class="error">
				<bean:write name="err_name" />
			</p>
		</div>
	</html:messages>
</body>
</html>