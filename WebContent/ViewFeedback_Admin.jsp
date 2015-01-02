<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>View Feedback</title>
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">
<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">


<script src="jquery.js"></script>
<script src="jquery-ui.js"></script>
<script src="homepage_script.js"></script>


</head>
<body onload="openPage()">

	<jsp:include page="CompleteAdminHeader.jsp" />
	<br>
<h1> Here is what others had to say about our speakers: </h1><br><br>
<s:iterator value="listOfComments" >

    <p style="max-width: 300px; font-size:100%;"><s:property/> </p>
</s:iterator>




<br><br>

<table width="100%"><tr>

<td style="text-align:left">
<table>
<tr><th>Sarah Gallagher, Mason Speakers Coordinator</th></tr>
<tr><th>Phone:703.993.8761 | Email: sgallag5@gmu.edu</th></tr>
</table>
</td>
	<s:form action="logout" theme="simple">
<th style="text-align:right; vertical-align:top;" >
		Admin<s:submit value="Logout" cssClass="button" type="button"/>
</th>
	</s:form>

</tr>
</table>


</body>
</html>
