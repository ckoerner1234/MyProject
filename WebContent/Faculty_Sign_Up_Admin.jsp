<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="header.css"
	media="screen" type="text/css">

<title>Add a Speaker</title>
<script src="jquery.js"></script>
<script src="jquery-ui.js"></script>
<script src="homepage_script.js"></script>

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
	<h1>Speaker Data</h1>
	<br>
	<s:form action="ProcessFacultyFormDataAdmin" method="post" id="surveyform"
		autocomplete="on" class="basicinfo"  theme="simple"  >
		<table>
				<tr>
				<td><label>First Name:</label></td>
					<td  class="speakerlabel"><s:textfield name="firstname" id="firstname" label="First Name"
						size="30"  autofocus="true"  cssClass="speakertextfield"/>
						</td>
				<td><s:fielderror fieldName="firstname" /></td>
				</tr>
				<tr>
				<td><label>Last Name:</label></td>
					<td  class="speakerlabel"> <s:textfield name="lastname" id="lastname" label="Last Name"
						size="30"  cssClass="speakertextfield" /></td>
				<td><s:fielderror fieldName="lastname" /></td>
				</tr>
				<tr>
				<td><label>Address 1:</label></td>
					<td  class="speakerlabel"> <s:textfield name="streetaddress1" id="streetaddress1"
						label="Street Address 1" size="30" labelposition="top" cssClass="speakertextfield"/></td>
				<td><s:fielderror fieldName="streetaddress1" /></td>
				</tr>
				<tr>
				<td><label>Address 2:</label></td>
					<td  class="speakerlabel">
					<s:textfield name="streetaddress2" id="streetaddress2"
						label="Street Address 2" size="30" labelposition="top" cssClass="speakertextfield"/></td>
				<td><s:fielderror fieldName="streetaddress2" /></td>
				</tr>
				<tr>
					<td><label>City:</label></td>
					<td  class="speakerlabel">
				<s:textfield name="city" label="City" id="city" size="30"
					labelposition="top" cssClass="speakertextfield"/></td>
				<td><s:fielderror fieldName="city" /></td>
				</tr>
				<tr>
				<td><label>State:</label></td>
				<td  class="speakerlabel">
					<s:textfield name="state" id="state" label="State" size="30"
						labelposition="top" cssClass="speakertextfield"/>
						</td>
				<td><s:fielderror fieldName="state" /></td>
				</tr>
				<tr>
					<td><label>Zip Code:</label></td>
					<td  class="speakerlabel"><s:textfield name="zipcode" id="zipcode" label="Zip Code" size="30"
						labelposition="top" cssClass="speakertextfield"/>
						</td>
				<td><s:fielderror fieldName="zipcode" /></td>
				</tr>
				<tr>
					<td><label>Phone:</label></td>
					<td  class="speakerlabel"><s:textfield name="phone" id="phone" label="Phone" size="30"
						labelposition="top" cssClass="speakertextfield"/>
						</td>
				<td><s:fielderror fieldName="phone" /></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td  class="speakerlabel"><s:textfield name="email" id="email" label="Email" size="30"
						labelposition="top" cssClass="speakertextfield"/></td>
				<td><s:fielderror fieldName="email" /></td>
				</tr>
				<tr>
					<td><label>Username:</label></td>
					<td  class="speakerlabel"><s:textfield name="username" id="username" label="Username" size="30"
						labelposition="top" cssClass="speakertextfield"/></td>
				<td><s:fielderror fieldName="username" /></td>
				</tr>
				<tr>
					<td><label>Password:</label></td>
					<td  class="speakerlabel"><s:textfield name="password" id="password" label="Password" size="30"
						labelposition="top" cssClass="speakertextfield"/></td>
				<td><s:fielderror fieldName="password" /></td>
				</tr>
		</table>

		<br>
		<br>


		<table>
		<tr><th>Biography:</th></tr>
		<tr><td>
		<s:textarea   name="bio" id="bio" 
			cols="100" rows="10"  cssClass="speakertextfield"/></td></tr>
		</table>

			<table>
			<tr><th>Title of Talk: </th></tr>
			<tr><td>
			<s:textfield name="topictitle"
						id="topictitle" label="Topic Title" size="30" 
						cssClass="speakertextfield"  /></td></tr>
			</table>
			

		<table>		
		<tr><th>Topic Summary:</th></tr>
			<tr><td><s:textarea  name="topicsummary" 
			id="topicsummary" cols="100" rows="10" cssClass="speakertextfield"/></td></tr>
		</table>
			<br>

		<table>		
		<tr><th>Topic Picture:</th></tr>
			<tr><td><s:textfield  name="topicpicture" 
			id="topicpicture" size="30" cssClass="speakertextfield"/></td></tr>
		</table>


	<br> <br>
		
		<p><strong>Categories </strong><br />
				<td><s:fielderror fieldName="checkbox" /></td>
                    <table width="500" border="0" cellpadding="0">
                      <tr valign="top" >
                      <td width="500"> 
       
