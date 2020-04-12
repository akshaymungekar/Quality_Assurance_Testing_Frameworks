package serializationDeserialization;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class VideoGame implements Serializable {

	public int id = 0;
	public String name;
	public String releaseDate;
	public int reviewScore = 0;
	public String category;
	public String rating;

	// List<String> courses; (for more than one data)

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;

	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRating() {
		return category;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	/*
	 * public List<String> getCourses() { return courses; }
	 * 
	 * public void setCourses(List<String> courses) { this.courses = courses; }
	 * 
	 */

	public String toString() {
		return (this.id + " " + this.name + " " + this.releaseDate + " " + this.reviewScore + " " + this.category + " "
				+ this.rating);
	}

	
	
}
