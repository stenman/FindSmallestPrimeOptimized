package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HillbillyTester {

	// I know, I know... maybe I'll implement real tests later
	public void runTests() {
		PrimeFinder findSmallestPrime = new PrimeFinder();

		List<Integer> tests = new ArrayList<Integer>();
		List<Long> expected = new ArrayList<Long>();
		List<Long> smallestPrimes = new ArrayList<Long>();

		tests.addAll(Arrays.asList(2014, 1337, 34567, 76543, 384756, 837465, 534, 2623, 5234, 6378));
		expected.addAll(Arrays.asList(1201401337L, 34567876543L, 23847568374653L, 35342623L, 523463783L));

		for (int i = 0; i < tests.size(); i += 2) {
			Set<Long> tempPrimes = new HashSet<Long>();
			tempPrimes.add(findSmallestPrime.findSmallestPrime(tests.get(i), tests.get(i + 1)));
			tempPrimes.add(findSmallestPrime.findSmallestPrime(tests.get(i + 1), tests.get(i)));
			long smallestPrime = Collections.min(tempPrimes);
			smallestPrimes.add(smallestPrime);
		}

		System.out.println("actual:   " + smallestPrimes);
		System.out.println("expected: " + expected);

		for (int i = 0; i < expected.size(); i++) {
			if (smallestPrimes.get(i).equals(expected.get(i))) {
				System.out.println("TEST SUCCESSFUL!");
			} else {
				System.out.println("TEST FAILED!");
			}
		}

	}
}
