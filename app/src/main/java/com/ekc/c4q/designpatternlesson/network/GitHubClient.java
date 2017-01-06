package com.ekc.c4q.designpatternlesson.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubClient {

  public static final String API_URL = "https://api.github.com";

  private final GitHubApi api;

  private GitHubClient(GitHubApi api) {
    this.api = api;
  }

  public static GitHubClient getInstance() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    GitHubApi api = retrofit.create(GitHubApi.class);

    return new GitHubClient(api);
  }
}
