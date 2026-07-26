package com.cognizant.interactions;

public class UserManager {

    private final NotificationService notificationService;

    public UserManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void registerUser(String userId, String email) {
        notificationService.sendNotification(userId, "Welcome " + userId);
        notificationService.sendEmail(email, "Registration Successful", "Welcome to EduPortal");
    }

    public void notifyUser(String userId, String message) {
        if (userId != null && !userId.trim().isEmpty()) {
            notificationService.sendNotification(userId, message);
        }
    }
}
