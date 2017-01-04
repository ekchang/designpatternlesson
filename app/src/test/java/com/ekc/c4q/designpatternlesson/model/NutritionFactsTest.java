package com.ekc.c4q.designpatternlesson.model;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NutritionFactsTest {

  @Test
  public void ctorTest() {
    NutritionFacts nutritionFacts = new NutritionFacts(240, 8, 100, 0, 35, 27);

    assertThat(nutritionFacts.servingSize).isEqualTo(240);
    assertThat(nutritionFacts.servings).isEqualTo(8);
    assertThat(nutritionFacts.calories).isEqualTo(100);
    assertThat(nutritionFacts.fat).isEqualTo(0);
    assertThat(nutritionFacts.sodium).isEqualTo(35);
    assertThat(nutritionFacts.carbohydrate).isEqualTo(27);
  }

  @Test
  public void telescopingCtorTest() {
    NutritionFacts nutritionFacts = new NutritionFacts(240, 8, 100);

    assertThat(nutritionFacts.servingSize).isEqualTo(240);
    assertThat(nutritionFacts.servings).isEqualTo(8);
    assertThat(nutritionFacts.calories).isEqualTo(100);
    assertThat(nutritionFacts.fat).isEqualTo(0);
    assertThat(nutritionFacts.sodium).isEqualTo(0);
    assertThat(nutritionFacts.carbohydrate).isEqualTo(0);
  }

  @Test
  public void builderTest() {
    NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8)
        .calories(100)
        .sodium(35)
        .carbohydrate(27)
        .build();

    assertThat(nutritionFacts.servingSize).isEqualTo(240);
    assertThat(nutritionFacts.servings).isEqualTo(8);
    assertThat(nutritionFacts.calories).isEqualTo(100);
    assertThat(nutritionFacts.fat).isEqualTo(0);
    assertThat(nutritionFacts.sodium).isEqualTo(35);
    assertThat(nutritionFacts.carbohydrate).isEqualTo(27);
  }

  @Test(expected = IllegalStateException.class)
  public void sodiumLessThanZero_shouldThrowIllegalStateException() {
    NutritionFacts nutritionFacts = new NutritionFacts.Builder(240, 8).sodium(-1).build();
  }
}