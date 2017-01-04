package com.ekc.c4q.designpatternlesson.model;

public class NutritionFacts {
  final int servingSize; // mL
  final int servings; // per container
  final int calories; // kcal
  final int fat; // g
  final int sodium; // mg
  final int carbohydrate; // g
  final int protein;

  // Telescoping constructor pattern - this doesn't scale well!
  public NutritionFacts(int servingSize, int servings) {
    this(servingSize, servings, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories) {
    this(servingSize, servings, calories, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat) {
    this(servingSize, servings, calories, fat, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
    this(servingSize, servings, calories, fat, sodium, 0);
  }

  public NutritionFacts(int servingSize,
      int servings,
      int calories,
      int fat,
      int sodium,
      int carbohydrate) {
    this(servingSize, servings, calories, fat, sodium, carbohydrate, 0);
  }

  public NutritionFacts(int servingSize,
      int servings,
      int calories,
      int fat,
      int sodium,
      int carbohydrate,
      int protein) {
    this.servingSize = servingSize;
    this.servings = servings;
    this.calories = calories;
    this.fat = fat;
    this.sodium = sodium;
    this.carbohydrate = carbohydrate;
    this.protein = protein;
  }

  // Builder Pattern

  private NutritionFacts(Builder builder) {
    // Note that this constructor is intentionally private: we only want to access this ctor
    // through the Builder's build() method only
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
    protein = builder.protein;
  }

  public static class Builder {
    // Required parameters
    private final int servingSize; // mL
    private final int servings; // per container

    // Optional parameters - initialized to default values
    private int calories; // kcal
    private int fat; // g
    private int sodium; // mg
    private int carbohydrate; // g
    private int protein; // g

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder carbohydrate(int carbohydrate) {
      this.carbohydrate = carbohydrate;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder protein(int protein) {
      this.protein = protein;
      return this;
    }

    public NutritionFacts build() {
      if (this.sodium < 0) {
        throw new IllegalStateException("sodium < 0");
      }

      if (this.carbohydrate < 0) {
        throw new IllegalStateException("carbohydrate < 0");
      }

      return new NutritionFacts(this);
    }
  }
}
