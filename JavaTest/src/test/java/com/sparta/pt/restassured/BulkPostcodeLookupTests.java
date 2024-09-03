package com.sparta.pt.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class BulkPostcodeLookupTests {
    private static Response response;

    @BeforeAll
    static void beforeAll(){

        response = RestAssured
                .given()
                .baseUri("https://api.postcodes.io")
                .basePath("/postcodes")
                .headers(Map.of(
                        "Accept", "test/json",
                        "Content-Type","application/json"
                ))
                .body("{\"postcodes\": [\"OX49 5NU\", \"M32 0JG\", \"NE30 1DP\"]}")
                .when()
                .post()
                .thenReturn();
    }

    @Test
    @DisplayName("Status code 200 returned")
    void testStatusCode200(){
        MatcherAssert.assertThat(response.statusCode(), Matchers.is(200));
    }
    @Test
    @DisplayName("Response contains all requested postcodes")
    void testResponseContainsAllPostcodes() {
        String[] postcodesArray = {"OX49 5NU", "M32 0JG", "NE30 1DP"};
        for (String postcode : postcodesArray) {
            MatcherAssert.assertThat(
                    response.jsonPath().getList("result.query"),
                    Matchers.hasItem(postcode)
            );
        }
    }

    @Test
    @DisplayName("Postcode data is returned correctly for OX49 5NU")
    void testPostcodeDataOX495NU() {
        MatcherAssert.assertThat(
                response.jsonPath().getString("result[0].result.postcode"),
                Matchers.is("OX49 5NU")
        );
        MatcherAssert.assertThat(
                response.jsonPath().getInt("result[0].result.eastings"),
                Matchers.is(464438)
        );
        MatcherAssert.assertThat(
                response.jsonPath().getString("result[0].result.country"),
                Matchers.is("England")
        );
    }
    @Test
    @DisplayName("Check that admin_district and parish are correct for NE30 1DP")
    void testAdminDistrictAndParishNE301DP() {
        MatcherAssert.assertThat(
                response.jsonPath().getString("result[2].result.admin_district"),
                Matchers.is("North Tyneside")
        );
        MatcherAssert.assertThat(
                response.jsonPath().getString("result[2].result.parish"),
                Matchers.is("North Tyneside, unparished area")
        );
    }
    @Test
    @DisplayName("All postcodes have a non-null result field")
    void testNonNullResultFields() {
        MatcherAssert.assertThat(
                response.jsonPath().getList("result.result"),
                Matchers.everyItem(Matchers.notNullValue())
        );
    }

    @Test
    @DisplayName("All postcodes have valid 'codes' field")
    void testCodesFieldIsPresent() {
        for (int i = 0; i < 3; i++) {
            MatcherAssert.assertThat(
                    response.jsonPath().getMap("result[" + i + "].result.codes"),
                    Matchers.notNullValue()
            );
        }
    }
}
