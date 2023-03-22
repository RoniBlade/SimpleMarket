package org.larbcorp.services;

import lombok.RequiredArgsConstructor;
import org.larbcorp.exceptions.UsernameNotFoundException;
import org.larbcorp.models.Notification;
import org.larbcorp.models.User;
import org.larbcorp.repositories.NotificationRepository;
import org.larbcorp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    public List<Notification> getNotificationsByUser(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("User with username " + id + " not found"));
        return notificationRepository.findByUser(user);
    }

    public void sendNotification(Long id, String title, String content) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException("User with username " + id + " not found"));

        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setContent(content);
        notification.setCreatedDate(LocalDateTime.now());
        notification.setUser(user);

        notificationRepository.save(notification);
    }
}
