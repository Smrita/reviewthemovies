<%@include file="../includes/header.jsp"%>
<div id="wrapper">
	<div id="header">
		<p>
			<span style="color: #dbe3cc;">R</span>eview<span
				style="color: #dbe3cc;">T</span>he<span style="color: #dbe3cc;">M</span>ovies
		</p>
	</div>
	<div id="container">

		<div id="content">
			<form name="loginform" action="adminLogin" method="post">
				<table>
					<tr style="color: #FF0000;">
						<td colspan="2">${check}</td>
					</tr>
					<tr>
						<td>Admin Name:</td>
						<td><input type="text" name="adname" value=""></td>
					</tr>
					<tr>
						<td>Admin Password:</td>
						<td><input type="password" name="adpassword" value=""></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" name="btnsub"
							value="Enter Me"></td>
					</tr>
				</table>
			</form>
		</div>
		<!--endof content-->
	</div>
	<!--end of container-->
	<div class="clr"></div>
	<%@include file="../includes/footer.jsp"%>
</div>

</body>
</html>