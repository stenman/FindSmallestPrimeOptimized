package com.example;

import java.util.Collections;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class PrimeFinder {

	Prime primes;
	long counter = 0;
	Set<Long> foundPrimes = null;
	StringBuilder number;
	int lengthX;
	int lengthY;

	public PrimeFinder() {
		primes = new Prime();
	}

	public long findSmallestPrime(int x, int y) {

		boolean primeFound = false;

		foundPrimes = new HashSet<Long>();

		number = new StringBuilder();

		number.append(x);
		number.append(y);

		lengthX = (int) (Math.log10(x) + 1);
		lengthY = (int) (Math.log10(y) + 1);

		long smallestPrime = 0;

		primeFound = findPrimeSingle(10);
		if (!primeFound) {
			primeFound = findPrimeSingle(100);
			primeFound = findPrimeCombo(10, 10, 0);
		}

		if (!primeFound) {
			primeFound = findPrimeSingle(1000);
			primeFound = findPrimeCombo(10, 100, 0);
			primeFound = findPrimeCombo(100, 10, 0);
			for (int i = 0; i < 10; i++) {
				primeFound = findPrimeCombo(10, 10, i);
			}
		}

		if (!primeFound) {
			primeFound = findPrimeSingle(10000);
			primeFound = findPrimeCombo(100, 100, 0);
			primeFound = findPrimeCombo(10, 1000, 0);
			primeFound = findPrimeCombo(1000, 10, 0);
			for (int i = 0; i < 100; i++) {
				primeFound = findPrimeCombo(10, 10, i);
			}
		}

		try {
			smallestPrime = Collections.min(foundPrimes);
		} catch (NoSuchElementException e) {
			System.out.println("No primes found for (" + x + "," + y + ")");
		}

		System.out.println("Total tests: " + counter);
		System.out.println("Found " + foundPrimes.size() + " unique prime(s)");

		return smallestPrime;
	}

	// 0-9 to 0000 - 9999 single counter
	private boolean findPrimeSingle(int nStop) {

		int position = 0;

		boolean foundPrime = false;

		for (int i = 0; i < 3; i++) {

			int zerosToAddToBase = (int) (Math.log10(nStop) - 1);

			if (i == 0) {
				position = lengthX + lengthY;
			}
			if (i == 1) {
				position = lengthX;
			}
			if (i == 2) {
				position = 0;
			}
			for (int j = 0; j < nStop; j++) {
				StringBuilder singleNum = new StringBuilder(number);
				String counterWithZeros = new String();
				if (j < 10) {
					counterWithZeros = addLeadingZeros(j, zerosToAddToBase);
					singleNum.insert(position, counterWithZeros);
				} else if (j < 100) {
					counterWithZeros = addLeadingZeros(j, zerosToAddToBase - 1);
					singleNum.insert(position, counterWithZeros);
				} else if (j < 1000) {
					counterWithZeros = addLeadingZeros(j, zerosToAddToBase - 2);
					singleNum.insert(position, counterWithZeros);
				} else if (j < 10000) {
					counterWithZeros = addLeadingZeros(j, zerosToAddToBase - 3);
					singleNum.insert(position, counterWithZeros);
				} else {
					singleNum.insert(position, j);
				}

				long convertedSingleNumber = convertStringToLong(singleNum.toString());
				counter++;
				if (primes.isPrime(convertedSingleNumber)) {
					foundPrimes.add(convertedSingleNumber);
					foundPrime = true;
				}
			}
		}

		return foundPrime;
	}

	// 0-9 to 0000-9999 combination counters
	private boolean findPrimeCombo(int nStop1, int nStop2, int thirdInt) {

		int position1 = 0;
		int position2 = 0;
		int position3 = 0;

		int zerosToAddToBase1 = calculateLeadingZeros(nStop1);
		int zerosToAddToBase2 = calculateLeadingZeros(nStop2);
		int zerosToAddToBase3 = calculateLeadingZeros(thirdInt);

		boolean foundPrime = false;

		for (int i = 0; i < 3; i++) {

			position1 = 0;
			position2 = lengthX;
			position3 = lengthX + lengthY;

			int rotatingPositions[] = { position1, position2, position3, position1, position2 };

			for (int firstInt = 0; firstInt < nStop1; firstInt++) {

				for (int secondInt = 0; secondInt < nStop2; secondInt++) {

					StringBuilder comboNum = new StringBuilder(number);

					String counterWithZeros1 = new String();
					String counterWithZeros2 = new String();
					String counterWithZeros3 = new String();

					if (firstInt < 10) {
						counterWithZeros1 = addLeadingZeros(firstInt, zerosToAddToBase1);
					} else if (firstInt < 100) {
						counterWithZeros1 = addLeadingZeros(firstInt, zerosToAddToBase1 - 1);

					} else if (firstInt < 1000) {
						counterWithZeros1 = addLeadingZeros(firstInt, zerosToAddToBase1 - 2);

					} else if (firstInt < 10000) {
						counterWithZeros1 = addLeadingZeros(firstInt, zerosToAddToBase1 - 3);
					}
					if (secondInt < 10) {
						counterWithZeros2 = addLeadingZeros(secondInt, zerosToAddToBase2);
					} else if (secondInt < 100) {
						counterWithZeros2 = addLeadingZeros(secondInt, zerosToAddToBase2 - 1);

					} else if (secondInt < 1000) {
						counterWithZeros2 = addLeadingZeros(secondInt, zerosToAddToBase2 - 2);

					} else if (secondInt < 10000) {
						counterWithZeros2 = addLeadingZeros(secondInt, zerosToAddToBase2 - 3);
					}
					if (thirdInt > 0 && thirdInt < 10) {
						counterWithZeros3 = addLeadingZeros(thirdInt, zerosToAddToBase3);
					} else if (thirdInt > 0 && thirdInt < 100) {
						counterWithZeros3 = addLeadingZeros(thirdInt, zerosToAddToBase3 - 1);

					} else if (thirdInt > 0 && thirdInt < 1000) {
						counterWithZeros3 = addLeadingZeros(thirdInt, zerosToAddToBase3 - 2);

					} else if (thirdInt > 0 && thirdInt < 10000) {
						counterWithZeros3 = addLeadingZeros(thirdInt, zerosToAddToBase3 - 3);
					}

					int lengthJ1 = String.valueOf(counterWithZeros1).length();
					int lengthJ2 = String.valueOf(counterWithZeros1).length();
					int lengthK = String.valueOf(counterWithZeros2).length();
					if (i == 2) {
						lengthJ1 = 0;
						lengthJ2 = 0;
					}
					if (i == 1) {
						lengthK = 0;
						lengthJ2 = 0;
					}

					comboNum.insert(rotatingPositions[i], counterWithZeros1);
					comboNum.insert(rotatingPositions[i + 1] + lengthJ1, counterWithZeros2);
					comboNum.insert(rotatingPositions[i + 2] + lengthJ2 + lengthK, counterWithZeros3);

					long convertedComboNumber = convertStringToLong(comboNum.toString());

					counter++;

					if (primes.isPrime(convertedComboNumber)) {
						foundPrimes.add(convertedComboNumber);
						foundPrime = true;
					}
				}
			}
		}
		return foundPrime;
	}

	private int calculateLeadingZeros(int number) {
		return (int) (Math.log10(number) - 1);
	}

	private String addLeadingZeros(int counter, int numberOfZeros) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numberOfZeros; i++) {
			sb.append(0);
		}
		sb.append(counter);

		return sb.toString();
	}

	public Integer convertStringToInteger(String number) {
		return Integer.parseInt(number);
	}

	public long convertStringToLong(String number) {
		return Long.parseLong(number);
	}
}
