package kz.iitu.jd3.pizzarequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final String TOPIC = "pizza_requests";

    @Autowired
    private KafkaTemplate<String, PizzaRequest> kafkaTemplate;

    public String pizzaRequestNotify(PizzaRequest pizzaRequest) {
        System.out.println(String.format("#### -> Producing book request to notification service -> %s", pizzaRequest));
        this.kafkaTemplate.send(TOPIC, pizzaRequest);
        return "Successfully";
    }
}