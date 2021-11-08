package com.psp.psp13.service;

import com.psp.psp13.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ValidationServiceTest {

    ValidationService validationService = new ValidationService();

    @Test
    public void validationPasswordTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(1L, "Vardas","Pavarde","860000000","pastas@gmail.com","adreso g. 1","a");
            validationService.validate(user);
        });

        String expectedMessage = "Invalid password";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validationEmailTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(1L, "Vardas","Pavarde","860000000","pa#$.tas@gmail.com","adreso g. 1","Password.1");
            validationService.validate(user);
        });

        String expectedMessage = "Invalid email address";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void validationNumberTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User(1L, "Vardas","Pavarde","8600aa000","pastas@gmail.com","adreso g. 1","Password.1");
            validationService.validate(user);
        });

        String expectedMessage = "Invalid phone number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
