package com.ekc.c4q.designpatternlesson.model;

public class Circle {
  final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public static Circle withRadius(double radius) {
    return new Circle(radius);
  }

  public static Circle withArea(double area) {
    double radiusSquared = area / Math.PI;
    double radius = Math.sqrt(radiusSquared);
    return new Circle(radius);
  }
}
