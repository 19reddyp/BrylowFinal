package models;

public class Review implements Comparable<Review>{
	private int rating;
	private String explanation;
	
	public Review(int xRating, String xExplanation) {
		rating = xRating;
		explanation = xExplanation;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public int compareTo(Review other) {
		if (rating>other.getRating()) {
			return 1;
		} else if (rating == other.getRating()) {
			return 0;
		} else {
			return -1;

		}
	}
}
