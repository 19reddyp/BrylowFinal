package models;

public class Restaurant {
	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String hours;
	private String cuisine;
	private String type;
	private String price;
	private String imageURL;
	private ArrayUnsortedList<Item> menu;
	private ArrayUnsortedList<Review> reviews;

	public Restaurant(int id, String name, String address, String phone, String email, String hours, String cuisine,
			String type, String price, ArrayUnsortedList<Item> menu, ArrayUnsortedList<Review> reviews, String imageURL) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.hours = hours;
		this.cuisine = cuisine;
		this.type = type;
		this.price = price;
		this.menu = menu;
		this.reviews = reviews;
		this.imageURL = imageURL;

	}

	public void addMenu(Item toAdd) {
		menu.add(toAdd);
	}

	public void addReview(Review toAdd) {
		reviews.add(toAdd);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPriceRange() {
		double min = Double.MAX_VALUE;
		double max = 0;
		for (int x = 0; x < menu.numElements; x++) {
			double temp = menu.getNext().getPrice();
			if(temp<min) {
				min = temp;
			}
			if(temp>max) {
				max = temp;
			}
		}
		String xMin = Double.toString(min);
		String xMax = Double.toString(max);
		price = ("$"+xMin+" to $"+xMax); 
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String url) {
		this.imageURL = url;
	}

	public int getRating() {
		int num = reviews.numElements;
		double count = 0;
		for (int x = 0; x < num; x++) {
			count += reviews.getNext().getRating();
		}
		int avg = (int) count / num;
		return avg;
	}
	public ArrayUnsortedList<Review> getReview(){
		return reviews;
	}
	public ArrayUnsortedList<Item> getMenu(){
		return menu;
	}
}
