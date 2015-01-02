<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<link rel="stylesheet" title="default styles" href="Simplex.css"
	media="screen" type="text/css">
<link rel="stylesheet" title="default styles" href="header.css"
	media="screen" type="text/css">
</head>

<header>
<table  width="100%">
<tr>
		<td style="text-align:left; vertical-align:top;"><h1> GMU Speaker's Page</h1> </td>
				
		<td style="text-align:right; vertical-align:top;">
		<ul style="display: table; margin: 0 auto;">
			<li><a href="index.jsp">Home</a></li>

			<li><a href="#">Speakers &#9662;</a>
				<ul>
					<li><a href="Faculty_Sign_Up.jsp">Sign-Up</a></li>
				</ul></li>

			<li><a href="#">Feedback &#9662;</a>
				<ul>
					<li><a href="LeaveFeedback.jsp">Leave Feedback</a></li>
					<li><a href="<s:url action='ViewFeedback' />">View
							Feedback</a></li>

				</ul></li>

			<li><a href="<s:url action='AboutPage' />">About</a></li>
			<li><a href="<s:url action='UpcomingTalks' />">Upcoming Talks</a></li>

		</ul>
			
		
		</td>

		</tr>
</table>
</header>
