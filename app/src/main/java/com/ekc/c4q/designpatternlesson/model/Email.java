package com.ekc.c4q.designpatternlesson.model;

public class Email {
  // Required
  final String senderEmail;
  final String recipientEmail;

  // Optional
  final String message;
  final String senderName;
  final String senderSignature;
  final String recipientName;

  public Email(String senderEmail,
      String recipientEmail,
      String message,
      String senderName,
      String senderSignature,
      String recipientName) {
    this.senderEmail = senderEmail;
    this.recipientEmail = recipientEmail;
    this.message = message;
    this.senderName = senderName;
    this.senderSignature = senderSignature;
    this.recipientName = recipientName;
  }

  public Email(Builder builder) {
    senderEmail = builder.senderEmail;
    recipientEmail = builder.recipientEmail;
    message = builder.message;
    senderName = builder.senderName;
    senderSignature = builder.senderSignature;
    recipientName = builder.recipientName;
  }

  public static class Builder {
    // Required
    private String senderEmail;
    private String recipientEmail;

    // Optional
    private String message;
    private String senderName;
    private String senderSignature;
    private String recipientName;

    public Builder(String senderEmail, String recipientEmail) {
      this.senderEmail = senderEmail;
      this.recipientEmail = recipientEmail;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public Builder senderName(String senderName) {
      this.senderName = senderName;
      return this;
    }

    public Builder senderSignature(String senderSignature) {
      this.senderSignature = senderSignature;
      return this;
    }

    public Builder recipientName(String recipientName) {
      this.recipientName = recipientName;
      return this;
    }

    public Email build() {
      return new Email(this);
    }
  }
}
