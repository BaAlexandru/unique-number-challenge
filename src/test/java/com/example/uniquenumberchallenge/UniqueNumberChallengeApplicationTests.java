package com.example.uniquenumberchallenge;

import com.example.uniquenumberchallenge.controller.SimpleController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UniqueNumberChallengeApplicationTests {

    @Autowired
    private SimpleController controller;

    @Test
    public void contextLoadsTest() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void isNotNullTest() throws Exception {
        assertThat(controller.generateUniqueNumber(2)).isNotNull();
    }

    @Test
    public void isOKTest() throws Exception {
        assertThat(controller.generateUniqueNumber(3).getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void notCorrectInputTest() throws Exception {
        assertThat(controller.generateUniqueNumber(0)).toString().contains("Please provide 2 or 3 as an input. Not an option");
    }

    @Test
    public void sumOfTwoTest() throws Exception {
        assertThat(controller.generateUniqueNumber(2).getBody()).toString().contains("8614");
    }

    @Test
    public void sumOfThreeTest() throws Exception {
        assertThat(controller.generateUniqueNumber(3)).toString().contains("303394260");
    }
}
