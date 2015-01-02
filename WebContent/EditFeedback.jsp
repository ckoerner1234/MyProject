<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Edit Feedback</title>
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
	
	
	 <h1>Feedback:</h1> 
<br>
<s:form action="EditFeedbackAdmin">
		<table>		
		<s:iterator value="listOfComments" status="rowStatus">
			<tr>
		    <table width="40%"><tr><th>Comment</th><th width="9px">Delete:</th>
			<td width="3px">
			<s:checkbox name="listOfDeletedComments[%{#rowStatus.index}]" value="false" theme="simple"/></td></tr>
			</table>
			</tr>
			
			<tr><td><s:textarea label=" "  labelposition="top" style="width:40%;"
			name="listOfComments[%{#rowStatus.index}]" 
			id="comment" cols="50" rows="10" cssClass="speakertextfield" ></s:textarea></td></tr>
			<!-- <tr><th>Publish:</th><td><s:checkbox name="listOfPublish[%{#rowStatus.index}]" value="true" theme="simple"/></td>  -->
		

		</s:iterator>
		</table>
		<br><br>
		<s:submit align="center" type="button" cssClass="button"/>
	
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
