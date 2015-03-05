package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {

	public List<Integer> promptUserForInput() {

		List<Integer> numbers = new ArrayList<Integer>();

		int n1 = 0;
		int n2 = 0;

		try (Scanner scanner = new Scanner(System.in)) {
			do {
				System.out
						.println("Welcome to Dual Combo Prime Finder 0.7 Professional Edition\nThis program will take two positive integers as input and then find the smallest prime number containing these two integers (in no particular order)\n\nPlease enter the first positive integer:");
				while (!scanner.hasNextInt()) {
					System.out.println("You have to enter a positive integer!");
					scanner.next();
				}
				n1 = scanner.nextInt();
				System.out.println("Please enter the second positive integer:");
				while (!scanner.hasNextInt()) {
					System.out.println("You have to enter a positive integer!");
					scanner.next();
				}
				n2 = scanner.nextInt();
			} while (n1 <= 0 || n2 <= 0);
			numbers.add(n1);
			numbers.add(n2);
		}

		return numbers;
	}
}
