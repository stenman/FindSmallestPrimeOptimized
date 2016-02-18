package com.example;

import java.util.ArrayList;
import java.util.List;

public class Prime {

	static long counter = 0;

	static long partTime = 0;
	static long oldTotalDuration = 0;
	static long newTotalDuration = 0;

	static List<Long> durations = new ArrayList<Long>();

	boolean isPrime(long n) {
		counter++;

		if (n < 2) {
			return false;
		}
		
		if (n == 2 || n == 3) {
			return true;
		}
		
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		
		long limit = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= limit; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

	public long getCounter() {
		return counter;
	}
}
