package com.example.sem3_HomeTask.services;

import com.example.sem3_HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

//    @Autowired
    private UserService userService;
//    @Autowired

    /**
     *
     */
    private DataProcessingService dataProcessingService;
//    @Autowired
    /**
     * Поле сервиса консольных уведомлений
     */
    private NotificationService notificationService;

    public RegistrationService(UserService userService, DataProcessingService dataProcessingService, NotificationService notificationService) {
        this.userService = userService;
        this.dataProcessingService = dataProcessingService;
        this.notificationService = notificationService;
    }
    // д/з

    /**
     * Сохранение пользователя в БД
     * @param name имя пользователя
     * @param age возраст пользователя
     * @param email email пользователя
     */
    public void processRegistration(String name, int age, String email){
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.notifyUser(user);
    }

    /**
     * Получение сервиса работы с хранилищем пользователей
     * @return
     */

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
