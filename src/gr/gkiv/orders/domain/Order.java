package gr.gkiv.orders.domain;

import java.sql.PreparedStatement;
import java.time.LocalDateTime;

public class Order {
    private long id;
    private Customer customer;
    private OrderStatus status;
    private Channel channel;
    private LocalDateTime createdAt;
    private String notes;

    public Order() {}

    public Order(long id, Customer customer, Channel channel, String notes) {
        this.id = id;
        this.customer = customer;
        this.channel = channel;
        this.notes = notes;
        status = OrderStatus.NEW;
        createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Channel getChannel() {
        return channel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getNotes() {
        return notes;
    }

    // Public API

    public void changeStatus(OrderStatus newStatus) {
        OrderStatus currentStatus = getStatus();

        if (currentStatus == OrderStatus.NEW) {
            if (newStatus == OrderStatus.IN_PROGRESS || newStatus == OrderStatus.CANCELED) {
                this.status = newStatus;
            } else {
                throw new InvalidOrderStateException("Cannot change status from " + currentStatus + " to " + newStatus);
            }
        } else if (currentStatus == OrderStatus.IN_PROGRESS) {
            if (newStatus == OrderStatus.READY || newStatus == OrderStatus.CANCELED) {
                this.status = newStatus;
            } else {
                throw new InvalidOrderStateException("Cannot change status from " + currentStatus + " to " + newStatus);
            }
        } else if (currentStatus == OrderStatus.READY) {
            if (newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELED) {
                this.status = newStatus;
            } else {
                throw new InvalidOrderStateException("Cannot change status from " + currentStatus + " to " + newStatus);
            }
        }
    }
}
