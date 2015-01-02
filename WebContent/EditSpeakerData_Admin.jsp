<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  Carolyn Koerner  SWE632    -->



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Speaker Information</title>

<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">

<link rel="stylesheet" title="default styles" href="header.css"
	media="screen" type="text/css">
<script src="homepage_script.js"> </script>


</head>
<body onload="openPage()">
<jsp:include page="CompleteAdminHeader.jsp" />
<s:if test="hasActionErrors()">
    <div class="errorDiv">
        <s:actionerror/>
    </div>
</s:if>
<br>

<br>

	<div>
		Edit the information for ${speaker.firstname} ${speaker.lastname} here.
	</div>

<br>


	<s:form action="ProcessEditFormDataAdmin" method="post" id="surveyform"
		autocomplete="on" class="basicinfo" theme="simple">
		<table>
			<tr>
				<td><label>First Name:</label></td>
				<td class="speakerlabel"><s:textfield name="firstname"
						id="firstname" label="First Name" size="30" autofocus="true"
						cssClass="speakertextfield" value="%{speaker.firstname}" /></td>
				<td><s:fielderror fieldName="firstname" /></td>
			</tr>
			<tr>
				<td><label>Last Name:</label></td>
				<td class="speakerlabel"><s:textfield name="lastname"
						id="lastname" label="Last Name" size="30"
						cssClass="speakertextfield" value="%{speaker.lastname}" /></td>
				<td><s:fielderror fieldName="lastname" /></td>
			</tr>



			<tr>
				<td><label>Address 1:</label></td>
				<td class="speakerlabel"><s:textfield name="streetaddress1"
						id="streetaddress1" label="Street Address 1" size="30"
						labelposition="top" cssClass="speakertextfield"
						value="%{speaker.streetaddress1}" /></td>
				<td><s:fielderror fieldName="streetaddress1" /></td>
			</tr>
			<tr>
				<td><label>Address 2:</label></td>
				<td class="speakerlabel"><s:textfield name="streetaddress2"
						id="streetaddress2" label="Street Address 2" size="30"
						labelposition="top" cssClass="speakertextfield"
						value="%{speaker.streetaddress2}" /></td>
				<td><s:fielderror fieldName="streetaddress2" /></td>
			</tr>
			<tr>
			<td><label>City:</label></td>
			<td class="speakerlabel"><s:textfield name="city" label="City"
					id="city" size="30" labelposition="top" cssClass="speakertextfield"
					value="%{speaker.city}" /></td>
				<td><s:fielderror fieldName="city" /></td>
			</tr>
			<tr>
				<td><label>State:</label></td>
				<td class="speakerlabel"><s:textfield name="state" id="state"
						label="State" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{speaker.state}" /></td>
				<td><s:fielderror fieldName="state" /></td>
			</tr>
			<tr>
				<td><label>Zip Code:</label></td>
				<td class="speakerlabel"><s:textfield name="zipcode"
						id="zipcode" label="Zip Code" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{speaker.zipcode}" /></td>
				<td><s:fielderror fieldName="zipcode" /></td>
			</tr>
			<tr>
				<td><label>Phone:</label></td>
				<td class="speakerlabel"><s:textfield name="phone" id="phone"
						label="Phone" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{speaker.phone}" /></td>
				<td><s:fielderror fieldName="phone" /></td>
			</tr>
			<tr>
				<td><label>Email:</label></td>
				<td class="speakerlabel"><s:textfield name="email" id="email"
						label="Email" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{speaker.email}" /></td>
				<td><s:fielderror fieldName="email" /></td>
			</tr>
			<tr>
				<td><label>Username:</label></td>
				<td class="speakerlabel"><s:textfield name="username"
						id="username" label="Username" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{speaker.username}" /></td>
				<td><s:fielderror fieldName="username" /></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td class="speakerlabel"><s:textfield name="password"
						id="password" label="Password" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{speaker.password}" /></td>
				<td><s:fielderror fieldName="password" /></td>
			</tr>
		</table>

		<br>
		<br>

		<h1>Biography:</h1>
		<table>
				<tr><td>
					<s:textarea label=" " labelposition="top" name="bio" id="bio"
						cols="100" rows="10" cssClass="speakertextfield"
						value="%{speaker.bio}" />
				</td></tr>
		</table>
		
<br>
 <h1> List of Talks:</h1> 
<br>
		<s:iterator value="collectionOfTopics" status="rowStatus">
		    <table>
		    <tr><th>Title of Talk</th><th width="30px">    </th><th  align="right">Delete</th></tr>
			<tr><td><s:textfield  name="collectionOfTopics[%{#rowStatus.index}].topictitle"
						id="topictitle" label="Topic Title" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{topictitle}" /></td>
						<td width="30px"></td>
					<td  align="right"><s:checkbox name="list_of_deleted_talks[%{#rowStatus.index}]" 
					value="false" theme="simple"/></td>	
						</tr>
			</table>
			<table>
		    <tr><th>Picture</th></tr>
			<tr><td>
			<s:textfield  name="collectionOfTopics[%{#rowStatus.index}].topicpicture"
						id="topicpicture" label="Topic Picture" size="30" labelposition="top"
						cssClass="speakertextfield" value="%{topicpicture}" />
						<br>
			</td></tr>
			</table>
		<table>		
		    <tr><th>Summary of Talk</th></tr>
			<tr><td><s:textarea label=" "  labelposition="top" 
			name="collectionOfTopics[%{#rowStatus.index}].topicsummary" 
			id="topicsummary" cols="100" rows="10" cssClass="speakertextfield" 
			value="%{topicsummary}"/></td></tr>
		</table>
		<s:hidden  name="collectionOfTopics[%{#rowStatus.index}].username"
						id="username"  value="%{speaker.username}" />
		<s:hidden  name="collectionOfTopics[%{#rowStatus.index}].password"
						id="password"  value="%{speaker.password}" />
		<s:hidden  name="collectionOfTopics[%{#rowStatus.index}].firstname"
						id="firstname"  value="%{speaker.firstname}" />
		<s:hidden  name="collectionOfTopics[%{#rowStatus.index}].lastname"
						id="lastname"  value="%{speaker.lastname}" />
		<br>

		</s:iterator>
		
	<br> <br> <br> <br>
	<table><tr>
	<td><s:submit type="button" cssClass="button"/></td>
    <td><s:submit type="button" cssClass="button" value="Delete This Speaker" action="deleteASpeaker" /></td>
    <td><s:submit type="button" cssClass="button" value="Add A Talk" action="AddATalkAdmin_simple" /></td>
    <td><s:submit type="button" cssClass="button" value="Cancel" action="GoToAdminHomepage" /></td>
    </tr>
    </table>
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
		Admin<s:submit value="Logout" cssClass="button" type="button"/>
</th>
	</s:form>

</tr>
</table>


</body>
</html>
