<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  Carolyn Koerner  SWE632    -->



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Edited Information</title>

<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">

<link rel="stylesheet" title="default styles" href="header.css"
	media="screen" type="text/css">


</head>
<body onload="openPage()">

<jsp:include page="CompleteAdminHeader.jsp" />

<br><br><br><br>
	<h1>Edited Information:</h1>
	<br>
	<s:property value="firstname" />
	<br>
	<s:property value="lastname" />
	<br>
	<s:property value="streetaddress1" />
	<br>
	<s:property value="city" />
	<br>
	<s:property value="state" />
	<br>
	<s:property value="zipcode" />
	<br>
	<s:property value="email" />
	<br>
	<s:property value="username" />
	<br>
	<s:property value="password" />
	<br>
	<br>
	<s:property value="bio" />
	<br>
	<br>

	<s:iterator value="collectionOfTopics">
		<s:property value="username" />
		<br>
		<s:property value="password" />
		<br>
		<s:property value="topictitle" />
		<br>
		<s:property value="topicsummary" />
		<br>
	</s:iterator>
<br>

<table>
<tr>
<td>
<table >
	<tr>
	<td>
			Sarah Gallagher, Mason Speakers Coordinator<br /> Phone:
			703.993.8761 | Email: sgallag5@gmu.edu

	</td></tr>
</table>
</td >
	<td width="20%"></td>
	<td>
	<table>

<tr>
<td>


	<s:form action="logout">
		<s:submit value="Logout" cssClass="button" type="button"/>
	</s:form>
	
				
		</td>	
	</tr>

</table>
</td>
</tr>
</table>

				
</body>
</html>
