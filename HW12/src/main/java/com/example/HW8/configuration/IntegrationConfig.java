package com.example.HW8.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChanel(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel fileWriteChanel(){
        return  new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "inputChanel", outputChannel = "fileWriteChanel")

    public GenericTransformer<String, String> myTransformer(){
        return text->{

            return text;
        };
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriteChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(
                        "C:/Users/1/Desktop/ВидеоGB/Spring/HW/HW12/file"));

        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }


}
