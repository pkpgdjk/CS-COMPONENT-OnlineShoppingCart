<%-- 
    Document   : add_result
    Created on : Nov 22, 2020, 4:00:53 PM
    Author     : ronnachai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update My Cart Quantity Success</title>
    </head>
    <body>
         <h1>Change <%=request.getAttribute("name")%> <%=request.getAttribute("old")%> to <%=request.getAttribute("new")%>  </h1>
        </br>
        <jsp:include page="my_cart.jsp" flush="true" />
    </body>
</html>
