package com.sparta.pt.adv_restassured;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetSpecificCommitCommentTests extends BaseApiTestSetup {
    private static final String PATH = "/repos/{owner}/{repo}/comments/{comment_id}";
    private static final String OWNER = "patrikturc";
    private static final String REPO_NAME = "Tech261";
    private static final int COMMENT_ID = 146184534;

    @Override
    protected String getPath() {
        return PATH;
    }

    @Override
    protected Map<String, Object> getPathParams() {
        return Map.of(
                "owner", OWNER,
                "repo", REPO_NAME,
                "comment_id", COMMENT_ID
        );
    }

    @Test
    @DisplayName("Get comment with a specific ID returns a comment with that ID")
    void getCommentWithId_ReturnsThatComment() {
        int returnedCommentId = response.jsonPath().getInt("id");
        MatcherAssert.assertThat(returnedCommentId, Matchers.is(COMMENT_ID));
    }

    @Test
    @DisplayName("Get comment with a specific ID and check the Server header")
    void getCommentWithId_ChecksServerHeader() {
        String serverHeader = response.getHeader("Server");
        MatcherAssert.assertThat(serverHeader, Matchers.is("github.com"));
    }

    @Test
    @DisplayName("Get comment with a specific ID and check the status code")
    void getCommentWithId_ChecksStatusCode() {
        int statusCode = response.getStatusCode();
        MatcherAssert.assertThat(statusCode, Matchers.is(200));
    }

    @Test
    @DisplayName("Get comment with a specific ID and check the reactions total count")
    void getCommentWithId_ChecksReactionsTotalCount() {
        int reactionsTotalCount = response.jsonPath().getInt("reactions.total_count");
        MatcherAssert.assertThat(reactionsTotalCount, Matchers.is(0));
    }
}