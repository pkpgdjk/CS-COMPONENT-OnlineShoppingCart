<%-- 
    Document   : showemployee
    Created on : Nov 25, 2020, 3:13:07 PM
    Author     : ronnachai
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
        <title>Checkout</title>
    </head>
    <jsp:useBean id="carts" class="model.Carts" scope="request"/>
     <%
            Double total = 0.0;
            List<Carts> cartLists = CartsTable.findAllCarts();
            Iterator<Carts> itr = cartLists.iterator();
            while(itr.hasNext()) {
                   carts = itr.next();
                   Integer qty = carts.getQty();
                   Double price = carts.getPrice();
                   total += price * qty;
                   CartsTable.removeCarts(carts.getId());
               }
            
     %>
    <body>
        <center>
            <h1>Your Orders have been confirmed!</h1>
            <h2>The total amount is <%=total%></h2>
            <a href="./index.html"> go back to menu </a>
        </center>
    </body>
</html>
