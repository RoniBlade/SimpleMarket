package org.larbcorp.controllers;

import lombok.RequiredArgsConstructor;
import org.larbcorp.models.User;
import org.larbcorp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @GetMapping("/{user-id}")
    public User getUserByUsername(@PathVariable("user-id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.addUser(user);
//    }
//
//    @DeleteMapping("/{userId}")
//    public void delete(@PathVariable Long userId) {
//        userService.delete(userId);
//    }
//
//    @PutMapping("/{userId}/freeze")
//    public void freeze(@PathVariable Long userId) {
//        userService.freeze(userId);
//    }
//
//    @PutMapping("/{userId}/unfreeze")
//    public void unfreeze(@PathVariable Long userId) {
//        userService.unfreeze(userId);
//    }
//
//    @PutMapping("/{userId}/balance")
//    public void addBalance(@PathVariable Long userId, @RequestParam BigDecimal amount) {
//        userService.addBalance(userId, amount);
//    }
}

