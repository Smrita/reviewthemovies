package admin.app.dto;

public class Movie {

	private String movieName = null;
	private String releasedDate = null;
	private String pgRating = null;
	private String duration = null;
	private String summary = null;
	private String imageLink = null;
	private String videoLink = null;
	
	public void setMovieName(String mName)
	{
		this.movieName=mName;
	}
	public String getMovieName()
	{
		return movieName;
	}
	public void setReleasedDate(String rDate)
	{
		this.releasedDate=rDate;
	}
	public String getReleasedDate()
	{
		return releasedDate;
	}
	public void setPgRating(String pgRate)
	{
		this.pgRating=pgRate;
	}
	public String getPgRating()
	{
		return pgRating;
	}
	public void setDuration(String durtion)
	{
		this.duration=durtion;
	}
	public String getDuration()
	{
		return duration;
	}
	public void setSummary(String summary)
	{
		this.summary = summary;
	}
	public String getSummary()
	{
		return summary;
	}
	public void setImageLink(String imageLink)
	{
		this.imageLink= imageLink;
	}
	public String getImageLink()
	{
		return imageLink;
	}
	public void setDownloadLink(String downloadLink)
	{
		this.videoLink=downloadLink;
	}
	public String getDownloadLink()
	{
		return videoLink;
	}
}
