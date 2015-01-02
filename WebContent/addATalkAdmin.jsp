<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">

<title>Add A Talk Here.</title>
</head>
<body>
	<jsp:include page="CompleteAdminHeader.jsp" />

	<br>
	<s:form action="ProcessAddATalk" method="post" id="surveyform"
		autocomplete="on" class="basicinfo" theme="simple">
		
		<table><tr><th>Title of Talk</th></tr>
		<tr><td><s:textfield name="topictitle" id="topictitle"
			label="Topic Title" size="30" labelposition="top"
			cssClass="speakertextfield" /></td></tr>
		</table>
		
		<table>		
		<tr><th>Topic Picture:</th></tr>
			<tr><td><s:textfield  name="topicpicture" 
			id="topicpicture" size="30" cssClass="speakertextfield"/></td></tr>
		</table>

		<table>
				<tr><th>Topic Summary:</th></tr>
				<tr><td>
					<s:textarea label=" " labelposition="top" name="topicsummary"
						id="topicsummary" cols="50" rows="10" cssClass="speakertextfield" />
				</td></tr>
		</table>
		
<br>		
		<p><strong>Categories </strong><br />
                    <table width="500" border="0" cellpadding="0">
                      <tr valign="top" >
                      <td><s:fielderror fieldName="checkbox" /></td>
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
<input type="checkbox" name="categories" value="None">None<br />
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
		
		
		<br>
		

		<s:hidden  name="username"
						id="username"  value="%{#session.session_admin_chosen_speaker}" />


		<table>
			<tbody>

				<tr>
					<td>
						<s:submit type="button" cssClass="button"/>
					</td>
										
					<td><a href="EditSpeakerData_Admin.jsp">
							<button class="button">Cancel</button>
					</a></td>

				</tr>
			</tbody>
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
		<s:submit value="Logout" cssClass="button" type="button"/>
</th>
	</s:form>

</tr>
</table>

</body>
</html>