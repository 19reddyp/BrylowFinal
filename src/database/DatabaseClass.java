package database;
import java.nio.file.*;
import java.io.*;

import models.ArrayUnsortedList;
import models.Item;
import models.Restaurant;
import models.Review;

public class DatabaseClass {
	public DatabaseClass() {
		
	}
	public ArrayUnsortedList<Restaurant> getRestaraunts(){
		
		String location = "/BrylowFinal/src/database/RestaurantList";
		ArrayUnsortedList<Restaurant> list = new ArrayUnsortedList<Restaurant>();
		Path restaurantPath = FileSystems.getDefault().getPath(location);
		try {
			BufferedReader bufferedReader = Files.newBufferedReader(restaurantPath);
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
			
			String test = bufferedReader.readLine();
			while(test != null) {
				if(test.equals("!!!!!")) {
					String xId = bufferedReader.readLine();
					id = Integer.parseInt(xId);
					name = bufferedReader.readLine();
					address = bufferedReader.readLine();
					phone = bufferedReader.readLine();
					email = bufferedReader.readLine();
					hours = bufferedReader.readLine();
					cuisine = bufferedReader.readLine();
					type = bufferedReader.readLine();
					price = bufferedReader.readLine();
					imageURL = bufferedReader.readLine();
					test = bufferedReader.readLine();
					menu = new ArrayUnsortedList<Item>();
					while(test.equals("!")) {
						
						String itemName = bufferedReader.readLine();
						String xCost = bufferedReader.readLine();
						double cost = Double.parseDouble(xCost);
						menu.add(new Item(itemName,cost));
						test = bufferedReader.readLine();
					}
					reviews = new ArrayUnsortedList<Review>();
					while(test.equals("!!")) {
						String xRating = bufferedReader.readLine();
						String review = bufferedReader.readLine();
						int rating = Integer.parseInt(xRating);
						reviews.add(new Review(rating, review));
						test = bufferedReader.readLine();
					}
					list.add(new Restaurant(id,name,address,phone,email,hours,cuisine,type,price,menu,reviews,imageURL));
					
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
