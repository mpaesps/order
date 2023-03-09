package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client, List<OrderItem> orderItems) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.orderItems = orderItems;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void addItem(OrderItem item){
        orderItems.add(item);
    }
    public void removeItem(OrderItem item){
        orderItems.remove(item);
    }

    public double total(){
        double total = 0;
        for (OrderItem a: this.orderItems ){
            total += a.subTotal();

        }return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "moment=" + moment +
                ", status=" + status +
                ", client=" + client +
                ", orderItems=" + orderItems +
                '}';
    }
}
