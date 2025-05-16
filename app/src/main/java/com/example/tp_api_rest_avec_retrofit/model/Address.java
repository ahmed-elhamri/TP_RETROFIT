package com.example.tp_api_rest_avec_retrofit.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;

    // Getters
    public String getStreet() { return street; }
    public String getSuite() { return suite; }
    public String getCity() { return city; }
    public String getZipcode() { return zipcode; }
}
