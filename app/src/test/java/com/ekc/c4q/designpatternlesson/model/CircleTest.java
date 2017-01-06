package com.ekc.c4q.designpatternlesson.model;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CircleTest {

  @Test
  public void withRadius() {
    Circle circle = Circle.withRadius(4.0D);

    assertThat(circle.radius).isEqualTo(4);
  }

  @Test
  public void withArea() {
    Circle circle = Circle.withArea(16.0D * Math.PI);

    assertThat(circle.radius).isEqualTo(4);
  }
}