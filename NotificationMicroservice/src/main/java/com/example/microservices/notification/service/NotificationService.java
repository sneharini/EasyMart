package com.example.microservices.notification.service;


import com.example.microservices.order.event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final JavaMailSender mailSender;
    @KafkaListener(topics = "order-placed",groupId = "notificationService")
    public void consume(OrderPlacedEvent orderPlacedEvent){
        log.info("Got message from order-placed topic", orderPlacedEvent);


        // Send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(orderPlacedEvent.getEmail());
        message.setSubject("Order Confirmation");
        message.setText("Your order with number " + orderPlacedEvent.getOrderNumber() + " has been placed successfully!");

        mailSender.send(message);
        log.info("Notification sent", orderPlacedEvent);

    }
}
