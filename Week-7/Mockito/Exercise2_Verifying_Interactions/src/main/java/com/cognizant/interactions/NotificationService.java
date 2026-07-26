package com.cognizant.interactions;

public interface NotificationService {
    void sendNotification(String userId, String message);
    void sendEmail(String email, String subject, String body);
}
