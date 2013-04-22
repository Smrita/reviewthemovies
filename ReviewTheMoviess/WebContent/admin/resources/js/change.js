	function changeDirector() {

		arguments.callee.myDirVar = arguments.callee.myDirVar || 1;
		arguments.callee.myDirVar++;
		director_div.innerHTML = director_div.innerHTML
				+ "<br>"
				+ "<input size='10' type='text'  name='dfirstname' placeholder='firstname"+arguments.callee.myDirVar+"'>"
				+ "<input size='10' type='text'  name='dmiddlename' placeholder='middlename"+arguments.callee.myDirVar+"'>"
				+ "<input size='10' type='text'  name='dlastname' placeholder='lastname"+arguments.callee.myDirVar+"'>";

	}
	function changeWriter() {
		arguments.callee.myWrVar = arguments.callee.myWrVar || 1;
		arguments.callee.myWrVar++;
		writer_div.innerHTML = writer_div.innerHTML
				+ "<br>"
				+ "<input size='10' type='text'  name='wfirstname' placeholder='firstname"+arguments.callee.myWrVar+"'>"
				+ "<input size='10' type='text'  name='wmiddlename' placeholder='middlename"+arguments.callee.myWrVar+"'>"
				+ "<input size='10' type='text'  name='wlastname' placeholder='lastname"+arguments.callee.myWrVar+"'>";

	}
	function changeActors() {
		arguments.callee.myActrVar = arguments.callee.myActrVar || 1;
		arguments.callee.myActrVar++;
		actors_div.innerHTML = actors_div.innerHTML
				+ "<br>"
				+ "<input size='10' type='text'  name='afirstname' placeholder='firstname"+arguments.callee.myActrVar+"'>"
				+ "<input size='10' type='text'  name='amiddlename' placeholder='middlename"+arguments.callee.myActrVar+"'>"
				+ "<input size='10' type='text'  name='alastname' placeholder='lastname"+arguments.callee.myActrVar+"'>";

	}
	function changeGenres() {
		arguments.callee.myGenresVar = arguments.callee.myGenresVar || 0;
		arguments.callee.myGenresVar++;
		genres_div.innerHTML = genres_div.innerHTML
				+ "<br>"
				+ "<input size='10' type='text' name='genres' placeholder='genres"+arguments.callee.myGenresVar+"'>";
				
	};
	