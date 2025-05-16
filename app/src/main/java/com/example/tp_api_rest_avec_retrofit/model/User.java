package com.example.tp_api_rest_avec_retrofit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("address")
    private Address address;

    public int getId() {return id; }
    public String getName() {return name; }
    public String getEmail() {return email; }
    public String getPhone() {return phone; }
    public Address getAddress() {return address; }

}
