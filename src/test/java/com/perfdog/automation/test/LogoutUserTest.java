package com.perfdog.automation.test;

import com.perfdog.automation.config.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LogoutUserTest extends BaseTest {

    @Test
    public void testUserLogout() {
        given()
                .when()
                .get("/user/logout")
                .then()
                .statusCode(200)
                .body("message", equalTo("ok"));
    }
}