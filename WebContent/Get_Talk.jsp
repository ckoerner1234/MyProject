<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Choose this Talk</title>
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
<jsp:include page="MyHeader.jsp" />
<br>
${speaker.firstname} ${speaker.lastname}
<br><br>
${selectedTalk}
<br><br>
${topicsummary}
<br><br>
If you would like to choose this talk for your event, please fill out the following information.  

<br><br>
<s:form action="RegisterSpeakerRequest" autocomplete="on" class="basicinfo"  theme="simple"  >
<table width="100%">
	<col width="40%"><col width="40%"> <col width="20%">
	<tr>
	<td  valign="top">
	
	
	<table>
	<col width="30%"><col width="30%"> <col width="40%">
	<tr>
	<td valign="top"><label>Organization:</label></td>
					<td valign="top" class="speakerlabel" ><s:textfield name="organization" 
						 autofocus="true"  cssClass="speakertextfield" />
						</td>
				<td valign="top"><s:fielderror fieldName="organization"  /></td>
						
				</tr>
 				<tr>
				<td valign="top"><label>Address:</label></td>
					<td  class="speakerlabel"> <s:textfield name="address"  
						  cssClass="speakertextfield" /></td>
				<td valign="top"><s:fielderror fieldName="address" /></td>
						
				</tr>
 				<tr>
				<td><label>City:</label></td>
					<td  class="speakerlabel"> <s:textfield name="city"  
						  cssClass="speakertextfield" /></td>
				<td valign="top"><s:fielderror fieldName="city" /></td>
				</tr>
 				<tr>
				<td valign="top"><label>State:</label></td>
					<td  class="speakerlabel"> <s:textfield name="state" 
						 cssClass="speakertextfield" /></td>
				<td valign="top"><s:fielderror fieldName="state" /></td>
				</tr>
 				<tr>
				<td valign="top"><label>Zip Code:</label></td>
					<td  class="speakerlabel"> <s:textfield name="zipcode" 
						  cssClass="speakertextfield" /></td>
				<td valign="top"><s:fielderror fieldName="zipcode" /></td>
				</tr>
 		</table>
 	</td>	
 	<td valign="top">	
 	<table>
	<col width="40%"><col width="30%"> <col width="30%">
	<tr>
	<td valign="top" ><label>Contact Person:</label></td>
					<td   valign="top" class="speakerlabel"><s:textfield name="contactperson" 
						size="30"  cssClass="speakertextfield"/>
						</td>
				<td valign="top"><s:fielderror fieldName="contactperson" /></td>
				</tr>
 				<tr>
				<td valign="top"><label>Email:</label></td>
					<td valign="top"  class="speakerlabel"> <s:textfield name="email"  
						size="30"  cssClass="speakertextfield" /></td>
				<td valign="top"><s:fielderror fieldName="email" /></td>
				</tr>
 				<tr>
				<td valign="top"><label>Phone:</label></td>
					<td  valign="top" class="speakerlabel"> <s:textfield name="phone"  
						size="30"  cssClass="speakertextfield" /></td>
				<td valign="top"><s:fielderror fieldName="phone" /></td>
				</tr>
 		</table>		
 	</td>	
</table>
		<br>
		<h2>Speaking Event Information</h2><br><br>
		<table width="60%">
	<col width="40%"><col width="30%"> <col width="30%">
	<tr>
	<td  valign="top"><label>Date of Event:</label></td>
	<td valign="top"><input type="date" name="date"></td>
	<td valign="top"><s:fielderror fieldName="date" theme="simple"/></td>
	</tr>
		
			
		<tr>
		<td valign="top"><label>Time:</label></td>
		<td valign="top"><input type="time" name="time"/></td>
		<td valign="top"><s:fielderror fieldName="time" theme="simple"/></td>
		</tr>
		
		</table>
		<br><br>
		
 <s:submit name="submit" label="Submit" type="button" cssClass="button"/>
</s:form>


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


<br>
</body>
</html>