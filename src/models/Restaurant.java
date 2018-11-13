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
	private ArraySortedList<Item> menu;
	private ArraySortedList<Review> reviews;

	public Restaurant(int id, String name, String address, String phone, String email, String hours, String cuisine,
			String type, String price, ArraySortedList<Item> menu, ArraySortedList<Review> reviews) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.hours = hours;
		this.cuisine = cuisine;
		this.type = type;
		this.price = price;
		menu = new ArraySortedList<Item>();
		reviews = new ArraySortedList<Review>();
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
