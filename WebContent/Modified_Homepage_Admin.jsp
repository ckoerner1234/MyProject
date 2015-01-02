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
<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

<script src="jquery.js"></script>
<script src="jquery-ui.js"></script>
<script src="homepage_script.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $("#dialog").dialog({ autoOpen: false });
 
        $("#btnOpenMe").click(
            function () {
                $("#dialog").dialog('open');
                return false;
            }
        );
    });
</script>

</head>
<body onload="openPage()">

	<jsp:include page="CompleteAdminHeader.jsp" />


	<div align="center" class="well">

		<h2>Talks to Choose From</h2>
			
		<table>
		<tr>
		<td>
		<s:form action="Search"  theme="simple" method="post">
				<s:textfield  name="mysearchstring"  id="mysearchstring" value="%{mysearchstring}"  placeholder="Search"/>
				</s:form>
				</td>
		<td width="20%"> </td>
				<td>
				<s:form action="SearchTopic"  theme="simple" method="post">
				
				<s:select label="Topics" name="selectedTopic" headerKey="-1"
				headerValue="Topic"
				id="selecttopics" onchange="this.form.submit()"
				list="#{'Aging':'Aging',
				        'American Culture':'American Culture',
				        'Arts':'Arts',
				        'Business & Finance':'Business & Finance',
				        'Childhood Development & Parenting':'Childhood Development & Parenting',
				        'Communication':'Communication',
				        'Crime/Violence':'Crime/Violence',
				        'Cultural, Social & World Issues':'Cultural, Social & World Issues',
				        'Economic Development':'Economic Development',
				        'Education & Teaching':'Education & Teaching',
				        'Environment':'Environment',
				        'Ethics':'Ethics',
				        'George Mason University':'George Mason University',
				        'Government & Politics':'Government & Politics',
				        'Health, Nutrition, Exercise & Sports':'Health, Nutrition, Exercise & Sports',
				        'History':'History',
				        'Human Resource Management/Personnel':'Human Resource Management/Personnel',
				        'Judaic Studies':'Judaic Studies',
				        'Law Enforcement':'Law Enforcement',
				        'Leadership & Career Development':'Leadership & Career Development',
				        'Literature, Poetry & Writing':'Literature, Poetry & Writing',
				        'Nonprofit Organizations & Charities':'Nonprofit Organizations & Charities',
				        'Philosophy':'Philosophy',
				        'Psychology':'Psychology',
				        'Public Policy & the Law':'Public Policy & the Law',
				        'Religion':'Religion',
				        'Safety':'Safety',
				        'Science, Technology, Engineering & Math':'Science, Technology, Engineerign & Math',
				        'Transportation':'Transportation',
				        'Washington Metropolitan Regional Issues':'Washington Metropolitan Regional Issues'        
				        }"
				value="selectedTopic" />								
				
		</s:form>
		</td>
		</tr>
		</table>
	</div>


<div style="width:100%; display:inline-block; vertical-align: top;">
<% int count = 0; %>

<s:iterator value="topiclist">
             		
           <div style="max-width:150px; display:inline-block; vertical-align: top;">

			<s:url id="urlValue" action="GetTalk">
           <s:param name="selectedTalk" value="%{topictitle}"/>
                   </s:url> 
        <s:a href="%{urlValue}"><img src="<s:property value="topicpicture"/>" width="150" height="150"
				style="box-shadow: 0px 0px 10px #888; margin: auto; -moz-border-radius: 10px; border-radius: 10px; padding: 10px;"></s:a>
			
			
			<br>
			<div style="font-style: italic; max-width:140px;"><s:property value="firstname"/>
			<s:property value="lastname"/></div>
			
			<div style="max-width: 140px; font-size:100%;"><s:property value="topictitle" /></div>
			<% count=count+1; %>
			</div>


</s:iterator>
		</div>
<% if (count == 0) {%>
 <div align="center"><h2>Sorry, there are no talks under that Topic.  Please try again.</h2></div><br>
<%} %>
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
		<s:submit value="Logout" type="button" cssClass="button"/>
</th>
	</s:form>

</tr>
</table>

</body>
</html>