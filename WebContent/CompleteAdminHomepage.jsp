<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>GMU Speaker's Page</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">


<script src="jquery.js"></script>
<script src="jquery-ui.js"></script>
<script src="homepage_script.js"></script>
<style>
td {
    vertical-align: top;
}
</style>

</head>
<body onload="adminlogin()">

	<jsp:include page="CompleteAdminHeader.jsp" />

	<div align="center" class="well">

		<h2>Search for a Speaker</h2>
			


		<s:form action="AdminSearchSpeaker"  theme="simple" method="post">
				<s:select id="searchfields"  headerKey="-1"
					headerValue="Select" list="listOfSpeakers" 
				listKey="username" listValue="firstname+lastname"
					name="chosenSpeaker"
					onchange="this.form.submit()" />
		</s:form>



<br><br><br><br><br><br><br><br>
<table width="100%"><tr>

<td style="text-align:left">
<table>
<tr><th>Sarah Gallagher, Mason Speakers Coordinator</th></tr>
<tr><th>Phone:703.993.8761 | Email: sgallag5@gmu.edu</th></tr>
</table>
</td>

	<s:form action="logout" theme="simple">
<th style="text-align:right; vertical-align:top;" >
		Admin <s:submit value="Logout" type="button" cssClass="button"/>
</th>
	</s:form>

</tr>
</table>



</body>
</html>
