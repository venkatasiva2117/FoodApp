
package com.daoimpl;


import java.util.List;
import java.util.Scanner;

import com.dao.MenuDAO;
import com.dao.OrderDAO;
import com.dao.UserDAO;
import com.dao.RestaurantDAO;
import com.dao.model.Menu;
import com.dao.model.Order;
import com.dao.model.Restaurant;
import com.dao.model.User;



public class Launch {

	public static void  UserOperation() {
		Scanner sc = new Scanner(System.in);
		UserDAO imp = new UserDAOimpl();



		System.out.println("Enter your choice:\n1.ADD THE USER\n2.GET THE USER DETAILS\n3.UPDATE USER DETAILS"
				+ "\n4.DELETE THE USER\n5.GET ALL USERS");
		int choice = sc.nextInt();
		sc.nextLine();

		if(choice == 1) {
			System.out.println("Enter the name:");
			String name = sc.nextLine();
			System.out.println("Enter the username");
			String username = sc.nextLine();
			System.out.println("Enter your PAssword");
			String password = sc.nextLine();
			System.out.println("Enter the email");
			String email = sc.nextLine();
			System.out.println("Enter the phone");
			long phone = sc.nextLong();
			sc.nextLine();
			System.out.println("Entrt the role");
			String role = sc.nextLine();
			System.out.println("Enter the address");
			String address = sc.nextLine();

			User u = new User(name, username, password, email, phone, address, role);

			imp.addUser(u);
		}
		else if(choice == 2) {
			System.out.print("Enter the user id: ");
			int user_id = sc.nextInt();
			User u = imp.getUser(user_id);
			System.out.println(u);	
		}
		else if(choice == 3) {
			System.out.println("ENTER YOUR CHOICE TO UPDATE WHAT :\n1.Name\n2.Password\n3.Email\n4.Phone\n5.Address\n6.Role");
			int CHOICE = sc.nextInt();
			sc.nextLine(); // consume newline

			if (CHOICE < 1 || CHOICE > 6) {
				System.out.println("Enter a valid choice");
			} else {
				System.out.println("Enter the id of User:");
				int user_id = sc.nextInt();
				sc.nextLine(); // consume newline
				User u = imp.getUser(user_id);
				switch (CHOICE) {
				case 1:
					System.out.println("Enter the name to update:");
					u.setName(sc.nextLine());
					break;
				case 2:
					System.out.println("Enter the password to update:");
					u.setPassword(sc.nextLine());
					break;
				case 3:
					System.out.println("Enter the email to update:");
					u.setEmail(sc.nextLine());
					break;
				case 4:
					System.out.println("Enter the phone to update:");
					u.setPhone(sc.nextLong());
					break;
				case 5:
					System.out.println("Enter the address to update:");
					u.setAddress(sc.nextLine());
					break;
				case 6:
					System.out.println("Enter the role to update:");
					u.setRole(sc.nextLine());
					break;
				}

				imp.updateUser(u);
				System.out.println("User updated successfully!");
			}
		}
		else if(choice == 4) {
			System.out.println("Enter the id of User:");
			int user_id = sc.nextInt();
			imp.deleteUser(user_id);
		}

		else if(choice == 5) {

			List<User> li = imp.getAllUsers();

			for(User u : li) {
				System.out.println(u);
			}
		}
		else {
			System.out.println("Enter the valied choice");
		}						
	}


