package com.cognizant.interactions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;

@ExtendWith(MockitoExtension.class)
public class UserManagerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private UserManager userManager;

    @Test
    public void testRegisterUserInteractions() {
        userManager.registerUser("user101", "user101@example.com");

        verify(notificationService, times(1)).sendNotification("user101", "Welcome user101");
        verify(notificationService, times(1)).sendEmail("user101@example.com", "Registration Successful", "Welcome to EduPortal");
    }

    @Test
    public void testNotifyUserValid() {
        userManager.notifyUser("user102", "Important Update");

        verify(notificationService).sendNotification("user102", "Important Update");
    }

    @Test
    public void testNotifyUserInvalidEmpty() {
        userManager.notifyUser("  ", "Important Update");

        verify(notificationService, never()).sendNotification("  ", "Important Update");
    }
}
