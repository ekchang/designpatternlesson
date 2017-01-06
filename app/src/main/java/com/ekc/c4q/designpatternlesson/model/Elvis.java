package com.ekc.c4q.designpatternlesson.model;

/**
 * There can be one and only one Elvis!
 *
 * Note that because our singleton is static and final, it is very difficult to test and use for
 * testing purposes. We have no clean way of introducing a mock object (unless every user of the
 * singleton takes it as a method parameter, which is very annoying and defeats the purpose of
 * making a Singleton in some respect).
 */
public class Elvis {
  // First way to create an singleton
  public static final Elvis INSTANCE = new Elvis();

  // We make this private so no one can create an Elvis class, and now INSTANCE is the one and
  // only Elvis that exists in our entire app
  private Elvis() {
    // no-op
  }

  public String sing() {
    return "Burning Love";
  }
}
