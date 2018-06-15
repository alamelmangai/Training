<%@ page import="com.cg.project.beans.UserBean" language="java"%>
<html>
<head>
<title>ErrorPage</title>
</head>
<body>
<div>
<%UserBean userBean = (UserBean)request.getAttribute("userBean");
%>
<font color='red'> SORRY wrong password or userName!!!</font>
</div>
</body>
</html>