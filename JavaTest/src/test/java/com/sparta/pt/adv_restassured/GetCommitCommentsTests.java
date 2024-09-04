package com.sparta.pt.adv_restassured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetCommitCommentsTests extends BaseApiTestSetup {
    private static final String PATH = "/repos/{owner}/{repo}/comments";
    private static final String OWNER = "patrikturc";
    private static final String REPO_NAME = "Tech261";

    @Override
    protected String getPath() {
        return PATH;
    }

    @Override
    protected Map<String, Object> getPathParams() {
        return Map.of(
                "owner", OWNER,
                "repo", REPO_NAME
        );
    }

    @Test
    @DisplayName("Get all comments and check the status code")
    public void testStatusCode200() {
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("Check all repositories returns one comment")
    public void testAllRepositoriesReturnsOneComment() {
        MatcherAssert.assertThat(response.jsonPath().getList("id").size(), Matchers.is(1));
    }

    @Test
    @DisplayName("First comment has correct user name associated")
    void firstComment_HasCorrectUserNameAssociated() {
        MatcherAssert.assertThat(response.jsonPath().getString("user.login[0]").toLowerCase(), Matchers.is(OWNER));
    }
}