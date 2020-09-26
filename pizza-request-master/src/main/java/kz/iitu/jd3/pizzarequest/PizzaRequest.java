package kz.iitu.jd3.pizzarequest;

import lombok.Getter;
import lombok.Setter;

public class PizzaRequest {

    private String userId;
    private Pizza pizza;

    public PizzaRequest() {
    }

    public PizzaRequest(String userId, Pizza pizza) {
        this.userId = userId;
        this.pizza = pizza;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "PizzaRequest{" +
                "userId='" + userId + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}
