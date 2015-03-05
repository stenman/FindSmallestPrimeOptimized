package com.example;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSmallestPrime {

	public static void main(String[] args) {

		UserInput userInput = new UserInput();
		FindSmallestPrimes findSmallestPrime = new FindSmallestPrimes();

		List<Integer> numbers = userInput.promptUserForInput();
		int n1 = numbers.get(0);
		int n2 = numbers.get(1);
		System.out.println("\nYou entered the numbers " + n1 + " and " + n2);

		Set<Long> smallestPrimes = new HashSet<Long>();

		long startTime = System.nanoTime();
		System.out.println("\nFinding primes for order x " + n1 + " y " + n2 + " z...");
		smallestPrimes.add(findSmallestPrime.findSmallestPrime(n1, n2));
		System.out.println("\nFinding primes for order x " + n2 + " y " + n1 + " z...");
		smallestPrimes.add(findSmallestPrime.findSmallestPrime(n2, n1));
		long endTime = System.nanoTime();
		long duration = endTime - startTime;

		long smallestPrime = Collections.min(smallestPrimes);

		System.out.println("\n---> Smallest prime overall: " + smallestPrime);
		System.out.println("Total time elapsed: " + duration / 1000000 + "ms");
	}

}
