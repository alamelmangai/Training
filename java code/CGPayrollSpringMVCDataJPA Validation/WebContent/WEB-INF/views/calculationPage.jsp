<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<html>
<head>
<title>Calculation</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h2>To Calculate Salary</h2>
		<table>
			<form:form action="calculateUser" method="post" 
					modelAttribute="associate">
			
				<tr>
					<td>AssociateID:</td>
					<td><form:input path="associateID" size="30" /></td>
					<td><form:errors path="associateID" cssClass="error" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</form:form>
		</table>
	</div>
</body>
</html>