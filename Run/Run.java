package main;

import java.util.Scanner;

import com.daoimpl.Launch;

public class Run {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice:\n1.USER OPERATIONS\n2.MENU OPERATIONS\n3.ORDER OPERATIONS\n4.RESTAURANT OPERATIONS");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			Launch.UserOperation();
			break;
		case 2:
			Launch.MenuOperation();
			break;
		case 3:
			Launch.orderOperstions();
			break;
		case 4:
			Launch.restaurantOperations();
			break;
		default:
			System.out.println("Enter the Valied choice..");
		}

		
		
		
	}

}
