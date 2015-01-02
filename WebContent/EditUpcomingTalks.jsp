<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Edit Upcoming Talks</title>
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
	
	
	 <h1>Upcoming Talks:</h1> 
	 </div>
<br>
<s:form action="EditUpcomingTalks" theme="simple">
		<s:iterator value="upcomingtalks" status="rowStatus">
		
		    <table>
		    <tr valign="top"><th>Title of Talk</th> <td><s:textfield  size="70" autofocus="true"
						cssClass="speakertextfield" value="%{topictitle}" 
						name="listOfUpcomingTalks[%{#rowStatus.index}]"/></td></tr>
		    <tr valign="top"><th>Summary of Talk</th> <td><s:textarea  rows="8" cols="70"
						cssClass="speakertextfield" value="%{topicsummary}" 
						name="upcomingtalks[%{#rowStatus.index}].topicsummary"/></td></tr>
		    <tr valign="top"><th>Date</th> <td><s:textfield  size="70"
						cssClass="speakertextfield" value="%{date}" 
						name="upcomingtalks[%{#rowStatus.index}].date"/></td></tr>
		    <tr valign="top"><th>Location</th> <td><s:textarea  cols="70" rows="3"
						cssClass="speakertextfield" value="%{location}" 
						name="upcomingtalks[%{#rowStatus.index}].location"/></td></tr>
			</table>

			<br>
		</s:iterator>
		<br><br>
		<s:submit type="button" cssClass="button"/>
	
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
		Admin: <s:submit value="Logout" cssClass="button" type="button"/>
</th>
	</s:form>

</tr>
</table>

</body>
</html>
