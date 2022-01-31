package com.fooda.challenge.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Events {

    ArrayList<CustomerRequest> events;

    public Events() {
        events = new ArrayList<>();
    }
}
