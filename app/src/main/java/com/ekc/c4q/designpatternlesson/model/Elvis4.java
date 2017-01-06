package com.ekc.c4q.designpatternlesson.model;

/**
 * This is probably your preferred way of creating a lazy singleton, if you don't care about
 * testing.
 *
 * It still has the issue that our Singleton will always be a real object and that we cannot mock
 * or substitute a fake object. So if this was our network client and we wanted to use it in a unit
 * test, it would be bad because it would still perform real network calls in our test suite.
 */
public class Elvis4 {
  private static class ElvisHolder {
    private static final Elvis4 INSTANCE = new Elvis4();
  }

  private Elvis4() {
    // no-op
  }

  // This is like Elvis1 with "hidden" lazy instantiation. This takes advantage of the fact that
  // Java won't load a class until it is actually used, and if it doesn't load the class, it
  // won't create INSTANCE. So we lazily create INSTANCE because ElvisHolder is only loaded the
  // first time Elvis4.getInstance() is called
  public static Elvis4 getInstance() {
    return ElvisHolder.INSTANCE;
  }

  public String sing() {
    return "A Little Less Conversation";
  }
}
