package org.larbcorp.services;

import lombok.RequiredArgsConstructor;
import org.larbcorp.exceptions.UserNotFoundException;
import org.larbcorp.exceptions.UsernameNotFoundException;
import org.larbcorp.models.Notification;
import org.larbcorp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.larbcorp.repositories.UserRepository;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<Notification> getAllNotifications(Long id) {
        return userRepository.findById(id).orElseThrow().getNotifications();
    }


//
//    public void delete(Long userId) {
//        userRepository.deleteById(userId);
//    }
//
//    public void freeze(Long userId) {
//        User user = userRepository.findById(userId)
//            .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
//
//        user.setIsActive(false);
//        userRepository.save(user);
//    }
//
//    public void unfreeze(Long userId) {
//        User user = userRepository.findById(userId)
//            .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
//
//        user.setIsActive(true);
//        userRepository.save(user);
//    }
//
//    public void addBalance(Long userId, BigDecimal amount) {
//        User user = userRepository.findById(userId)
//            .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found"));
//
//        BigDecimal newBalance = user.getBalance().add(amount);
//        user.setBalance(newBalance);
//        userRepository.save(user);
//    }
}

