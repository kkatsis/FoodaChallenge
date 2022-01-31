package com.fooda.challenge.controller;

import com.fooda.challenge.model.Events;
import com.fooda.challenge.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Void> ping(){
        System.out.println("HELLO WORLD");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/customer")
    public ResponseEntity<String> readRequest(@RequestBody Events events) {
        return ResponseEntity.ok(customerService.addCustomers(events));
    }
}