	public  static void  MenuOperation(){
		Scanner sc = new Scanner(System.in);
		MenuDAO mm = new MenuDAOimpl(); 

		int menu_id;
		System.out.println("Enter your Choice \n1.ADD MENU\n2.GET MENU\n3.UPDATE MENU\n4.DELETE MENU\n5.GET ALL MENU");
		int choice = sc.nextInt();

		switch(choice) {
		case 1:
			System.out.print("Enter Restaurant ID: ");
			int restaurantid = sc.nextInt();
			sc.nextLine(); // consume newline

			System.out.print("Enter Item Name: ");
			String itemName = sc.nextLine();

			System.out.print("Enter Description: ");
			String description = sc.nextLine();

			System.out.print("Enter Price: ");
			double price = sc.nextDouble();
			sc.nextLine();

			System.out.print("Enter Rating: ");
			float rating = sc.nextFloat();
			sc.nextLine();

			System.out.print("Is Available (Available/NotAvailable): ");
			String isAvailable = sc.nextLine();

			System.out.print("Enter Image Path: ");
			String imagePath = sc.nextLine();

			Menu m = new Menu(restaurantid, itemName, description, price, rating, isAvailable, imagePath);
			mm.addMenu(m);
			break;

		case 2:
			System.out.println("Enter the menu_id");
			menu_id = sc.nextInt();

			Menu getmenu = mm.getMenu(menu_id);
			System.out.println(getmenu);
			break;

		case 3:

			System.out.println("Enter What to update:\n1.restaurantid\n2.itemName\n3.description\n4.price\n5.rating\n6.isAvailable\n7.imagePath");
			int CHOICE = sc.nextInt();

			System.out.println("Enter the id of menu:");
			int Menu_id = sc.nextInt();
			sc.nextLine();
			Menu update_menu = mm.getMenu(Menu_id);

			switch(CHOICE) {

			case 1:
				System.out.println("Enter the restaurant id :");
				update_menu.setRestaurantid(sc.nextInt());
				mm.updateMenu(update_menu);
				break;
			case 2:
				System.out.println("Enter the itemName :");
				update_menu.setItemName(sc.nextLine());
				mm.updateMenu(update_menu);
				break;
			case 3:
				System.out.println("Enter the description :");
				update_menu.setDescription(sc.nextLine());
				mm.updateMenu(update_menu);
				break;
			case 4:
				System.out.println("Enter the price :");
				update_menu.setPrice(sc.nextDouble());
				sc.nextLine();
				mm.updateMenu(update_menu);
				break;
			case 5: 
				System.out.println("Enter the rating :");
				update_menu.setRating(sc.nextFloat());
				sc.nextLine();
				mm.updateMenu(update_menu);
				break;
			case 6:
				System.out.println("Enter the isAvailable :");
				update_menu.setIsAvailable(sc.nextLine());
				mm.updateMenu(update_menu);
				break;
			case 7:
				System.out.println("Enter the imagePath :");
				update_menu.setImagePath(sc.nextLine());
				mm.updateMenu(update_menu);
				break;
			default :
				System.out.println("Enter the valied Choice");	
			}

		case 4 :
			System.out.println("Enter the menu_id");
			menu_id = sc.nextInt();
			sc.nextLine();
			mm.deleteMenu(menu_id);

		case 5 :
			List<Menu> menu = mm.getAllMenu();

			for(Menu eachmenu : menu) {

				System.out.println(eachmenu);
			}

		}

	}

