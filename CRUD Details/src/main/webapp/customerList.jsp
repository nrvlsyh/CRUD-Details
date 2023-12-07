<%@page import="com.mvc.bean.detailsBean"%>
<%@page import="com.mvc.connection.DatabaseConnection"%>
<%@page import="com.mvc.dao.detDAO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Details List</title>
</head>
<body>

<div class="w3-container w3-margin">
<header class="w3-container w3-light-blue">
<div class="w3-container w3-center w3-wide w3-animate-fading">
	<h1><b>Details List</b></h1>
	</div>
</header>

<div class="w3-panel w3-padding-large w3-container">

 <!-------booking details table-------->
            <table  class="w3-table-all w3-centered">
                <tr class="w3-pale-green">
                    <th>NAME</th>
                    <th>PHONE NUMBER</th>
                    <th>EMAIL</th>
                    <th>DATE</th>
                    <th>PRICE</th>
                    <th>QUANTITY</th>
                    <th>DELIVERY</th>
                    <th>MESSAGE</th>
                    <th>EDIT</th>
                    <th>DELETE</th>
                </tr>

				<c:forEach items="${dets}" var="db" varStatus="message">
                <!------displaying booking details------>
                <tr>
                    <td>${db.name}</td>
                    <td>${db.phone}</td>
                    <td>${db.email}</td>
                    <td>${db.date}</td>
                    <td>${db.price}</td>
                    <td>${db.qty}</td>
                    <td>${db.delivery}</td>
                    <td>${db.message}</td>

                    <!------edit button---->
                    <td>
                    
                        <a href="detServlet?action=editDetails&detailsID=<c:out value="${db.detailsID}"/>" class="w3-button w3-round w3-green w3-hover-pale-yellow">Edit</a>
                        
                    </td>

                    <!--delete booking button--->
                    <td>
                        <a href="detServlet?action=deleteDetails&detailsID=<c:out value="${db.detailsID}"/>" class="w3-button w3-round w3-red w3-hover-pale-red">Delete</a>
                    </td>

                </tr>
                </c:forEach>

            </table>
            
            
 <div class="w3-panel">
<a href="detServlet?action=addDetails&detailsID=<c:out value="${db.detailsID}"/>" class="w3-button w3-block w3-teal w3-hover-grey">Submit another request</a>
 </div>
            
</div>
</div>

</body>
</html>