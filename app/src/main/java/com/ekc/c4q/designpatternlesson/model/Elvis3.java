package com.ekc.c4q.designpatternlesson.model;

/**
 * This is a thread safe, more performant version of a singleton which is also good for testing. We
 * can use setSingletonInstance(Elvis3) to substitute a mock in our tests.
 *
 * FYI This is how Picasso's singleton is written. Picasso.with(Context) is like
 * Elvis3.getInstance().
 */
public class Elvis3 {
  private static volatile Elvis3 instance;

  private Elvis3() {
    // no-op
  }

  /**
   * This is the optimized version of Elvis2.getInstance2(). It looks intimidating, so don't use it
   * unless you are comfortable with what is happening.
   *
   * The logic here is known as "double checked locking".
   */
  public static Elvis3 getInstance() {
    // We do the standard instance null check
    if (instance == null) {
      // If it's null, we need to synchronize. We pick our Class
      // instance as the lock object. This means during this time, no on else can access any
      // static methods in our Class until this block finishes.
      synchronized (Elvis3.class) {
        // Now we check again. If two separate threads tried to access getInstance
        // and instance was null, the first thread would block the 2nd thread from entering this
        // next (instance == null) check.
        if (instance == null) {
          // The first thread will then create the Elvis3 and exit the synchronized block. The
          // second thread would now enter the sync block, see that instance != null, and then
          // not create a new Elvis3
          instance = new Elvis3();
        }
      }
    }

    return instance;
  }

  /**
   * This is largely useful for testing because you can do something like:
   *
   * Elvis3 mockElvis = Mockito.mock(Elvis3.class); // make an Elvis3 mock
   * Elvis3.setSingletonInstance(mockElvis);
   *
   * And then now all calls in your test code for Elvis3.getInstance() will use the mock rather than
   * a real Elvis3.
   */
  public static void setSingletonInstance(Elvis3 instance) {
    if (instance == null) {
      throw new IllegalArgumentException("Instance must not be null");
    }

    synchronized (Elvis3.class) {
      if (Elvis3.instance != null) {
        throw new IllegalStateException("Singleton already exists");
      }

      Elvis3.instance = instance;
    }
  }

  public String sing() {
    return "Viva Las Vegas";
  }
}
