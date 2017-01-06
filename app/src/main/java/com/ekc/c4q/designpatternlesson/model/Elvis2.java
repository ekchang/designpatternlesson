package com.ekc.c4q.designpatternlesson.model;

/**
 * Retrieve the Singleton via a static method getInstance() instead of accessing the field
 * directly. One advantage of this approach is you could have initially started as a static factory
 * method and then decide you want it to become a singleton and not need to make any changes to
 * external classes.
 */
public class Elvis2 {
  private static Elvis2 instance;

  // Just like Elvis 1, we don't want to allow anyone else to create Elvis instances
  private Elvis2() {
    // no-op
  }

  // This is classic lazy instantiation of a singleton. It is inherently not thread-safe, meaning
  // two separate threads calling Elvis2.getInstance() have a chance of creating and returning
  // two separate Elvis2 instances
  public static Elvis2 getInstance() {
    if (instance == null) {
      instance = new Elvis2();
    }

    return instance;
  }

  /**
   * This is one thread-safe implementation that just uses the synchronized keyword: this means
   * no two threads can call getInstance2() at the same time: the first one to call it will
   * resolve completely until the method exists before the 2nd caller can do anything.
   *
   * Although it is safe, it's unnecessarily unperformant because we only have the race condition
   * at the very first call, when instance is null.
   */
  public static synchronized Elvis2 getInstance2() {
    if (instance == null) {
      instance = new Elvis2();
    }

    return instance;
  }

  public String sing() {
    return "Heartbreak Hotel";
  }
}
