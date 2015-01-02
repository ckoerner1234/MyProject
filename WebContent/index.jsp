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
<body >

	<jsp:include page="MyHeader.jsp" />
<% 

java.sql.Connection con;
java.sql.Statement s;
java.sql.ResultSet rs1;
java.sql.ResultSet rs2;
java.sql.PreparedStatement pst;

con=null;
s=null;
pst=null;
rs1=null;
rs2=null;

// Remember to change the next line with your own environment 
String url= "jdbc:mysql://localhost:3306/SWE632database";
String id= "root";
String pass = "password";
try{

Class.forName("com.mysql.jdbc.Driver");
con = java.sql.DriverManager.getConnection(url, id, pass);

}catch(ClassNotFoundException cnfex){
cnfex.printStackTrace();
}
%>

	<div align="center" class="well">

		<h2>Choose one of our talks for your next event.</h2>
			
		<table>
		<tr>
		<td>
		<s:form action="Search"  theme="simple" method="post">
				<s:textfield  name="mysearchstring"  id="mysearchstring" placeholder="Search" />
		</s:form>
		</td>
		<td width="20%"> </td>
		<td>
		<s:form action="SearchTopic"  theme="simple" method="post">
				<s:select label="Topics" name="selectedTopic" headerKey="-1"
				headerValue="Topic" onchange="this.form.submit()"
				id="selecttopics" 
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
				        'Real Estate':'Real Estate',
				        'Religion':'Religion',
				        'Research':'Research',
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
<%
String sql = "select * from SpeakerInfo";
try{
s = con.createStatement();
rs1 = s.executeQuery(sql);
%>
	<div style="width:100%; display:inline-block; vertical-align: top;">
<%
String speakerusername;
String speakerfirstname;
String speakerlastname;
String title;
String picture;
while( rs1.next() ){
	speakerusername = rs1.getString("username");
	speakerfirstname = rs1.getString("firstname");
	speakerlastname = rs1.getString("lastname");
	sql = "select * from Topics where username = '" + speakerusername + "'";
	System.out.println("sql: " + sql);
	
	s = con.createStatement();
	rs2 = s.executeQuery(sql);

	while (rs2.next()){
	title = rs2.getString("topictitle");
	picture = rs2.getString("topicpicture");
	System.out.println("picture: " + picture);
	%>	
	   <div style="max-width:150px; display:inline-block; vertical-align: top;">

			<s:url id="urlValue" action="GetTalk">
           <s:param name="selectedTalk"><%= title %></s:param>
        </s:url> 
        <br>
        <s:a href="%{urlValue}"><img src="<%= picture %>" width="150px" height="150px"
				style="box-shadow: 0px 0px 10px #888; margin: auto; 
				-moz-border-radius: 10px; border-radius: 10px; padding: 10px;"></s:a>
			
			<br>
			<div style="font-style: italic; max-width:140px;"><%= speakerfirstname %> <%= speakerlastname %></div>
			<div style="max-width: 140px; font-size:100%;"><%= title %></div>
	</div>

<%  } } }
catch(Exception e){e.printStackTrace();}
finally{System.out.println("Done");}%>
</div>

<br><br>

<table width="100%"><tr>

<td style="text-align:left">
<table>
<tr><th>Sarah Gallagher, Mason Speakers Coordinator</th></tr>
<tr><th>Phone:703.993.8761 | Email: sgallag5@gmu.edu</th></tr>
</table>
</td>

<th style="text-align:right; vertical-align:top;" >Speakers and Admin: 
    <button class="button"  id="btnOpenMe">Login</button></th>
</tr>
</table>

<div id="dialog" title="Login" style="display:none">
		<s:form action="CheckLogin" method="post" id="loginform"
			class="basicinfo" theme="simple">
		
			<table>
					<tr><th>Enter Username:</th></tr>
						<tr><td><s:textfield name="username" id="username"
								label="Enter Username" size="30" autofocus="true"
								cssClass="logintextfield" /></td></tr>

					<tr><th>Enter Password:</th></tr>

						<tr><td><s:textfield name="password" id="password"
								label="Enter Password" size="30" cssClass="logintextfield" /></td></tr>
			</table>
<br>
<table>
<tr>
	<td><s:submit type="button" cssClass="button" onclick="done()" /></td>
	<td><s:submit type="button" cssClass="button" onclick="done()" value="Cancel" action="CancelLogin" /></td>
</tr>
</table>
</s:form>
<br>

	</div>

</body>
</html>