<input type="checkbox" name="categories" value="Aging">Aging<br />
<input type="checkbox" name="categories" value="American Culture">American Culture<br />
<input type="checkbox" name="categories" value="Arts">The Arts (includes Film Studies, Theater)<br />
<input type="checkbox" name="categories" value="Business & Finance">Business and Finance (includes Bankruptcy, Creditors Rights, Estate Planning, International Business, Management, Stock Market, Taxes)<br />
<input type="checkbox" name="categories" value="Childhood Development & Parenting">Childhood Development and Parenting<br />
<input type="checkbox" name="categories" value="Communication">Communication (includes Conflict Resolution, Language, Media, Public Speaking, Team Building)<br />
<input type="checkbox" name="categories" value="Crime/Violence">Crime/Violence (includes Domestic Violence)<br />
<input type="checkbox" name="categories" value="Cultural, Social & World Issues">Cultural, Social and World Issues (includes Women's Issues)<br />
<input type="checkbox" name="categories" value="Economic Development">Economic Development<br />
<input type="checkbox" name="categories" value="Education & Teaching">Education and Teaching<br />
<input type="checkbox" name="categories" value="Environment">Environment<br />
<input type="checkbox" name="categories" value="Ethics">Ethics<br />
<input type="checkbox" name="categories" value="George Mason University">George Mason University<br />
<input type="checkbox" name="categories" value="Government & Politics">Government and Politics<br />
<input type="checkbox" name="categories" value="Health, Nutrition, Exercise & Sports">Health, Nutrition, Exercise and Sports<br />
<input type="checkbox" name="categories" value="History">History<br />
<input type="checkbox" name="categories" value="Human Resource Management/Personnel">Human Resource Management/Personnel<br />
<input type="checkbox" name="categories" value="Judaic Studies">Judaic Studies<br />
<input type="checkbox" name="categories" value="Law Enforcement">Law Enforcement (includes Espionage, Homeland Security, Terrorism)<br />
<input type="checkbox" name="categories" value="Leadership and Career Development">Leadership and Career Development<br />
<input type="checkbox" name="categories" value="Literature, Poetry & Writing">Literature, Poetry and Writing<br />
<input type="checkbox" name="categories" value="Nonprofit Organizations & Charities">Nonprofit Organizations and Charities (includes Fundraising)<br />
<input type="checkbox" name="categories" value="Philosophy">Philosophy<br />
<input type="checkbox" name="categories" value="Psychology">Psychology<br />
<input type="checkbox" name="categories" value="Public Policy & the Law">Public Policy and the Law<br />
<input type="checkbox" name="categories" value="Real Estate">Real Estate<br />
<input type="checkbox" name="categories" value="Religion">Religion<br />
<input type="checkbox" name="categories" value="Research">Research<br />
<input type="checkbox" name="categories" value="Safety">Safety (includes Driving)<br />
<input type="checkbox" name="categories" value="Science, Technology, Engineering & Math">Science, Technology, Engineering, and Math (includes Computers and Computing, Email, Internet, IT Security, Statistics, Systems and Systems Development, Technology Transfer)<br />
<input type="checkbox" name="categories" value="Transportation">Transportation<br />
<input type="checkbox" name="categories" value="Washington Metropolitan Regional Issues">Washington Metropolitan Regional Issues<br />   
                      </td>
                      </tr>
                    </table>               

	<br> <br>

		<table>
			<tbody>

				<tr>
					<td><s:submit type="button" cssClass="button"/></td>				
					<td><s:submit type="button" cssClass="button" value="Cancel" action="GoToAdminHomepage" /></td>								
				</tr>
			</tbody>
		</table>


	</s:form>
		<br> <br>
	<br>
	<br>
	


<table >
	<tr>
	<td>
			Sarah Gallagher, Mason Speakers Coordinator<br /> Phone:
			703.993.8761 | Email: sgallag5@gmu.edu

	</td></tr>
</table>


</body>
</html>