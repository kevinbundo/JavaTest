package com.example.springbasics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("smsNotificationService")
@Service
public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}