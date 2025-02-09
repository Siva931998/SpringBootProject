package com.tech.java.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Employeedto {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
}
