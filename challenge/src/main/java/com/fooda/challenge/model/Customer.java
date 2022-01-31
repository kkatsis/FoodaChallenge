package com.fooda.challenge.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @Column(name = "name")
    String name;

    @Column(name = "orders")
    int orders;

    @Column(name = "points")
    double points;

    public void addOrderCount(){
        orders++;
    }

    public void addPoints(double points){
        this.points += points;
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
        orders = 0;
        points = 0;
    }

    @Override
    public String toString() {
        if(points == 0) {
            return name + ": No orders.";
        }
        else {
            return name + ": " + (int)points + " points with " + (int)(points/orders) + " points per order.";
        }
    }
}
