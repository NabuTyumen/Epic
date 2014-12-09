
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*,java.lang.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login</title>
<%String version = (String) request.getSession().getAttribute("version");%>
<link rel="icon" href="<%=request.getContextPath()%>/img/favicon.png" />
<!--[if IE]><link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/img/favicon_w.ico" /><![endif]-->
<script language="Javascript1.1" type="text/javascript">
    

</script>
<!-- Inport css file-->
<link rel="stylesheet" href="css/main.css?version=<%=version%>" type="text/css"/>
</head>

<body>
<div id="content">
<h1>Sema</h1>
<div id="logbox">

</div>
</div>



</body>
</html>
