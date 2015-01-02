<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">
<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">

<title>Leave Feedback</title>
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

<jsp:include page="MyHeader.jsp" />



<br>
<br>
	<h1>Leave Feedback here for a talk you have seen.</h1>
	<br>
	<s:form action="ProcessFeedback" method="post" id="surveyform"
		autocomplete="on" class="basicinfo"  theme="simple"  >
		

		<table>		
		<tr><th>Comments:</th></tr>
			<tr><td><s:textarea  name="comment" 
			id="comment" cols="50" rows="10" cssClass="speakertextfield"/></td></tr>
		</table>
			<br>


	<br> <br>

		<table>
			<tbody>

				<tr>
					<td>
						<s:submit type="button" type="button"  cssClass="button"/>
					</td>
					<td><a href="index.jsp">
							<button class="button">Cancel</button>
					</a></td>
					
				</tr>
			</tbody>
		</table>


	</s:form>
		<br> <br>
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
	<td><s:submit type="button" cssClass="button" onclick="done()" value="Cancel" action="CancelLoginLeaveFeedback" /></td>
</tr>
</table>
</s:form>
<br>

	</div>


</body>
</html>