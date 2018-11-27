package database;

import java.nio.file.*;
import java.util.Scanner;
import java.io.*;

import models.ArrayUnsortedList;
import models.Item;
import models.Restaurant;
import models.Review;

public class DatabaseClass {
	public DatabaseClass() {

	}

	public ArrayUnsortedList<Restaurant> getRestaraunts() throws IOException {
		File temp = new File("restaurant.txt");
		ArrayUnsortedList<Restaurant> list = new ArrayUnsortedList<Restaurant>();
		Scanner file = new Scanner(temp);
		int id;
		String name;
		String address;
		String phone;
		String email;
		String hours;
		String cuisine;
		String type;
		String price;
		String imageURL;
		ArrayUnsortedList<Item> menu;
		ArrayUnsortedList<Review> reviews;
		if (file.hasNextLine()) {
			String test = file.nextLine();
			while (file.hasNextLine()) {
				if (test.equals("!!!!!")) {
					String xId = file.nextLine();
					id = Integer.parseInt(xId);
					name = file.nextLine();
					address = file.nextLine();
					phone = file.nextLine();
					email = file.nextLine();
					hours = file.nextLine();
					cuisine = file.nextLine();
					type = file.nextLine();
					price = file.nextLine();
					imageURL = file.nextLine();
					test = file.nextLine();
					menu = new ArrayUnsortedList<Item>();
					while (test.equals("!")) {

						String itemName = file.nextLine();
						String xCost = file.nextLine();
						double cost = Double.parseDouble(xCost);
						menu.add(new Item(itemName, cost));
						if(file.hasNextLine()) {
							test = file.nextLine();
						}else {
							break;
						}
						
					}
					reviews = new ArrayUnsortedList<Review>();
					while (test.equals("!!")) {
						String xRating = file.nextLine();
						String review = file.nextLine();
						int rating = Integer.parseInt(xRating);
						reviews.add(new Review(rating, review));
						if(file.hasNextLine()) {
							test = file.nextLine();
						}else {
							break;
						}
					}
					list.add(new Restaurant(id, name, address, phone, email, hours, cuisine, type, price, menu, reviews,
							imageURL));

				}
			}
		}
		return list;
	}
}
