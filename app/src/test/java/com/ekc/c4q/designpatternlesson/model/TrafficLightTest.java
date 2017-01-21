package com.ekc.c4q.designpatternlesson.model;

import com.ekc.c4q.designpatternlesson.model.TrafficLight.Light;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TrafficLightTest {

  @Test
  public void hasRaceCondition_eventuallyFails() {
    // On a separate thread, simulate changing the traffic light
    Runnable updateTrafficLight = new Runnable() {
      @Override
      public void run() {
        TrafficLight.INSTANCE.setLight(Light.GREEN);
      }
    };
    new Thread(updateTrafficLight).start();

    // On this thread, this looks pretty innocent enough -- we call getLight, print it out
    // then getLight again.
    Light light = TrafficLight.INSTANCE.getLight();
    System.out.println(light);

    Light light2 = TrafficLight.INSTANCE.getLight();
    System.out.println(light2);

    // But this eventually fails because TrafficLight is stateful and doesn't manage state correctly
    // In fact, because it is stateful, every call to getLight has a possibility of returning a
    // different light. Being a stateful singleton makes your code dangerous and you'll never
    // know if someone is updating it behind the scenes, inbetween execution of your other lines
    // of code
    assertThat(light).isEqualTo(light2);
  }

  @Test
  public void fixRaceCondition() {
    // When a singleton is stateful, there isn't much we can do to fix it. We end up having to
    // apply synchronous code on our own to avoid the race condition.
    final Object lock = new Object();

    Runnable updateTrafficLight = new Runnable() {
      @Override
      public void run() {
        synchronized (lock) {
          TrafficLight.INSTANCE.setLight(Light.GREEN);
        }
      }
    };
    new Thread(updateTrafficLight).start();

    synchronized (lock) {
      Light light = TrafficLight.INSTANCE.getLight();
      System.out.println(light);

      Light light2 = TrafficLight.INSTANCE.getLight();
      System.out.println(light2);
      assertThat(light).isEqualTo(light2);
    }
  }
}