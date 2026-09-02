package com.perfdog.automation.test;

import com.perfdog.automation.config.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Requirement 4: Query data of a specific pet.
 */
public class GetPetTest extends BaseTest {

    @Test
    public void testGetPetById() {
        long petId = 10;

        given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) petId));
    }
}