<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact List</title>
<style type ="text/css">

.header {
  padding: 10px;
  text-align: left;
  background: #000000;
  color: white;
  font-size: 20px;
}

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
width: 50px;
height: 10px;
background-color: green;
color: white;
padding: 0.5cm;


}




</style>




</head>
<body>
<div class="header">
<form action ="getContactbyName" method= "get"> Search any of your contact by name : <input type="text" name="name"> <input type="submit" value="Search Contact by Name"></form>
<form action ="getContactByCategory" method= "get"> 
Search any of your contact by category : <select name="category"> <option>Category</option> <option>Family</option> <option>Friends</option> <option>Office</option></select><input type="submit" value="Search Contact by Category"></form>
</div>
<div class="header1">
  <h1>PHONEBOOK</h1>
  <p>Easiest way to have your contacts organized..!</p>
</div>






	<h2>New Contact</h2>

	<form action="addContact" method="post">

		<div>
			Mobile No : <input type="text" name="mobile">
		</div>

		<div>
			Name : <input type="text" name="name">
		</div>
		<div>
			Email : <input type="text" name="email">
		</div>
		<div>
			Category : <select name="category">
				<option>Category</option>
				<option>Family</option>
				<option>Friends</option>
				<option>Office</option>
			</select>
			
	    <div>
				Address Line : <input type="text" name="address.addressline">
			</div>
			<div>
				City : <input type="text" name="address.city">
			</div>

			<div>
				Pin Code : <input type="text" name="address.pincode">
			</div>
			
		</div>

		<div>
			<input type="submit" value="Add Basic Contact">
		</div>
		</form>
		
		
		<h3>CONTACT LIST</h3>

<%-- 	<div>
		<c:if test="${!empty contactList}">
		
		
	


			
		</c:if>
		
		<c:if test="${empty contactList}">
			<h4>No Contacts in Database</h4>
		</c:if>

	</div>

 --%>


<section class = "container">

<c:forEach items = "${contactList}" var = "profile">

<div class ="card">

<p>Contact Number: ${profile.mobile}</p>
<p>Contact Name: ${profile.name}</p>
<p>Contact Email: ${profile.email}</p>
<p>Contact Category: ${profile.category}</p>
<p>ADDRESS DETAILS</p>
<p>Addressline: ${profile.address.addressline}</p>
<p>City: ${profile.address.city}</p>
<p>Pincode: ${profile.address.pincode}</p>
<p><a href = "removeContact?mobile=${profile.mobile}"> Remove</a></p>


</div>

</c:forEach>



</section>




<!-- 
<form action ="getContactbyName" method= "get">
<div>
			Name : <input type="text" name="name">
</div>

<div>
			<input type="submit" value="Search Contact by Name">
</div>

</form> -->



<%-- <section class = "container">

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

</c:forEach> --%>

<!-- <section>

<form action ="getContactByCategory" method= "get">
	<div>
			Category : <select name="category">
				<option>Category</option>
				<option>Family</option>
				<option>Friends</option>
				<option>Office</option>
			</select>
			</div>
<div>
			<input type="submit" value="Search Contact by Category">
</div>

</form>
</section> -->

<h3> UPDATE ANY CONTACT</h3>
<form action= "update"   method ="get">
<div>
	Enter Mobile No for updating the Contact : <input type="text" name="mobile">
</div>
<div>
			<input type="submit" value="Update this Contact">
</div>

</form>




	
</body>
<footer>
<div class="footer">
  <p>©PHONEBOOK</p>
</div>

</footer>
</html>



