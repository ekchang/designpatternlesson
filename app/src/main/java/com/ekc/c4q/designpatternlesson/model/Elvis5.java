package com.ekc.c4q.designpatternlesson.model;

/**
 * Realize that enums can be Singletons! We don't need a private constructor because enums can't be
 * constructed by default. This pattern is suggested over Elvis1 in Effective Java, Item 3: solely
 * because even if we declare a constructor as private, it can still be accessed via reflection.
 * It's not a big concern, though, but this pattern is definitely less code and looks cleaner.
 */
public enum Elvis5 {
  INSTANCE;

  public String sing() {
    return "Always On My Mind";
  }
}
