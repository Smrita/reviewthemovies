<%@include file="../includes/header.jsp"%>
<%@include file="../includes/nav.jsp"%>

<div id="container">
	<form name="frn" action="adminAdd" method="post"
		enctype="multipart/form-data" onsubmit="return validateForm()">
		<table>
			<tr>
				<td colspan="2"><h2>Add New Movies</h2></td>
			</tr>
			<tr>
				<td>Movie Name</td>
				<td><input type="text" name="moviename" value=""></td>
			</tr>
			<tr>
				<td>Released Date</td>
				<td><input type="text" name="releaseddate" value="">eg.
					yyyy-mm-dd</td>
			</tr>
			<tr>
				<td>PG Rating</td>
				<td><input type="text" name="pgrating" value=""></td>
			</tr>
			<tr>
				<td>Duration</td>
				<td><input type="text" name="duration" value="">eg.
					hh:mm:ss</td>
			</tr>
			<tr>
				<td>Summary</td>


				<td><textarea id="editor1" name="content" rows="10" cols="50"></textarea>
			</tr>


			<tr>
				<td>Director</td>
				<td><input type="button" value="+" onClick="changeDirector()"></td>
			</tr>
			<tr>
				<td></td>
				<td id="director_div"><input size='10' type='text'
					name="dfirstname" placeholder='firstname1' value=""><input
					size='10' type='text' name="dmiddlename" placeholder='middlename1'><input
					size='10' type='text' name="dlastname" placeholder='lastname1'>
				</td>
			</tr>

			<tr>
				<td>Writer</td>
				<td><input type="button" value="+" onClick="changeWriter()"></td>
			</tr>
			<tr>
				<td></td>
				<td id="writer_div"><input size='10' type='text'
					name='wfirstname' placeholder='firstname1' value=""><input
					size='10' type='text' name='wmiddlename' placeholder='middlename1'><input
					size='10' type='text' name='wlastname' placeholder='lastname1'>
			</tr>

			<tr>
				<td>Actors/Actress</td>
				<td><input type="button" value="+" onClick="changeActors()"></td>
			</tr>
			<tr>
				<td></td>
				<td id="actors_div"><input size='10' type='text'
					name='afirstname' placeholder='firstname1' value=""><input
					size='10' type='text' name='amiddlename' placeholder='middlename1'><input
					size='10' type='text' name='alastname' placeholder='lastname1'>
				</td>
			</tr>

			<tr>
				<td>Genres</td>
				<td><input type="button" value="+" onClick="changeGenres()"></td>
			</tr>
			<tr>
				<td></td>
				<td id="genres_div"><input size='10' type='text' name='genres'
					placeholder='genres1' value=""></td>
			</tr>

			<tr>
				<td>Image</td>
				<td><input type="file" name="image" value=""></td>
			</tr>
			<tr>
				<td>Video</td>
				<td><input type="file" name="video" value=""></td>
			</tr>


			<tr>
				<td></td>
				<td style="float: right;"><input type="submit" name="btnsub"
					value="Insert"></td>
			</tr>
		</table>
	</form>

</div>
<%@include file="../includes/footer.jsp"%>