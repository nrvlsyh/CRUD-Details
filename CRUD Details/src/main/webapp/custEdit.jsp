<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Support System</title>
<link rel="stylesheet" href="css/custSupp.css">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;800&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
</head>

<body>

<div class="container" >
<h1><b>Lotus Biscoff Caramel Smores</b></h1>
<h2>We Are Still At Your Service</h2>
<p>We would love to respond to your queries and help you succeed.<br>Feel free to get in touch with us</p>

<div class="contact-box">

<div class="contact-left">
<h3>Details ID:</h3>

<form method="post" action="detServlet">
<h1><b><input type="text" id="detailsID" name="detailsID" readonly value="<c:out value="${db.detailsID}"/>"></b></h1>

<div class="input-row">

<div class="input-group">
<label>Name:</label>
<input type="text" id="name" name="name" value="<c:out value="${db.name}"/>">
</div>

<div class="input-group">
<label>Phone Number:</label>
<input type="text" id="phone" name="phone" value="<c:out value="${db.phone}"/>">
</div>
</div>

<div class="input-row">

<div class="input-group">
<label>Email:</label>
<input type="text" id="email" name="email" value="<c:out value="${db.email}"/>">
</div>

<div class="input-group">
<label>Date:</label>
<input type="text" id="datepicker" name="date" placeholder="dd/MM/yyy">
</div>
</div>

<div class="input-row">

<div class="input-group">
<label>Price:</label>
<input type="text" id="price" name="price" value="<c:out value="${db.price}"/>">
</div>

<div class="input-group">
<label>Quantity</label>
<input type="number" id="qty" name="qty" value="<c:out value="${db.qty}"/>">
</div>
</div>

<div class="input-row">



<h3><b>Type of Delivery:</b></h3>
  <input type="radio" id="cod" name="delivery" value="cod">
  <label for="cod">Cash on delivery</label><br>
  <input type="radio" id="pu" name="delivery" value="pick up">
  <label for="pu">Pick Up</label><br>
  <input type="radio" id="ship" name="delivery" value="shipping">
  <label for="ship">Shipping</label>


</div>

<label>Message/Report</label>
<textarea rows="5" name="message" value="<c:out value="${db.message}"/>">
</textarea>

<button type="submit">Update</button>
</form>
</div>

<div class="contact-right">
<h3>REACH US:</h3>

<table>
<tr>

<td style="color:white">Email:</td>
<td style="color:white">cewkiessmores@gmail.com</td>
</tr>

<tr>
<td style="color:white">Phone:</td>
<td style="color:white">+60 18-7907486</td>

<tr>
<td style="color:white">Address:</td>
<td style="color:white">UiTM Melaka Kampus Jasin, 77300, Merlimau, Melaka</td>
</tr>
</table>


</div>

</div>

</div>
</body>
</html>