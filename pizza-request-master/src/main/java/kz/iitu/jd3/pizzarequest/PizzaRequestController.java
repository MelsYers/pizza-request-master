package kz.iitu.jd3.pizzarequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Pizza/request")
public class PizzaRequestController {

    private final Producer producer;
    private PizzaInformationService pizzaInformationService;

    @Autowired
    public PizzaRequestController(Producer producer, PizzaInformationService pizzaInformationService) {
        this.producer = producer;
        this.pizzaInformationService = pizzaInformationService;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("pizzaId") String pizzaId) {

        PizzaRequest pizzaRequest = new BookRequest(userId, pizzaInformationService.getPizzaById(pizzaId));
        this.producer.pizzaRequestNotify(pizzaRequest);
        return "Your request sent successful!";
    }
}