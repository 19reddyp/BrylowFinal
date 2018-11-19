package models;

public class Item implements Comparable<Item>{
	private String name;
	private double price;

	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int compareTo(Item other) {
		if (price>other.getPrice()) {
			return 1;
		} else if (price == other.getPrice()) {
			return 0;
		} else {
			return -1;

		}
	}
}
