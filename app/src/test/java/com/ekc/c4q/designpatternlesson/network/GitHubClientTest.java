package com.ekc.c4q.designpatternlesson.network;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GitHubClientTest {

  @Test
  public void getInstance_returnsSameInstance() {
    GitHubClient client = GitHubClient.getInstance();
    GitHubClient client2 = GitHubClient.getInstance();

    assertThat(client).isSameAs(client2);
  }
}