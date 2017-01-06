package com.ekc.c4q.designpatternlesson;

import com.ekc.c4q.designpatternlesson.model.Elvis;
import com.ekc.c4q.designpatternlesson.model.Elvis2;
import com.ekc.c4q.designpatternlesson.model.Elvis3;
import com.ekc.c4q.designpatternlesson.model.Elvis4;
import com.ekc.c4q.designpatternlesson.model.Elvis5;

public class SingletonProblemSet {

  public static void main(String[] args) {
    // Going forward, if you don't care too much about testing, I recommend you go forward with
    // Elvis4's Singleton implementation. Otherwise, use Elvis3.

    // Five Singleton Examples
    System.out.println(Elvis.INSTANCE.sing());
    System.out.println(Elvis2.getInstance().sing());
    System.out.println(Elvis3.getInstance().sing());
    System.out.println(Elvis4.getInstance().sing());
    System.out.println(Elvis5.INSTANCE.sing());

    /**
     * Problem #1Modify GitHubClient so that getInstance() returns a singleton, instead of a
     * new GitHubClient each time. GitHubClientTest should pass (right now it fails and is a good
     * example of showing how to check if two objects are the same instance).
     *
     * Problem #1.5: If you didn't already do so, write GitHubClient so that the singleton that
     * it returns is lazily instantiated (follow Elvis2, 3, or 4)
     */
  }
}