	public static void orderOperstions() {
		Scanner sc = new Scanner(System.in);
		OrderDAO oo = new OrderDAOimpl();
		System.out.println("Enter your choice\n1.GET ORDER DETAILS\n2.DELETE ORDER\n3.GET ALL ORDERS");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:

			System.out.println("Enter the User id: ");
			int user_id = sc.nextInt();
			sc.nextLine();
			Order GET_ORDER = oo.getOrderDetails(user_id);
			System.out.println(GET_ORDER);
			break;
		case 2:
			System.out.println("Enter the user id to delete Order:");
			int user_id_to_delete = sc.nextInt();
			sc.nextLine();
			oo.deleteOrder(user_id_to_delete);
			break;
		case 3:
			List<Order> order = oo.getAllOrders();
			for(Order o : order) {
				System.out.println(o);
			}
			break;
		default:
			System.out.println("YOU ENTERED WRONG CHOICE");

		}
	}
	
	public static void restaurantOperations() {
		Scanner sc = new Scanner(System.in);
		RestaurantDAO rr = new RestaurantDAOimpi();

		System.out.println("Enter Your Choice : \n1.ADD RESTAURANT\n2.DETAILS OF RESTAURANT\n3.UPDATE RESTAURANT\n4.DELETE RESTAURANT\n5.GET ALL RESTAURANT DETAILS");
		int choice = sc.nextInt();


		switch(choice) {
		case 1:

			System.out.println("Enter the restaurantid:");
			int restaurantid = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name:");
			String name = sc.nextLine();
			System.out.println("Enter the address");
			String address = sc.nextLine();
			System.out.println("Enter the phone");
			long phone = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the rating:");
			float rating = sc.nextFloat();
			sc.nextLine();
			System.out.println("Enter the cusineType:");
			String cusineType = sc.nextLine();
			System.out.println("Enter the isActive:");
			String isActive = sc.nextLine();
			System.out.println("Enter the eta:");
			String eta = sc.nextLine();
			System.out.println("Enter the adminUserId:");
			int adminUserId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the imagePath:");
			String imagePath = sc.nextLine();

			Restaurant new_restaurant = new Restaurant(restaurantid, name, address, phone, rating, cusineType, isActive, restaurantid, adminUserId, imagePath);	

			rr.addRestaurant(new_restaurant);
			break;
		case 2:

			System.out.println("Enter the restaurant id:");
			int r_id = sc.nextInt();
			sc.nextLine();
			Restaurant r = rr.getRestaurant(r_id);
			System.out.println(r);
			break;
		case 3:
			
			System.out.println("Enter you choice what you update:\n1.name\n2.address\n3.phone\n4.rating\n5.cusineType\n6.isActive\n7.eta\n8.adminUserId\n9.imagePath");
			int Choice = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter the resturant id :");
			int R_Id_tO_Update = sc.nextInt();
			Restaurant R_Id_tO_Update_O = rr.getRestaurant(R_Id_tO_Update);
			
			switch(Choice) {
			case 1:
				System.out.println("Enter the resturant Name");
				String Name_TO_Update = sc.nextLine();
				R_Id_tO_Update_O.setName(Name_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 2:
				System.out.println("Enter the resturant Address :");
				String Address_TO_Update = sc.nextLine();
				R_Id_tO_Update_O.setAddress(Address_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 3:
				System.out.println("Enter the resturant Phone :");
				long Phone_TO_Update = sc.nextLong();
				sc.nextLine();
				R_Id_tO_Update_O.setPhone(Phone_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 4:
				System.out.println("Enter the resturant Rating :");
				float Rating_TO_Update = sc.nextFloat();
				sc.nextLine();
				R_Id_tO_Update_O.setRating(Rating_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 5:
				System.out.println("Enter the resturant CusineType :");
				String CusineType_TO_Update = sc.nextLine();
				R_Id_tO_Update_O.setCusineType(CusineType_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 6:
				System.out.println("Enter the resturant IsActive/InActive :");
				String IsActive_TO_Update = sc.nextLine();
				R_Id_tO_Update_O.setIsActive(IsActive_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 7:
				System.out.println("Enter the resturant Eta :");
				int Eat_TO_Update = sc.nextInt();
				sc.nextLine();
				R_Id_tO_Update_O.setEta(Eat_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 8:
				System.out.println("Enter the resturant Eta :");
				int AdminUserId_TO_Update = sc.nextInt();
				sc.nextLine();
				R_Id_tO_Update_O.setAdminUserId(AdminUserId_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			case 9:
				System.out.println("Enter the resturant IsActive/InActive :");
				String ImagePath_TO_Update = sc.nextLine();
				R_Id_tO_Update_O.setIsActive(ImagePath_TO_Update);
				rr.updateRestaurant(R_Id_tO_Update_O);
				break;
			default :
				System.out.println("Enter the valied Choice.");
			}
			break;
		case 4:
			
			System.out.println("Enter the resturant id: ");
			int rr_id = sc.nextInt();
			rr.deleteRestaurant(rr_id);
			break;
		case 5:
			
			List<Restaurant> restaurant = rr.getAllRestaurant();

			for(Restaurant x : restaurant) {

				System.out.println(x);
			}
			
			break;
		default :
			System.out.println("Enter the valied choice.");
			
		}
	}

	public static void main(String[] args) {
		
	}


}
