package br.com.joaogabriel.resource;

import br.com.joaogabriel.payload.request.RepositoryPatternRequest;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RepositoryPatternResourceTest {

    @Test
    public void testSaveEndpoint() {
        RestAssured.given()
                .log().all()
                .contentType("application/json")
                .body(new RepositoryPatternRequest("Repository", "Test", "Test"))
                .when()
                .post("/api/v1/repository")
                .then()
                .statusCode(201);
    }
}
