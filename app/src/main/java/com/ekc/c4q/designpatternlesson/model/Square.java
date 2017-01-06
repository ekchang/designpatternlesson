package com.ekc.c4q.designpatternlesson.model;

public class Square {

  final int height;
  final int width;

  public Square(int length) {
    height = length;
    width = length;
  }

  /**
   * This won't compile! We already have a constructor that takes an integer (length) above.
   * Compiler can't tell which constructor you mean to use.
   */
  //public Square(int area) {
  //  height = Math.sqrt(area);
  //  width = Math.sqrt(area);
  //}

  // Factory methods
  public static Square withSides(int length) {
    return new Square(length);
  }

  public static Square withArea(int area) {
    /**
     * TODO we could even add additional logic here, like verifying the area was a perfect square
     * and throwing an exception if it's not.
     */
    int length = (int) Math.sqrt(area);
    return new Square(length);
  }
}
