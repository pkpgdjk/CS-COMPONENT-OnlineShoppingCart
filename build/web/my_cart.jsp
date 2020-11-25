<%-- 
    Document   : showemployee
    Created on : Nov 22, 2020, 3:13:07 PM
    Author     : sarun
--%>

<%@page import="model.CartsTable"%>
<%@page import="model.Carts"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.DvdTable"%>
<%@page import="model.Dvd"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>
    </head>
    <jsp:useBean id="carts" class="model.Carts" scope="request"/>
     <%
                       
            List<Carts> cartLists = CartsTable.findAllCarts();
            Iterator<Carts> itr = cartLists.iterator();
            
     %>
    <body>
        <center>
        <h1>My Carts</h1>
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
                   carts = itr.next();
                   out.println("<tr>");
                   
                   out.println("<td> "+ carts.getId() + "</td>");
                   out.println("<td> "+ carts.getName() + "</td>");
                   out.println("<td> "+ carts.getRate() + "</td>");
                   out.println("<td> "+ carts.getYears() + "</td>");
                   out.println("<td> "+ carts.getPrice() + "</td>");
                   
                   out.println("<td>");
                   out.println("<form method='POST' action='./UpdateQuantityController'>");
                   out.println("<input type='text' name='qty' value='" + carts.getQty() + "'>");
                   out.println("<input type='hidden' name='id' value='" + carts.getId() + "'>");
                   out.println("<input type='submit' name='submit' value='Update Quantity'/>");
                   out.println("</form>");
                   out.println("</td>");
                   
                   out.println("</tr>");
               }
            %>
               
    </table>
            <a href="./checkout.jsp">
                <button>Check Out</button>
            </a>
            
            <br>
            
    <a href="index.html">Back to Menu</a>
    
 </center>
    </body>
</html>
