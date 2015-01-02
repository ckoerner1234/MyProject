
<%@ taglib prefix="s" uri="/struts-tags"%>

<head>
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">
<script src="homepage_script.js"></script>
	
</head>
<style type="text/css">

loginbuttons {
	font-size: small;
}
ul,li {
	padding: 0;
	list-style: none;
}

/* Display parent unordered list items horizontally */
ul li {
	float: left;
	width: 120px;
	text-align: center;
	line-height: 21px;
}

ul li a {
	display: block;
	padding: 5px 10px;
	color: #333;
	background: #f2f2f2;
	text-decoration: none;
}

/* Hide inset unordered Lists */
ul li ul {
	display: none;
}

/* Un-Hide inset unordered Lists when parent <li> is hovered over */
ul li:hover ul {
	display: block;
	position: absolute;
	color: #fff;
	background: #939393;
}

/* Clear the any element that may be "float: left;" (Essentially moves the item to the next line */
ul li:hover ul li {
	clear: left;
}

input[type=submit]{
    font-size: small;
    color: blue;
}
</style>
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

<tr><th>Speaker's and Admin Login here: <th>
<td>		
					<input type="button" value="Login"  class="loginoutbuttons" name="login" 
					id="login" onclick="disable_enable(this)"
						onclick="showPopup(); return false;">			
					<input type="button" value="Logout"  class="loginoutbuttons" name="logout" 
					id="logout" onclick="disable_enable(this)">
		</td>	
	</tr>

</table>
</td>
</tr>
</table>




	<div id="popup" class="popover">
	<table>
	<tr><td>
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
					<td class="pushbutton"><s:submit type="button"
							onclick="done()" /></td>
							<td>    </td>
					<td class="pushbutton"><a href="index.jsp">
							<button type="button">Cancel</button>
					</a></td>
				</tr>
			</table>

</s:form>
</td></tr></table>
	</div>
