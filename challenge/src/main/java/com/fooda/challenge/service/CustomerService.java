package com.fooda.challenge.service;

import com.fooda.challenge.model.Customer;
import com.fooda.challenge.model.CustomerRequest;
import com.fooda.challenge.model.Events;
import com.fooda.challenge.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public String addCustomers(Events events) {
        ArrayList<CustomerRequest> requests = events.getEvents();
        for(int i = 0; i < requests.size(); i++) {
            CustomerRequest request = requests.get(i);
            if (request.getAction().equals("new_customer")) {
                repository.save(new Customer(request.getName()));
            } else {
                int points = calculatePoints(request.getAmount(), request.getTimestamp());
                if(points >= 3 && points <= 20) {
                    Customer customer = repository.getById(request.getCustomer());
                    customer.addOrderCount();
                    customer.addPoints(points);
                    repository.save(customer);
                }
            }
        }
        List<Customer> allCustomers = repository.findAll();
        String report = "";
        for(int i = 0; i < allCustomers.size(); i++) {
            report += allCustomers.get(i) + "\n";
        }
        return report;
    }

    private int calculatePoints(double amount, Timestamp time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int hour = calendar.get(calendar.HOUR_OF_DAY);
        if(hour == 12) {
            return (int)Math.ceil(amount / 3);
        }
        else if(hour == 11 || hour == 13) {
            return (int)Math.ceil(amount / 2);
        }
        else if(hour == 10 || hour == 14) {
            return (int)Math.ceil(amount);
        }
        else {
            return (int)Math.ceil(amount * .25);
        }
    }

}
