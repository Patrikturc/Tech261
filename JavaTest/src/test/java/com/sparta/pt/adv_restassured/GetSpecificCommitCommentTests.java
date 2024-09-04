package com.sparta.pt.adv_restassured;

import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class GetSpecificCommitCommentTests extends BaseApiTestSetup {

    private Response response;

    @Override
    protected String getPath() {
        return "/repos/{owner}/{repo}/comments/{comment_id}";
    }

    @Override
    protected Map<String, Object> getPathParams() {
        return Map.of(
                "owner", "patrikturc",
                "repo", "Tech261",
                "comment_id", 146184534
        );
    }

    @Override
    protected String getHttpMethod() {
        return "GET";
    }

    @Override
    protected Object getRequestBody() {
        return null;
    }

    @BeforeEach
    public void setUp() {
        response = makeRequest(getHttpMethod(), getPath(), getPathParams(), getRequestBody());
    }

    @Test
    @DisplayName("Get comment with a specific ID returns a comment with that ID")
    void getCommentWithId_ReturnsThatComment() {
        int returnedCommentId = response.jsonPath().getInt("id");
        MatcherAssert.assertThat(returnedCommentId, Matchers.is(146184534));
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
