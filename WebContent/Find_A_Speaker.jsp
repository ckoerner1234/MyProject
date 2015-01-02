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

<title>Find A Speaker</title>
<script src="jquery.js"></script>
<script src="jquery-ui.js"></script>
<script src="homepage_script.js"></script>

</head>
<body>

<jsp:include page="CompleteAdminHeader.jsp" />

<br><br>

<div>
<p>
Choose from the categories or speakers, then click the "submit" button. 
As an alternative, you may use keyword search.
</p>
</div>

		<style type="text/css">
label[for="searchfields"] {
	color: gray;
	font-size: large;
	text-align: left;
}label[for="categories"] {
	color: gray;
	font-size: large;
	font-weight: bold;
	text-align: left;
}
</style>
	<s:form action="ListTalks">
		<br>
		<div>
		<label for="categories">Categories:</label>
			<select name="categories" id="categories">
				<option value="all">ALL</option>
				<option value="aging">Aging</option>
				<option value="american-culture">American Culture</option>
				<option value="arts">Arts</option>
				<option value="business-finance">Business and Finance</option>
				<option value="childhood-development-parenting">Childhood
					Development and Parenting</option>
				<option value="communication">Communication</option>
				<option value="crimeviolence">Crime/Violence</option>
				<option value="economic-development">Economic Development</option>
				<option value="education-teaching">Education and Teaching</option>
				<option value="environment">Environment</option>
				<option value="ethics">Ethics</option>
				<option value="george-mason-university">George Mason
					University</option>
				<option value="government-politics">Government and Politics</option>
				<option value="history">History</option>
				<option value="human-resource-managementpersonnel">Human
					Resource Management/Personnel</option>
				<option value="judaic-studies">Judaic Studies</option>
				<option value="law-enforcement">Law Enforcement</option>
				<option value="leadership-career-development">Leadership
					and Career Development</option>
				<option value="nonprofit-organizations-charities">Nonprofit
					Organizations and Charities</option>
				<option value="philosophy">Philosophy</option>
				<option value="psychology">Psychology</option>
				<option value="public-policy-the-law">Public Policy and the
					Law</option>
				<option value="real-estate">Real Estate</option>
				<option value="religion">Religion</option>
				<option value="research">Research</option>
				<option value="safety">Safety</option>
				<option value="transportation">Transportation</option>
				<option value="washington-metropolitan-regional-issues">Washington
					Metropolitan Regional Issues</option>

			</select>
		</div>
	
		<br>

				<table>
				<tr>
				<s:select id="searchfields"  label="Speakers" headerKey="-1"
					headerValue="Select" list="listOfWholeNames" name="chosenSpeaker" />
					</tr>
					</table>
					<br>
					<table>
					<tr>
					<s:textfield id="searchfields" name="searchString" label="Search" />
					</tr>
					</table>
					<br>
		<table>
		<tr>
		<s:submit type="button" cssClass="button"/>
		</tr>
		</table>

	</s:form>
	<br>
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

<tr><th>Admin: <th>
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