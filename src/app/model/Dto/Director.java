package app.model.Dto;

public class Director {

		public int get_directorId() {
		return _directorId;
	}
	public void set_directorId(int _directorId) {
		this._directorId = _directorId;
	}
	public String get_firstName() {
		return _firstName;
	}
	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}
	public String get_middleName() {
		return _middleName;
	}
	public void set_middleName(String _middleName) {
		this._middleName = _middleName;
	}
	public String get_lastName() {
		return _lastName;
	}
	public void set_lastName(String _lastName) {
		this._lastName = _lastName;
	}
		private int _directorId;
		private String _firstName,_middleName,_lastName;
		
}
