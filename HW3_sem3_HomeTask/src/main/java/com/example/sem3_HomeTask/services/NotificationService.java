package com.example.sem3_HomeTask.services;

import com.example.sem3_HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user){
        System.out.println("A new user has been created: " + user.getName());
    }
}
