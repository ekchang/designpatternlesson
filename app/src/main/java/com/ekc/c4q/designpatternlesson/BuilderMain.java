package com.ekc.c4q.designpatternlesson;

import com.ekc.c4q.designpatternlesson.model.NutritionFacts;

/**
 * Nutrition Facts example from Effective Java 2nd. Ed, Item 2: Consider a Builder when faced with
 * many constructor parameters
 */
public class BuilderMain {
  public static void main(String[] args) {

    /**
     * Problem with NutritionFacts: what do all those numbers mean? I have to jump into the class
     * to see what each one is assigned to... prone to error? What if I switch 35 with 27? How do
     * I know I put the numbers in the right order?
     *
     * Imagine you wanted to refactor and rearrange the order of the constructor parameters
     */
    NutritionFacts nutritionFacts = new NutritionFacts(240, 8, 100, 0, 35, 27);

    /**
     * Now it's easier to read and know which number is being used where. Notice how we omit fat,
     * which is optional, and will default to 0
     */
    NutritionFacts nutritionFacts2 = new NutritionFacts.Builder(240, 8)
        .calories(100)
        .sodium(35)
        .carbohydrate(27)
        .build();

    /**
     * Problem 1: Add another optional parameter to NutritionFacts.Builder for protein (int, in
     * grams). Update the builderTest in NutritionFactsTest and verify that it passes.
     *
     * Problem 2: We don't want to allow building NutritionFacts with negative carbohydrate value
     * (since it's in grams, which is a physical quantity). Add a check in the build method to
     * throw an exception if the user tries to call build() when we set a negative carbohydrate
     * value. Write unit tests to verify your checks work.
     *
     * Problem 3: Inside the Email class, write a Builder following the builder pattern. Use
     * NutritionFacts as a guide if you are stuck. You decide what the default values for the
     * optional params are.
     */
  }
}
