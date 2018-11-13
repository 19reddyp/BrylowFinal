package models;

public class Review {
	private double rating;
	private String explanation;
	
	public Review(double xRating, String xExplanation) {
		rating = xRating;
		explanation = xExplanation;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
}
