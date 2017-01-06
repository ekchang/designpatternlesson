package com.ekc.c4q.designpatternlesson;

import com.ekc.c4q.designpatternlesson.model.Square;

/**
 * Factory / Static Factory Method example from Effective Java 2nd. Ed, Item 1: Consider static
 * factory methods instead of constructors
 */
public class FactoryProblemSet {
  public static void main(String[] args) {

    // The standard way of making an object is by using the 'new' keyword:
    Square square = new Square(4);

    // But this is pretty limiting if we want to create an object from different parameters or
    // sources. The above creates a Square with sides of length 4, but what if we wanted to
    // create a square by passing in the area?

    // We can't. But static factory methods help us handle this.
    Square square1 = Square.withArea(16);

    // Notice that by using a method to create an object for us, we can give it a name, and that
    // name makes it clear /how/ we are creating a Square: by giving the area.

    /**
     * Problem 1: Circle class inside the model package.
     * Circle has a single constructor which takes a radius. Write two static factory methods for
     * Circle: withRadius(double) and withArea(double).
     *
     * Area of a circle = radius^2 * PI
     *
     * eg. Circle circle = Circle.withRadius(4.0d);
     * Circle circle2 = Circle.withArea(16.0D * Math.PI);
     *
     * Both circles should have the same radius.
     *
     * Add two tests in CircleTest which verify your static factory methods work as intended.
     *
     * Problem 2: GitHubClient inside network package.
     * Write the implementation for getInstance() which creates a GitHubClient with a fully
     * configured GitHubApi. Create this API the same way you create every Retrofit API. Do NOT
     * modify the GitHubClient constructor.
     */
  }
}
