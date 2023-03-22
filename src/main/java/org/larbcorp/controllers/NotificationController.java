//package org.larbcorp.controllers;
//
//import org.larbcorp.models.Notification;
//import org.larbcorp.services.NotificationService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/notifications")
//public class NotificationController {
//
//    private final NotificationService notificationService;
//
//    public NotificationController(NotificationService notificationService) {
//        this.notificationService = notificationService;
//    }
//
//    @GetMapping("/{username}")
//    public List<Notification> getNotificationsByUser(@PathVariable Long id) {
//        return notificationService.getNotificationsByUser(id);
//    }
//
//    @PostMapping
//    public void sendNotification(@RequestParam Long id, @RequestParam String title, @RequestParam String content) {
//        notificationService.sendNotification(id, title, content);
//    }
//}
