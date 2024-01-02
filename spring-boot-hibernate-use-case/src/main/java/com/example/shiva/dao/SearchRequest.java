package com.example.shiva.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequest {
    private String firstName;
    private String lastName;
    private String email;
}
