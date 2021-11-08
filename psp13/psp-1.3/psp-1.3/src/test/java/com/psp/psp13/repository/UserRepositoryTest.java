package com.psp.psp13.repository;

import com.psp.psp13.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;



    @Test
    public void findAllTest(){
        User user = new User(1L, "Vardas","Pavarde","860000000","pastas@gmail.com","adreso g. 1","Password.1");
        userRepository.save(user);
        Iterable<User> users = userRepository.findAll();
        assertNotNull(users);

        List<User> result = new ArrayList<>();
        users.forEach(result::add);
        assertEquals(1, result.size());
    }

    @Test
    public void saveTest(){
        User user = new User(1L, "Vardas","Pavarde","860000000","pastas@gmail.com","adreso g. 1","Password.1");
        userRepository.save(user);

        Optional<User> userById = userRepository.findById(1L);
        assertNotNull(userById);
    }

    @Test
    public void deleteTest(){
        User user = new User(1L, "Vardas","Pavarde","860000000","pastas@gmail.com","adreso g. 1","Password.1");
        userRepository.save(user);
        userRepository.deleteById(1L);
        Iterable<User> users = userRepository.findAll();
        assertNotNull(user);

        List<User> result = new ArrayList<>();
        users.forEach(result::add);
        assertEquals(0, result.size());
    }
}
