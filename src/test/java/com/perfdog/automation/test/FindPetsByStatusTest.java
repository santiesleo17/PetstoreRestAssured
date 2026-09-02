package com.perfdog.automation.test;

import com.perfdog.automation.config.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;

/**
 * Requirement 3: List all pets that have "available" status.
 */
public class FindPetsByStatusTest extends BaseTest {

    @Test
    public void testListAvailablePets() {
        given()
                .queryParam("status", "available")
                .when()
                .get("/pet/findByStatus")
                .then()
                .statusCode(200)
                .body("status", everyItem(equalTo("available")));
    }
}