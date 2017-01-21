package com.ekc.c4q.designpatternlesson.model;

import static com.ekc.c4q.designpatternlesson.model.TrafficLight.Light.RED;

/**
 * This is an example of a stateful singleton. This has a HUGE concurrency problem. See
 * TrafficLightTest for more details.
 */
public class TrafficLight {
  public static final TrafficLight INSTANCE = new TrafficLight();

  volatile Light light;

  private TrafficLight() {
    light = RED;
  }

  public void setLight(Light light) {
    this.light = light;
  }

  public Light getLight() {
    return light;
  }

  public enum Light {
    RED, GREEN, YELLOW
  }
}
