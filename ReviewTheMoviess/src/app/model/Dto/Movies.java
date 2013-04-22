package app.model.Dto;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Movies {

	private String _movieTitle,_genre,_summary,_pgRating,_length,_imageLink,_downloadLink;
	private List<String> _stars,_directors,_writers=new ArrayList<String>();
	private Date _releaseDate;
	float _rating;
	private int _movieId;
	
	public String get_movieTitle() {
		return _movieTitle;
	}
	public void set_movieTitle(String _movieTitle) {
		this._movieTitle = _movieTitle;
	}
	public String get_genre() {
		return _genre;
	}
	public void set_genre(String _genre) {
		this._genre = _genre;
	}
	public String get_summary() {
		return _summary;
	}
	public void set_summary(String _summary) {
		this._summary = _summary;
	}
	public List<String> get_directors() {
		return _directors;
	}
	public void set_directors(List<String> _directors) {
		this._directors = _directors;
	}
	public List<String> get_stars() {
		return _stars;
	}
	public void set_stars(List<String> _stars) {
		this._stars = _stars;
	}
	public List<String> get_writers() {
		return _writers;
	}
	public void set_writers(List<String> _writers) {
		this._writers = _writers;
	}
	public Date get_releaseDate() {
		return _releaseDate;
	}
	public void set_releaseDate(Date _releaseDate) {
		this._releaseDate = _releaseDate;
	}
	public float get_rating() {
		return _rating;
	}
	public void set_rating(float _rating) {
		this._rating = _rating;
	}
	
	public void set_movieId(int _movieId){
		this._movieId=_movieId;
	}
	
	public int get_movieId(){
		return _movieId;
	}

	public void set_pgRating(String _pgRating){
		this._pgRating=_pgRating;
	}

	public String get_pgRating(){
		return _pgRating;
	}
	
	public  void set_length(String _length){
		this._length=_length;
	}

	public String get_length(){
		return _length;
	}

	public void set_imageLink(String _imageLink){
		this._imageLink=_imageLink;
	}
	public String get_imageLink(){
		return _imageLink;
	}
	public void set_downloadLink(String _downloadLink){
		this._downloadLink=_downloadLink;
	}
	public String get_downloadLink(){
		return _downloadLink;
	}

}
