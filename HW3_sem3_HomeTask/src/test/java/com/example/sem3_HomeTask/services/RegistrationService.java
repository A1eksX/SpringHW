package com.example.sem3_HomeTask.services;

import com.example.sem3_HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

//    @Autowired
    private UserService userService;
//    @Autowired
    private DataProcessingService dataProcessingService;
//    @Autowired
    private NotificationService notificationService;

    public RegistrationService(UserService userService, DataProcessingService dataProcessingService, NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }
    // д/з
    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public UserService getUserService() {
        return userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
