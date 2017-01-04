package com.ekc.c4q.designpatternlesson.model;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class EmailTest {

  @Test
  public void ctorTest() {
    Email email = new Email("erick@c4q.nyc",
        "rina@c4q.nyc",
        "The students are late to class again...",
        "Erick C.",
        "xoxo,\nErick",
        "Rina G.");

    assertThat(email.senderEmail).isEqualTo("erick@c4q.nyc");
    assertThat(email.recipientEmail).isEqualTo("rina@c4q.nyc");
    assertThat(email.message).isEqualTo("The students are late to class again...");
    assertThat(email.senderName).isEqualTo("Erick C.");
    assertThat(email.senderSignature).isEqualTo("xoxo,\nErick");
    assertThat(email.recipientName).isEqualTo("Rina G.");
  }

  @Test
  public void builderTest() {
    Email email = new Email.Builder("erick@c4q.nyc", "rina@c4q.nyc")
        .senderName("Erick C.")
        .recipientName("Rina G.")
        .message("The students are late to class again...")
        .build();

    assertThat(email.senderEmail).isEqualTo("erick@c4q.nyc");
    assertThat(email.recipientEmail).isEqualTo("rina@c4q.nyc");
    assertThat(email.message).isEqualTo("The students are late to class again...");
    assertThat(email.senderName).isEqualTo("Erick C.");
    assertThat(email.recipientName).isEqualTo("Rina G.");
    assertThat(email.senderSignature).isEqualTo(null);
  }
}