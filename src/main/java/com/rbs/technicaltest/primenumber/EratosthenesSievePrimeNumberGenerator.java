package com.rbs.technicaltest.primenumber;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class EratosthenesSievePrimeNumberGenerator extends PrimeNumberGeneratorBase implements PrimeNumberGenerator {

  // TODO: this is returning UP TO initial value not INCLUDING - look into this.

  @Override
  public PrimeResultSet generate(int initial) {
    PrimeResultSet primeResultSet = new PrimeResultSet();
    primeResultSet.setInitial(initial);

    if (null != primes.get(initial)) {
      primeResultSet.setPrimes(primes.get(initial));
      System.out.println("Found primes in cache for initial value: " + initial);
    } else {

      boolean primeBools[] = new boolean[initial];
      Arrays.fill(primeBools, true);

      for (int i = 2; i < Math.sqrt(initial); i++) {
        System.out.println("point 1: " + i);
        if (primeBools[i]) {
          for (int k = 0, j = (i * i); j < initial; k++, j = (i * i) + (k * i)) {
            System.out.println("point2: " + j);
            primeBools[j] = false;
          }
        }
      }

      Set<Integer> primes = new LinkedHashSet<>();
      for (int i = 2; i < primeBools.length; i++) {
        if (primeBools[i]) {
          primes.add(i);
        }
      }
      primeResultSet.setPrimes(primes);
    }

    return primeResultSet;
  }
}
