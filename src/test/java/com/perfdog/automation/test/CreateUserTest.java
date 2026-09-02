package com.perfdog.automation.test;

import com.perfdog.automation.config.BaseTest;
import com.perfdog.automation.model.User;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest extends BaseTest {

    @Test
    public void testCreateUser() {
        User user = new User(101, "john_doe", "John", "Doe", "john@example.com", "pass123", "1234567890", 1);

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo("101"));
    }
}