package com.rbs.technicaltest.primenumber;

import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
class PrimeResultSet {
  private int initial;
  private Set<Integer> primes = new LinkedHashSet<>();

  public int getInitial() {
    return this.initial;
  }

  void setInitial(int initial) {
    this.initial = initial;
  }

  public Set<Integer> getPrimes() {
    return this.primes;
  }

  void addPrime(Integer prime) {
    this.primes.add(prime);
  }
}
