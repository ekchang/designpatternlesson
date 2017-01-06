package com.ekc.c4q.designpatternlesson.model;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SquareTest {

  @Test
  public void withSides() {
    Square square = Square.withSides(4);

    assertThat(square.height).isEqualTo(4);
    assertThat(square.width).isEqualTo(4);
  }

  @Test
  public void withArea() {
    Square square = Square.withArea(16);

    assertThat(square.height).isEqualTo(4);
    assertThat(square.width).isEqualTo(4);
  }
}