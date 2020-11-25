<%-- 
    Document   : showemployee
    Created on : Nov 22, 2020, 3:13:07 PM
    Author     : sarun
--%>

<%@page import="java.util.Iterator"%>
<%@page import="model.DvdTable"%>
<%@page import="model.Dvd"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show All DVD Catalog</title>
    </head>
    <jsp:useBean id="dvd" class="model.Dvd" scope="request"/>
     <%
                       
            List<Dvd> dvdLists = DvdTable.findAllDvd();
            Iterator<Dvd> itr = dvdLists.iterator();
            
     %>
    <body>
        <center>
        <h1>DVD Catalog</h1>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Rate</th>
            <th>Years</th>
            <th>Price</th>
            <th>Quantity</th>
          </tr>
              <%
               while(itr.hasNext()) {
                   dvd = itr.next();
                   out.println("<tr>");
                   
                   out.println("<td> "+ dvd.getId() + "</td>");
                   out.println("<td> "+ dvd.getName() + "</td>");
                   out.println("<td> "+ dvd.getRate() + "</td>");
                   out.println("<td> "+ dvd.getYears() + "</td>");
                   out.println("<td> "+ dvd.getPrice() + "</td>");
                   
                   out.println("<td>");
                   out.println("<form method='POST' action='./AddDvdToCartController'>");
                   out.println("<input type='text' name='qty' value='1'>");
                   out.println("<input type='hidden' name='id' value='" + dvd.getId() + "'>");
                   out.println("<input type='submit' name='submit' value='AddToCart'/>");
                   out.println("</form>");
                   out.println("</td>");
                   
                   out.println("</tr>");
               }
            %>
           
            
                      
    </table>
    <a href="my_cart.jsp">Go To My Cart</a> <br>
    <a href="index.html">Back to Menu</a>
 </center>
    </body>
</html>
