package com.perfdog.automation.test;

import com.perfdog.automation.config.BaseTest;
import com.perfdog.automation.model.Order;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateOrderTest extends BaseTest {

    @Test
    public void testCreateOrder() {
        Order order = new Order(5, 10, 2, "2026-09-02T12:00:00.000Z", "placed", true);

        given()
                .contentType(ContentType.JSON)
                .body(order)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .body("id", equalTo(5))
                .body("petId", equalTo(10))
                .body("status", equalTo("placed"));
    }
}