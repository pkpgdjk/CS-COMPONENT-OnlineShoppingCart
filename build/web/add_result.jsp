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
        <title>Add DVD To Carts Result</title>
    </head>
    <body>
         <h1><%=request.getAttribute("qty")%> <%=request.getAttribute("dvdName")%> added  </h1>
        </br>
        <jsp:include page="show_dvd.jsp" flush="true" />
    </body>
</html>
