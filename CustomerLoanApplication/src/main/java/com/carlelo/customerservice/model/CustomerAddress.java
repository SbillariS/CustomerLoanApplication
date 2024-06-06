package com.carlelo.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerAddress
{
@Id
private int houseNo;
private String areaName;
private String district;
private String cityName;
private String stateName;
private int pinCode;
}
