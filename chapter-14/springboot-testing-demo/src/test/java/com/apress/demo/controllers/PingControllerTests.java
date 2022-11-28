/**
 *
 */
package com.apress.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Siva
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PingControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testPing() throws Exception {
        ResponseEntity<String> respEntity =
                restTemplate
                        .withBasicAuth("admin", "admin123")
                        .getForEntity("/ping", String.class);
        assertThat(respEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(respEntity.getBody()).isEqualTo("OK");
    }
}
