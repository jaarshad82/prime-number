package com.rbs.technicaltest.primenumber;

public class SimplePrimeNumberGenerator extends PrimeNumberGeneratorBase implements PrimeNumberGenerator  {

  @Override
  public PrimeResultSet generate(int initial) {
    PrimeResultSet primeResultSet = new PrimeResultSet();
    primeResultSet.setInitial(initial);

    if (null != primes.get(initial)) {
      primeResultSet.setPrimes(primes.get(initial));
      System.out.println("Found primes in cache for initial value: " + initial);
    } else {
      for (int i = 2; i <= initial; i++) {
        if (isNumberPrime(i)) {
          primeResultSet.addPrime(i);
        }
      }
      primes.put(initial, primeResultSet.getPrimes());
    }
    return primeResultSet;
  }

  boolean isNumberPrime(int number) {
    boolean isPrime = true;

    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        isPrime = false;
        break;
      }
    }

    return isPrime;
  }
}
