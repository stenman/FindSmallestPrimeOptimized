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

		if (n == 1) {
			return false;
		}

		if (n == 2) {
			return true;
		}

		if (n % 2 == 0) {
			return false;
		}

		final long limit = (long) Math.sqrt(n);

		for (long i = 3; i <= limit; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public long getCounter() {
		return counter;
	}
}
