<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact By Name</title>
<style type ="text/css">

.header1 {
  padding: 60px;
  text-align: center;
  background: #1abc9c;
  color: white;
  font-size: 30px;
}
.footer {
  text-align: center;
  padding: 1px;
  background-color: black;
  color: white;
}

.card{
    height: 280px;
    width : 200px;
    border-radius: 20px;
    border: 5px black solid;
    box-shadow: 0 0 10px gray;
    text-align: center;
    
}

.container{
  display: flex;
  justify-content: space-around;
  margin: 2cm;
  flex-wrap : wrap;

}

a{
width: 10px;
height: 20px;
background-color: green;
color: white;
padding: 0.2cm;


}
</style>




</head>
<body>

<div class="header1">
  <h1>PHONEBOOK</h1>
  <p>Easiest way to have your contacts organized..!</p>
</div>


<c:if test ="${empty profile}">
<h4>Sorry, You have no contacts available for the specified category..! </h4>
</c:if>



<section class = "container">

<c:forEach items = "${profile}" var = "profile">

<div class ="card">

<p>Contact Number: ${profile.mobile}</p>
<p>Contact Name: ${profile.name}</p>
<p>Contact Email: ${profile.email}</p>
<p>Contact Category: ${profile.category}</p>
<p>ADDRESS DETAILS</p>
<p>Addressline: ${profile.address.addressline}</p>
<p>City: ${profile.address.city}</p>
<p>Pincode: ${profile.address.pincode}</p>


</div>

</c:forEach>
</section>

<a href="">Return Back</a>







</body>

<footer>
<div class="footer">
  <p>©PHONEBOOK</p>
</div>

</footer>
</html>