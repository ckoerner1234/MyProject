
<%@ taglib prefix="s" uri="/struts-tags"%>


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

