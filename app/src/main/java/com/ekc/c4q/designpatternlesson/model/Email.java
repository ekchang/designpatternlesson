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
}
