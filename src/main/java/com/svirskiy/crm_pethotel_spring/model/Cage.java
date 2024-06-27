package com.svirskiy.crm_pethotel_spring.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Cage {
    private final String task;
    private final String time;
    private final String cage;
    private final String animal;
    private final String status;
}
