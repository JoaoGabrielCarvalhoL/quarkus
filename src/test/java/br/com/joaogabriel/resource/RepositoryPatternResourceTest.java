package br.com.joaogabriel.resource;

import br.com.joaogabriel.payload.request.RepositoryPatternRequest;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.UUID;

@QuarkusTest
@TestMethodOrder(MethodOrderer.class)
public class RepositoryPatternResourceTest {

    private UUID id;

    @Test
    @Order(1)
    public void testSaveEndpoint() {
        RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(new RepositoryPatternRequest("Repository", "Test", "Test"))
                .when()
                .post("/api/v1/repository")
                .then()
                .log()
                .body()
                .statusCode(201);
    }
}
