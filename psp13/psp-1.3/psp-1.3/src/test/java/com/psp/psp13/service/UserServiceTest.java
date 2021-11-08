package com.psp.psp13.service;

import com.psp.psp13.model.User;
import com.psp.psp13.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository repository;
    @InjectMocks
    UserService service;

    @Test
    void findAllTest(){
        User user = new User();
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(repository.findAll()).thenReturn(userList);
        List<User> found = service.findAll();

        verify(repository).findAll();
        assertEquals(1, found.size());
    }

    @Test
    void findByIdTest(){
        User user = new User();
        when(repository.findById(anyLong())).thenReturn(java.util.Optional.of(user));

        Optional<User> found = service.findUserById(1L);
        verify(repository).findById(anyLong());

        assertNotNull(found);
    }

    @Test
    void updateTest(){
        User user = new User();
        service.update(user);
        verify(repository).save(Mockito.any(User.class));
    }

    @Test
    void addTest(){
        User user = new User();
        when(repository.save(Mockito.any(User.class))).thenReturn(user);

        User added = service.add(user);
        verify(repository).save(Mockito.any(User.class));
        assertNotNull(added);
    }

    @Test
    void deleteTest(){
        User user = new User();
        service.delete(user);
        verify(repository).delete(Mockito.any(User.class));
    }

    @Test
    void deleteByIdTest(){
        service.deleteById(1L);
        verify(repository).deleteById(Mockito.anyLong());
    }


}
