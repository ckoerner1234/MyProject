<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>About GMU Speakers</title>
<link rel="stylesheet" href="jquery-ui.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="header.css"
	media="screen" type="text/css">
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

            <p><!-- #BeginEditable "Body" -->
            <em>The subject matter and content of topics offered is at the discretion of individual Mason Speakers. Views expressed are solely those of the individual speakers and are not, nor should they be construed as, made on behalf of George Mason University. Any questions or concerns as to the appropriateness of topics for a given audience should be directed to Sarah Gallagher, Mason Speakers Coordinator, at (703) 993-8761.</em><br /><br />
            
            <strong>What is Mason Speakers? </strong><br />
              Faculty, researchers, administrators, and alumni volunteer their 
              time and expertise to present lectures and workshops on a multitude 
              of topics. Any group or business in the Washington Metro area is 
              welcome to invite a speaker to present a lecture at their site. 
              <br />
              <br />
              <strong>How much does it cost to have a Mason Speaker come to my organization?</strong> 
              <br />
              It is free! Mason is committed to providing this service to the 
              community that supports the University. We do require that organizations located more than 25 miles from the Fairfax campus reimburse the speaker's travel expense at the rate of 56.5 cents per mile.
 <br />
              <strong><br />
              How often may I schedule a Mason Speaker?</strong> Each community organization 
              may host a Mason Speaker up to three times per year.<br />
              <strong><br />
              What are the responsibilities of the host organization?</strong> <br />
              The organization that hosts the speaker is responsible for the following: 
              <br />
              <br />
              1. We ask host organizations to help us to get the word out about 
              this community resource. Organizations are asked to include the 
              following in any public relations material about the lecture:<br />
              <br />
              <strong>&quot; This lecture is made possible by George Mason University's 
              Mason Speakers. For further information contact <a href="http://communityrelations.gmu.edu/speakersbureau">http://communityrelations.gmu.edu/speakersbureau</a> 
              or call 703-993-8761.&quot;</strong><br />
              <br />
              2. Give an accurate estimate of participants (speakers incur expenses 
              reproducing handouts and prepare differently for various sized groups). 
              We require a minimum of 20 attendees. We reserve the right to cancel 
              the event if there are not enough audience participants. <br />
              <br />
              3. Provide us with as much information as possible regarding your 
              group so the speaker can tailor his remarks as appropriate <br />
              <br />
              4. Introduce the speaker - we will provide you with a short biography.<br />
              <br />
              5. Provide AV equipment as outlined in the topic description. <br />
              <br />
              What if I can't find a speaker for the topic that I am looking for? 
              <br />
              Please contact the coordinator, Sarah Gallagher at 703-993-8761 
              or at <strong><a href="mailto:sgallag5@gmu.edu">Sgallag5@gmu.edu</a></strong>. 
              You are not necessarily limited to the topics that are listed. Some 
              times speakers are willing to customize presentations for organizations. 
              <!-- #EndEditable --></p>



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
	<td><s:submit type="button" cssClass="button" onclick="done()" value="Cancel" action="CancelLoginAbout" /></td>
</tr>
</table>
</s:form>
<br>

	</div>

</body>
</html>