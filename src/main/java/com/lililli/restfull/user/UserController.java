package com.lililli.restfull.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
public class UserController {
    private UserDaoService service;

    @GetMapping(value = "/users")
    public List<User> retriveAllUsers() {
        return service.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User retriveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("ID[" + id + "] is not found!");
        }
        return user;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{id}")
    public int getMethodName(@PathVariable int id) {
        User user = service.deleteById(id);
        if (user == null) {
            return 0;
        }
        return 1;
    }

}
