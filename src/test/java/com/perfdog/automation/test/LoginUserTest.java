package com.perfdog.automation.test;

import com.perfdog.automation.config.BaseTest;
import com.perfdog.automation.model.User;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class LoginUserTest extends BaseTest {

    @Test
    public void testLoginWithCreatedUser() {
        String username = "login_user_" + System.currentTimeMillis();
        String password = "password123";
        User user = new User(102, username, "Test", "User", "test@example.com", password, "0000000000", 1);

        // Pre-requisite: Create user to ensure test independence
        given().contentType(ContentType.JSON).body(user).post("/user");

        // Execute Login API Call
        given()
                .queryParam("username", username)
                .queryParam("password", password)
                .when()
                .get("/user/login")
                .then()
                .statusCode(200)
                .body("message", containsString("logged in user session"));
    }
}