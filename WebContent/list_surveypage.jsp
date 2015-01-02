<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>List of Students</title>

<link rel="stylesheet" title="default styles" href="general.css"
	media="screen" type="text/css">

<style>
tr.blue {
	background-color: #0000FF;
	color: white;
}
</style>

</head>
<body class="surveybgcolor" bgcolor="#F4FA58">
	<h1 class="surveypageheader">List of Students</h1>


	<br>
	<table>

		<tr>
			<th width="15%">First Name</th>
			<th width="15%">Last Name</th>
			<th width="10%">Student ID</th>
			<th width="15%">Address</th>
			<th width="10%">City</th>
			<th width="5%">State</th>
			<th width="10%">Zip Code</th>
			<th width="20%">Email</th>
		</tr>



		<s:iterator value="collectionOfStudents">
			<tr class="blue">
				<td width="15%"><s:property value="firstname" /></td>
				<td width="15%"><s:property value="lastname" /></td>
				<td width="10%"><s:property value="studentid" /></td>
				<td width="15%"><s:property value="streetaddress1" /></td>
				<td width="10%"><s:property value="city" /></td>
				<td width="5%"><s:property value="state" /></td>
				<td width="10%"><s:property value="zipcode" /></td>
				<td width="20%"><s:property value="email" /></td>
			<tr>
		</s:iterator>

	</table>

</body>
</html>


