function validateForm()
{
	
    if(document.forms["frn"]["moviename"].value == null || document.forms["frn"]["moviename"].value == "")
    {
      alert("Movie name must not be empty");
      return false;
    }

}