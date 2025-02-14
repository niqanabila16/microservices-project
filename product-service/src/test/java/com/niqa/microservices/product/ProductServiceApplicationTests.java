package com.niqa.microservices.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;

import io.restassured.RestAssured;
import org.testcontainers.containers.MongoDBContainer;
import org.hamcrest.Matchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private int port;  

    @BeforeEach
    void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
        // System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }

    @Test
    void shouldCreateProduct() {
        String requestBody = """
        {
            "name": "iPhone 15",
            "description": "iPhone 15 is a smartphone from Apple",
            "price": 1000
        }
        """;

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/product")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("iPhone 15"))
                .body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple"));
    }
}

// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.context.annotation.Import;

// @Import(TestcontainersConfiguration.class)
// @SpringBootTest(webEnvironment = SpringBootTest.)
// class ProductServiceApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }
