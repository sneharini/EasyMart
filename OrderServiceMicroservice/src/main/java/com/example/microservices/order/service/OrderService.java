package com.example.microservices.order.service;


import com.example.microservices.order.client.InventoryClient;
import com.example.microservices.order.dto.OrderRequest;
import com.example.microservices.order.event.OrderPlacedEvent;
import com.example.microservices.order.model.Order;
import com.example.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest){
        var isProductIsInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductIsInStock){
            //map orderRequest to order object
            Order order  = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            // save order to orderRepository
            orderRepository.save(order);

            // send the messages to kafka topic
            // order number and email
            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent(order.getOrderNumber(), orderRequest.userDetails().email());
            log.info("start - Sending OrderPlaceEvent to Kafka topic", orderPlacedEvent);
            kafkaTemplate.send("order-placed", orderPlacedEvent);
            log.info("Ending - Sending OrderPlaceEvent to Kafka topic", orderPlacedEvent);


        }else{
            throw new RuntimeException("Product with skuCode" + orderRequest.skuCode() + "is not in a stock");
        }




    }
}
