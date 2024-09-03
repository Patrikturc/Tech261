package com.sparta.pt.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SinglePostcodeTest {

    private static Response response;

    @BeforeAll
    static void beforeAll(){
        response = RestAssured
                .given()
                .baseUri("https://api.postcodes.io")
                .basePath("/postcodes")
                .header("Accept", "test/json")
                .when()
                .get("/EC2Y5AS")
                .thenReturn();
    }

    @Test
    @DisplayName("Test that the name of the Primary Care Trust is City and Hackney Teaching")
    void testPrimaryCareTrustNameIsReturned(){
        MatcherAssert.assertThat(response.jsonPath().getString("result.primary_care_trust"), Matchers.is("City and Hackney Teaching"));
    }

    @Test
    @DisplayName("Test that the total number of codes returned is 14")
    void testTotalCodesReturned(){
        MatcherAssert.assertThat(response.jsonPath().getMap("result.codes").size(), Matchers.is(14));
    }

    @Test
    @DisplayName("Status code 200 returned")
    void testStatusCode200(){
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }

    @Test
    @DisplayName("There server name in the headers is cloudflare")
    void testServerNameInHeadersIsCloudflare(){
        MatcherAssert.assertThat(response.header("Server"), Matchers.is("cloudflare"));

    }

    @Test
    @DisplayName("Correct postcode returned in response")
    void testCorrectPostcodeReturnedInResponse(){
        MatcherAssert.assertThat(response.jsonPath().getString("result.postcode"), Matchers.is("EC2Y 5AS"));

    }

    @Test
    @DisplayName("Status code 200 returned v2")
    void testStatusCode200_v2(){
        RestAssured
                .get("https://api.postcodes.io/postcodes/EC2Y5As")
                .then()
                .assertThat()
                .statusCode(200);
    }
}