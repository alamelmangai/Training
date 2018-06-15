<%@ page import="com.cg.project.beans.UserBean" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SuccessPage</title>
</head>
<body>
<div>
<%UserBean userBean = (UserBean)request.getAttribute("userBean");
%>
<font color='red'> Welcome:<%=userBean.getUserName()%></font>
</div>
</body>
</html>