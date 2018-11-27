package database;

import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
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
						if (file.hasNextLine()) {
							test = file.nextLine();
						} else {
							break;
						}

					}
					reviews = new ArrayUnsortedList<Review>();
					while (test.equals("!!")) {
						String xRating = file.nextLine();
						String review = file.nextLine();
						int rating = Integer.parseInt(xRating);
						reviews.add(new Review(rating, review));
						if (file.hasNextLine()) {
							test = file.nextLine();
						} else {
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

	public void addReview(int restaurantID, int stars, String review) throws IOException {
		File temp = new File("restaurant.txt");
		
		Scanner file = new Scanner(temp);
		ArrayList<String> info = new ArrayList<String>();
		while (file.hasNextLine()) {
			info.add(file.nextLine());
		}
		if (!info.isEmpty()) {
			int indexOfRestaurant = -1;
			for (int x = 0; x < info.size(); x++) {
				if (info.get(x).equals("!!!!!")) {
					if (info.get(x + 1).equals(Integer.toString(restaurantID))) {
						indexOfRestaurant = x;
						break;
					}
				}
			}
			int indexOfReviews = -1;
			for(int i = indexOfRestaurant + 1; i < info.size(); i++) {
				if(info.get(i).equals("!!!!!") || info.get(i).equals("!!")) {
					indexOfReviews = i;
					break;
				}
			}
			info.add(indexOfReviews, review);
			info.add(indexOfReviews, Integer.toString(stars));
			info.add(indexOfReviews, "!!");
			Path path = Paths.get("restaurant.txt");
			Files.write(path,info,Charset.defaultCharset());
		}
	}

}
