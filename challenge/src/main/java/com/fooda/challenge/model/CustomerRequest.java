package com.fooda.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    String action;
    String name;
    String customer;
    double amount;
    Timestamp timestamp;
}
