package com.example.HW8.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "inputChanel")
public interface Gateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
