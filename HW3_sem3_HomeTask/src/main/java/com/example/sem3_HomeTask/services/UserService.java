package com.example.sem3_HomeTask.services;

import com.example.sem3_HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Autowired    // - если сделать @Autowired (автозаполнение), то конструктор не нужен, т.к. заполнение будет происходить автоматически
                    // но на лекции говорят, что надо делать через конструктор
    private NotificationService notificationService;

    //Внедрение зависимости через конструктор


    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public User createUser (String name, int age, String  email){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        notificationService.notifyUser(user);
        return user;
    }



}
