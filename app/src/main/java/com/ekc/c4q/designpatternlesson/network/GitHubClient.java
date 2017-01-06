package com.ekc.c4q.designpatternlesson.network;

public class GitHubClient {

  public static final String API_URL = "https://api.github.com";

  private final GitHubApi api;

  private GitHubClient(GitHubApi api) {
    this.api = api;
  }

  public static GitHubClient getInstance() {
    // TODO by you
    return null;
  }
}
