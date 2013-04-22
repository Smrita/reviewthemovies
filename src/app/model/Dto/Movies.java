package app.model.Dto;

import java.util.ArrayList;
import java.util.List;


public class Movies {

	private String _movieTitle,_genre,_summary,_pgRating,_length,_imageLink,_downloadLink,_releaseDate;
	float _rating;
	private int _movieId;
	private List<Writer> writer=new ArrayList <Writer>();
	private List<Actor> actor=new ArrayList<Actor>();
	private List<Director> director=new ArrayList<Director>();
	
	public List<Writer> getWriter() {
		return writer;
	}
	public void setWriter(List<Writer> writer) {
		this.writer = writer;
	}
	public List<Actor> getActor() {
		return actor;
	}
	public void setActor(List<Actor> actor) {
		this.actor = actor;
	}
	public List<Director> getDirector() {
		return director;
	}
	public void setDirector(List<Director> director) {
		this.director = director;
	}
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
	public String get_releaseDate(String _releaseDate){
		return _releaseDate;
	}
	public void set_releaseDate(String _releaseDate) {
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
